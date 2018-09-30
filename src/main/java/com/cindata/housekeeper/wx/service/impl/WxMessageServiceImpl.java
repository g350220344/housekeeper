package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.controller.WeixinServer;
import com.cindata.housekeeper.web.model.WxTemplate;
import com.cindata.housekeeper.wx.dao.WxHouseAvmLogMapper;
import com.cindata.housekeeper.wx.dao.WxHouseInfoMapper;
import com.cindata.housekeeper.wx.dao.WxMessageMapper;
import com.cindata.housekeeper.wx.model.*;
import com.cindata.housekeeper.wx.service.WxMessageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.cindata.housekeeper.wx.common.tools.MsgUtil.*;

@Service
public class WxMessageServiceImpl implements WxMessageService {


	@Resource
	private WxMessageMapper wxMessageMapper;
    @Resource
    private WxHouseAvmLogMapper wxHouseAvmLogMapper;
    @Resource
    private WxHouseInfoMapper wxHouseInfoMapper;
	@Override
	public int addMessage(WxMessage wxMessage) {
		return wxMessageMapper.insertSelective(wxMessage);
	}

	@Override
	public List<WxMessage> selectMessageByUserId(String userId) {

		WxMessageExample wxMessageExample = new WxMessageExample();
		WxMessageExample.Criteria criteria = wxMessageExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<WxMessage> list = wxMessageMapper.selectByExample(wxMessageExample);
		return list;
	}

    @Override
    public Map sendMsg(WxUserInfo user, List<WxLoanInfo> wxLoanInfoList, List<WxRentInfo> wxRentInfoList, String date,String accessToken) {
        Map map = new HashMap();
        map.put("sms","ok");
        String userId = user.getUserId();
        try {
            //判断是否有月供提醒
            for(int i=0;i<wxLoanInfoList.size();i++){
                WxLoanInfo wxLoanInfo =  wxLoanInfoList.get(i);
                java.sql.Date loanDate =  wxLoanInfo.getLoanTime();
                int term = StringUtil.parseInt(wxLoanInfo.getTerm(),0);
                if(term > 0){
                    String nowDate = StringUtil.getDayDate(StringUtil.formatStringDate(date,"yyyy-MM-dd"),monthDay);
                    for(int j=0;j<term;j++){
                        String loansDate = StringUtil.getMonth(loanDate,j);
                        if(nowDate.equals(loansDate)){
                            //判断成功，需要提醒
                            String msgDate = StringUtil.dateFormat(nowDate,"yyyy年MM月dd日","",2);
                            String money = "";
                            if (StringUtils.isNotBlank(wxLoanInfo.getRepayment())) {
                                double invest = wxLoanInfo.getMoney().doubleValue() * 10000; // 本金
                                int month = wxLoanInfo.getTerm().intValue(); // 期数
                                double yearRate = wxLoanInfo.getRate().doubleValue() / 100; // 年利率
                                if (wxLoanInfo.getRepayment().equals("等额本息")) {
                                    money = EqualAmountOfInterestUtils.getPerMonthPrincipalInterest(invest, yearRate, month)+"";
                                } else if (wxLoanInfo.getRepayment().equals("等额本金")) {
                                    Map<Integer, Double> getPerMonthPrincipalInterest = EqualAmountOfPrincipalUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
                                    Iterator<Map.Entry<Integer, Double>> iterator = getPerMonthPrincipalInterest.entrySet().iterator();
                                    while (iterator.hasNext()) {
                                        Map.Entry<Integer, Double> entry = iterator.next();
                                        if (entry.getKey().toString().equals(j+1 + "")) {
                                            money = entry.getValue().toString();
                                            break;
                                        }
                                    }
                                }
                            }
                            String title = monthTitle;
                            title = title.replace("#channelName#",wxLoanInfo.getChannelName());
                            title = title.replace("#money#",money);
                            title = title.replace("#typeName#",wxLoanInfo.getTypeName());
                            title = title.replace("#date#",msgDate);
                            title = title.replace("#text#",j+1+"/"+term);
                            //短信月供提醒
                            if(user.getSmsMonth().equals(new BigDecimal(1))&&StringUtil.isNotNullOrEmpty(user.getMobile())){

                                SMSUtil.sendSms( "【房产管家】 "+title, user.getMobile().toString());
                            }

                            //消息月供提醒
                            if(user.getMessageMonth().equals(new BigDecimal(1))){



                                WxMessage wxMessage = new WxMessage();
                                wxMessage.setTitle(title);
                                wxMessage.setUserId(userId);
                                wxMessage.setDataId(wxLoanInfo.getHouseId());
                                wxMessage.setCreateDate(new Date(System.currentTimeMillis()));
                                wxMessage.setIsRead(new BigDecimal(0));
                                wxMessage.setType(new BigDecimal(2));
                                addMessage(wxMessage);
                            }
                            //公众号推送消息
                            if(StringUtil.isNotNullOrEmpty(accessToken)){
                                String jsonData = null;
                                WxTemplate wxTemplate = new WxTemplate();
                                Map map1 = new HashMap();
                                map1.put("value","您有一份月供还款提醒！");
                                map1.put("color","#173177");
                                wxTemplate.setFirst(map1);
                                Map map2 = new HashMap();
                                map2.put("value",money+"元");
                                map2.put("color","#173177");
                                wxTemplate.setKeyword1(map2);
                                Map map3 = new HashMap();
                                map3.put("color","#173177");
                                map3.put("value",msgDate);
                                wxTemplate.setKeyword2(map3);
                                Map map4 = new HashMap();
                                map4.put("color","#173177");
                                map4.put("value","第"+(j+1)+"/"+term+"期");
                                wxTemplate.setKeyword3(map4);
                                Map map5 = new HashMap();
                                map5.put("color","#173177");
                                map5.put("value","请及时处理");
                                wxTemplate.setRemark(map5);
                                Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                                jsonData = g.toJson(wxTemplate);
                                WeixinServer.sendMsg(accessToken,user.getWxOpenid(),monthTemplateId,jsonData);
                            }
                        }
                    }
                }

            }

            //判断是否有房租提醒
            for(int i=0;i<wxRentInfoList.size();i++){
                WxRentInfo wxRentInfo =  wxRentInfoList.get(i);
                java.sql.Date leaseDate =  wxRentInfo.getLeaseTime();
                int term = StringUtil.parseInt(wxRentInfo.getTerm(),0);
                if(term > 0){
                    WxHouseInfo wxHouseInfo = wxHouseInfoMapper.selectByPrimaryKey(StringUtil.parseBigDecimal(wxRentInfo.getHouseId(),null));
                    for(int j=0;j<term;){
                        //根据收租形式作相应处理
                        if(wxRentInfo.getCycle().equals(new BigDecimal(1))){
                        //按月
                            j++;
                        }
                        if(wxRentInfo.getCycle().equals(new BigDecimal(2))){
                        //按季度
                            j = j + 3;
                        }
                        if(wxRentInfo.getCycle().equals(new BigDecimal(3))){
                        //按年
                            j = j + 12;
                        }
                        String nowDate = StringUtil.getDayDate(StringUtil.formatStringDate(date,"yyyy-MM-dd"),rentDay);
                        if(nowDate.equals(StringUtil.getMonth(leaseDate,j))){
                            //判断成功，需要提醒
                            String msgDate = StringUtil.dateFormat(nowDate,"yyyy年MM月dd日","",2);
                            String title = rentTitle;
                            title = title.replace("#leaseName#",wxRentInfo.getLeaseName());
                            title = title.replace("#money#",wxRentInfo.getMoney().toString());
                            title = title.replace("#date#",msgDate);
                            //短信收租提醒
                            if(user.getSmsRent().equals(new BigDecimal(1))&&StringUtil.isNotNullOrEmpty(user.getMobile())){
                                SMSUtil.sendSms( "【房产管家】 "+title, user.getMobile().toString());
                            }

                            //消息收租提醒
                            if(user.getMessageRent().equals(new BigDecimal(1))){

                                WxMessage wxMessage = new WxMessage();
                                wxMessage.setTitle(title);
                                wxMessage.setUserId(userId);
                                wxMessage.setDataId(wxRentInfo.getHouseId());
                                wxMessage.setCreateDate(new Date(System.currentTimeMillis()));
                                wxMessage.setIsRead(new BigDecimal(0));
                                wxMessage.setType(new BigDecimal(3));
                                addMessage(wxMessage);
                            }
                            //公众号推送消息
                            if(StringUtil.isNotNullOrEmpty(accessToken)){
                                String jsonData = null;
                                WxTemplate wxTemplate = new WxTemplate();
                                Map map1 = new HashMap();
                                map1.put("value","该收房租啦！");
                                map1.put("color","#173177");
                                wxTemplate.setFirst(map1);
                                Map map2 = new HashMap();
                                map2.put("value",wxHouseInfo.getCityName()+"  "+wxHouseInfo.getCommunityName());
                                map2.put("color","#173177");
                                wxTemplate.setKeyword1(map2);
                                Map map3 = new HashMap();
                                map3.put("color","#173177");
                                map3.put("value",wxRentInfo.getLeaseName());
                                wxTemplate.setKeyword2(map3);
                                Map map4 = new HashMap();
                                map4.put("color","#173177");
                                map4.put("value",wxRentInfo.getMoney()+"元");
                                wxTemplate.setKeyword3(map4);
                                Map map5 = new HashMap();
                                map5.put("color","#173177");
                                map5.put("value",msgDate);
                                wxTemplate.setKeyword4(map5);
                                Map map6 = new HashMap();
                                map6.put("color","#173177");
                                map6.put("value","详情可点击查看");
                                wxTemplate.setKeyword5(map6);
                                Map map7 = new HashMap();
                                map7.put("color","#173177");
                                map7.put("value","请及时处理。");
                                wxTemplate.setRemark(map7);
                                Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                                jsonData = g.toJson(wxTemplate);
                                WeixinServer.sendMsg(accessToken,user.getWxOpenid(),rentTemplateId,jsonData);
                            }
                        }
                    }
                }

            }
            //java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
            //java.sql.Date date = StringUtil.getDate("2018-01-31");
            //log.error(StringUtil.getMonth(date,3));
            map.put("status","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","2");
        }
        return map;
    }

    @Override
    public Map sendHouseMsg(WxUserInfo wxUserInfo, List<WxHouseInfo> wxHouseInfoList, String day,String accessToken) {
        Map map = new HashMap();
        map.put("sms","ok");
        try {
            for(int i=0;i<wxHouseInfoList.size();i++){
                WxHouseInfo wxHouseInfo = wxHouseInfoList.get(i);
                String title = priceTitle;
                title = title.replace("#name#" ,wxHouseInfo.getCityName()+" "+wxHouseInfo.getCommunityName());
                title = title.replace("#date#",StringUtil.dateFormat(day,"MM月","",2));
                //当前总价估价
                if( wxHouseInfo.getAssessSalePrice()==null){
                    continue;
                }
                BigDecimal price = wxHouseInfo.getAssessSalePrice().multiply(wxHouseInfo.getBuildingsquare());
                //上月总价估价
                WxHouseAvmLogExample wxHouseAvmLogExample =new WxHouseAvmLogExample();
                com.cindata.housekeeper.wx.model.WxHouseAvmLogExample.Criteria cri = wxHouseAvmLogExample.createCriteria();
                cri.andHouseIdEqualTo(wxHouseInfo.getHouseId());
                wxHouseAvmLogExample.setOrderByClause(" ASSESS_TIME DESC");
                List<WxHouseAvmLog> wxHouseAvmLogList = wxHouseAvmLogMapper.selectByExample(wxHouseAvmLogExample);
                String text = "涨了--万，涨幅--%";
                if(!wxHouseAvmLogList.isEmpty()){
                    if( wxHouseAvmLogList.get(0).getAssessSalePrice()==null){
                        continue;
                    }
                    BigDecimal lastPrice = wxHouseAvmLogList.get(0).getAssessSalePrice().multiply(wxHouseInfo.getBuildingsquare());
                    BigDecimal ss = (price.subtract(lastPrice)).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP);
                    Double risePercent = 0d;
                    if(!ss.toString().equals("0")){
                        risePercent = CommonHelper.getRisePercentNoParam(price,lastPrice);
                    }
                    BigDecimal   b   =   new   BigDecimal(risePercent);
                    risePercent   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                    if(risePercent>=0){
                        text = "涨了"+ss+"万,涨幅"+risePercent+"%";
                    }else{
                        text = "降了"+ss+"万,降幅"+risePercent+"%";
                    }
                }
                title = title.replace("#text#",text);
                //短信房价提醒
                if(wxUserInfo.getSmsPrice().equals(new BigDecimal(1))&&StringUtil.isNotNullOrEmpty(wxUserInfo.getMobile())){
                    SMSUtil.sendSms( "【房产管家】 "+title, wxUserInfo.getMobile().toString());
                }

                //消息房价提醒
                if(wxUserInfo.getMessagePrice().equals(new BigDecimal(1))){



                    WxMessage wxMessage = new WxMessage();
                    wxMessage.setTitle(title);
                    wxMessage.setUserId(wxUserInfo.getUserId());
                    wxMessage.setDataId(wxHouseInfo.getHouseId().toString());
                    wxMessage.setCreateDate(new Date(System.currentTimeMillis()));
                    wxMessage.setIsRead(new BigDecimal(0));
                    wxMessage.setType(new BigDecimal(1));
                    addMessage(wxMessage);
                }
                //公众号推送消息
                if(StringUtil.isNotNullOrEmpty(accessToken)){
                    String jsonData = null;
                    WxTemplate wxTemplate = new WxTemplate();
                    Map map1 = new HashMap();
                    map1.put("value","最新房价提醒通知！");
                    map1.put("color","#173177");
                    wxTemplate.setFirst(map1);
                    Map map2 = new HashMap();
                    map2.put("value",StringUtil.dateFormat(day,"yyyy年MM月dd日","",2));
                    map2.put("color","#173177");
                    wxTemplate.setKeyword1(map2);
                    Map map3 = new HashMap();
                    map3.put("color","#173177");
                    map3.put("value",wxHouseInfo.getCityName()+"  "+wxHouseInfo.getCommunityName());
                    wxTemplate.setKeyword2(map3);
                    Map map4 = new HashMap();
                    map4.put("color","#173177");
                    map4.put("value",wxHouseInfo.getAssessSalePrice()+"元/平方米");
                    wxTemplate.setKeyword3(map4);
                    Map map5 = new HashMap();
                    map5.put("color","#173177");
                    map5.put("value",price.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString()+"万元");
                    wxTemplate.setKeyword4(map5);
                    Map map7 = new HashMap();
                    map7.put("color","#173177");
                    map7.put("value","涨了多少钱？立即查看 >>");
                    wxTemplate.setRemark(map7);
                    Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
                    jsonData = g.toJson(wxTemplate);
                    WeixinServer.sendMsg(accessToken,wxUserInfo.getWxOpenid(),priceTemplateId,jsonData);
                }
            }
            map.put("status","1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("status","2");
        }

        return map;
    }

    @Override
    public long getCount(String userId) {
        WxMessageExample wxMessageExample = new WxMessageExample();
        WxMessageExample.Criteria criteria = wxMessageExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return wxMessageMapper.countByExample(wxMessageExample);
    }
    @Override
    public long getNoReadCount(String userId) {
        WxMessageExample wxMessageExample = new WxMessageExample();
        WxMessageExample.Criteria criteria = wxMessageExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andIsReadEqualTo(new BigDecimal(0));
        return wxMessageMapper.countByExample(wxMessageExample);
    }

    @Override
    public List<WxMessage> getNoReadMessageListByUserId(String userId) {
        WxMessageExample wxMessageExample = new WxMessageExample();
        WxMessageExample.Criteria criteria = wxMessageExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andIsReadEqualTo(new BigDecimal(0));
        return wxMessageMapper.selectByExample(wxMessageExample);
    }

    @Override
    public int updateReadStatus(String messageId) {
        WxMessageExample wxMessageExample = new WxMessageExample();
        WxMessageExample.Criteria criteria = wxMessageExample.createCriteria();
        criteria.andIdEqualTo(messageId);
        WxMessage wxMessage = new WxMessage();
        wxMessage.setIsRead(new BigDecimal(1));
        return wxMessageMapper.updateByExampleSelective(wxMessage,wxMessageExample);
    }

    @Override
    public List<WxMessage> getMessageListByUserId(Parameter parameter) {
        CommonHelper.setPage(parameter, 1, 12);
        return wxMessageMapper.getMessageListByUserId(parameter);
    }
}
