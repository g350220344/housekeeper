package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.job.ant.SendJPushThread;
import com.cindata.housekeeper.web.dao.CommonMapper;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;
import com.cindata.housekeeper.web.model.CommunityMarket;
import com.cindata.housekeeper.web.model.LpbCommunity;
import com.cindata.housekeeper.wx.dao.WxReportMapper;
import com.cindata.housekeeper.wx.model.WxReport;
import com.cindata.housekeeper.wx.model.WxReportExample;
import com.cindata.housekeeper.wx.service.WxReportService;
import com.google.common.collect.Maps;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WxReportServiceImpl implements WxReportService {

	
	@Resource
    private WxReportMapper wxReportMapper;
	@Resource
	private CommonMapper commonMapper;
	@Override
	public List<Map> selectUserReportByPage(Map<String, Object> bean) {
		CommonHelper.setPage(bean, 1, 3);
		
		List<Map> dataList = wxReportMapper.selectUserReportByPage(bean);
		List<Map> resultList = new ArrayList<>();
		if(StringUtil.isNotNullOrEmpty(dataList) && dataList.size() > 0){
			Parameter param = new Parameter();
			ApplyCommunityInfo communityInfo = new ApplyCommunityInfo();
			for(Map data : dataList){
				
				param.setCommunityId(StringUtil.parseLong(data.get("COMMUNITY_ID"), null));
				
				String resBody = OpenapiPoster.post(param, "community/getApplyCommunityInfo");
				JSONResult<ApplyCommunityInfo> communityResult = (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<ApplyCommunityInfo>>() {
				}.getType());
				
				communityInfo = communityResult.getData();
				
				Map result = new HashMap();
				//获取小区信息
				result.put("communityId", data.get("COMMUNITY_ID"));
				result.put("communityName", communityInfo.getCommunityname());
				result.put("cityName", communityInfo.getCityName());
				result.put("districtName", communityInfo.getDistrictName());
				result.put("address", communityInfo.getDetailaddress());
				result.put("subscribeDate", data.get("SUBSCRIBE_DATE"));
				result.put("updateDate", data.get("UPDATE_DATE"));
				result.put("period", data.get("PERIOD"));
				result.put("isRead", data.get("IS_READ"));
				
				resultList.add(result);
			}
		}
		
		return resultList;
	}

	@Override
	public int selectUserReportByPageCount(Map<String, Object> bean) {
		// TODO Auto-generated method stub
		return wxReportMapper.selectUserReportByPageCount(bean);
	}

	@Override
	public List<Map> selectUserReportDetailByPage(Map<String, Object> bean) {
		CommonHelper.setPage(bean, 1, 5);
		//取系统时间上一个月的第一天
		String lastMonthDay = StringUtil.getLastMM()+"-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date lastDate = null;
	    String nowDate = null;
		try {
			lastDate = sdf.parse(lastMonthDay);
			//本月
			//nowDate = StringUtil.dateFormat(new Date(), "yyyy年MM月", "");
			//上月
			nowDate = StringUtil.dateFormat(lastDate, "yyyy年MM月", "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Map> dataList = wxReportMapper.selectUserReportByPage(bean);
		List<Map> resultList = new ArrayList<>();
		if(StringUtil.isNotNullOrEmpty(dataList) && dataList.size() > 0){
			Parameter param = new Parameter();
			List<SendJPushThread> tList = new ArrayList<>();

			for(Map data : dataList){
			/*	CommunityMarket communityMarket = new CommunityMarket();
				ApplyCommunityInfo communityInfo = new ApplyCommunityInfo();*/
				Map result = new HashMap();
				//获取小区信息
				result.put("communityId", data.get("COMMUNITY_ID"));
				result.put("subscribeDate", data.get("SUBSCRIBE_DATE"));
				result.put("updateDate", data.get("UPDATE_DATE"));
				result.put("period", data.get("PERIOD"));
				result.put("isRead", data.get("IS_READ"));
				int type=1;
				SendJPushThread thread = new SendJPushThread(StringUtil.parseLong(data.get("COMMUNITY_ID"),null),StringUtil.parseDate(lastMonthDay,null),result,new CommunityMarket(),type);
				tList.add(thread);
/*


				//获取apply小区表信息
				param.setCommunityId(StringUtil.parseLong(data.get("COMMUNITY_ID"), null));
//				Long cStartTime = System.currentTimeMillis();
				String resBody_CommunityInfo = OpenapiPoster.post(param, "community/getApplyCommunityInfo");
//				System.out.println("openapi接口用时ccccccc----------->"+(System.currentTimeMillis()-cStartTime));
				JSONResult<ApplyCommunityInfo> communityResult = (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBody_CommunityInfo, new TypeToken<JSONResult<ApplyCommunityInfo>>() {
				}.getType());
				if(StringUtil.isNotNullOrEmpty(communityResult.getData())){
					communityInfo = communityResult.getData();
					
					result.put("communityName", communityInfo.getCommunityname());
					result.put("cityName", communityInfo.getCityName());
					result.put("districtName", communityInfo.getDistrictName());
					result.put("address", communityInfo.getDetailaddress());
				}
				
				
				//获取小区行情明细
				param.setMonth(lastDate);
//				Long aStartTime = System.currentTimeMillis();
				String resBody_Market = OpenapiPoster.post(param, "analysis/getCommunityMarket");
//				System.out.println("openapi接口用时aaaaaa----------->"+(System.currentTimeMillis()-aStartTime));
				JSONResult<CommunityMarket> communityMarketResult = (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody_Market, new TypeToken<JSONResult<CommunityMarket>>() {
				}.getType());
				
				if(communityMarketResult!=null){
					communityMarket = communityMarketResult.getData();
					
					if(StringUtil.isNotNullOrEmpty(communityMarket.getRentalPriceRatio())){
						result.put("rentalPriceRatio", communityMarket.getRentalPriceRatio());
					}else{
						result.put("rentalPriceRatio", 0);
					}
					if(StringUtil.isNotNullOrEmpty(communityMarket.getSalesqmprice())){
						result.put("salesqmprice", communityMarket.getSalesqmprice());
					}else{
						result.put("salesqmprice", 0);
					}

					//获取出售成交套数（调用北京接口）
					param.setCityCode(communityMarket.getCityId()+"00");
//					param.setCityCode("110100");
//					param.setCommunityId(Long.parseLong("380247005"));

					//获取小区出售成交
					result.put("saleDealCount", 0);
//				Long bStartTime = System.currentTimeMillis();
					String resBody_BJ = OpenapiPoster.postBJ(param, "api/communityRate");
//				System.out.println("北京接口用时----------->"+(System.currentTimeMillis()-bStartTime));
					JSONObject jObject=new JSONObject(resBody_BJ);
					if("0".equals(jObject.getString("code")) && jObject.getJSONObject("data").length() > 0 && jObject.getJSONObject("data").getJSONArray("echartDate").length() > 0){
						JSONArray jsonArray = jObject.getJSONObject("data").getJSONArray("echartDate");

						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject jsonObject = (JSONObject) jsonArray.get(i);
							if(nowDate.equals(jsonObject.getString("monthDate"))){
								result.put("saleDealCount", jsonObject.getInt("saleCount"));
							}
						}
					}
				}
				resultList.add(result);*/
			}
			if(tList != null && !tList.isEmpty()){
				for (SendJPushThread sendJPushThread : tList) {
					sendJPushThread.start();
				}
				boolean hasRunning = true;
				while(hasRunning){
					hasRunning = false;
					for (SendJPushThread sendJPushThread : tList) {
						if(sendJPushThread.isAlive()){
							hasRunning = true;
							continue;
						}
					}
				}
				for (SendJPushThread sendJPushThread : tList) {
					if(sendJPushThread.getCommunityMarket()!=null){
						Map result = sendJPushThread.getResult();

						CommunityMarket communityMarket = sendJPushThread.getCommunityMarket();
						ApplyCommunityInfo communityInfo = communityMarket.getCommunityInfo();
						result.put("communityName", communityInfo.getCommunityname());
						result.put("cityName", communityInfo.getCityName());
						result.put("districtName", communityInfo.getDistrictName());
						result.put("address", communityInfo.getDetailaddress());

						if(StringUtil.isNotNullOrEmpty(communityMarket.getRentalPriceRatio())){
							result.put("rentalPriceRatio", communityMarket.getRentalPriceRatio());
						}else{
							result.put("rentalPriceRatio", 0);
						}
						if(StringUtil.isNotNullOrEmpty(communityMarket.getSalesqmprice())){
							result.put("salesqmprice", communityMarket.getSalesqmprice());
						}else{
							result.put("salesqmprice", 0);
						}

						//获取出售成交套数（调用北京接口）
						param.setCityCode(communityMarket.getCityId()+"00");
//					param.setCityCode("110100");
//					param.setCommunityId(Long.parseLong("380247005"));
						Parameter params = new Parameter();
						params.setCityId(communityInfo.getCityId());
						params.setCommunityId(communityInfo.getCommunityId());
						String resBody = OpenapiPoster.post(params, "community/getGrCommunityList");
						JSONResult<LpbCommunity> bean1 = (JSONResult<LpbCommunity>) CtrlerUtil.json2bean(resBody, new com.google.common.reflect.TypeToken<JSONResult<LpbCommunity>>() {
						}.getType());
						LpbCommunity data = bean1.getData();
						Map<String, Object> param1 = Maps.newHashMap();
						param1.put("cityCode",communityInfo.getCityId()+"00");
						param1.put("communityId",data.getCommunityId());
						String resBody_BJ = OpenapiPoster.postBJ(param1, "api/communityRate");
						JSONObject jObject=new JSONObject(resBody_BJ);
						//获取小区出售成交
						result.put("saleDealCount", 0);
//				Long bStartTime = System.currentTimeMillis();
						//String resBody_BJ = OpenapiPoster.postBJ(param, "api/communityRate");
//				System.out.println("北京接口用时----------->"+(System.currentTimeMillis()-bStartTime));
						//JSONObject jObject=new JSONObject(resBody_BJ);
						if("0".equals(jObject.getString("code")) && jObject.getJSONObject("data").length() > 0 && jObject.getJSONObject("data").getJSONArray("echartDate").length() > 0){
							JSONArray jsonArray = jObject.getJSONObject("data").getJSONArray("echartDate");

							for (int i = 0; i < jsonArray.length(); i++) {
								JSONObject jsonObject = (JSONObject) jsonArray.get(i);
								if(nowDate.equals(jsonObject.getString("monthDate"))){
									result.put("saleDealCount", jsonObject.getInt("saleCount"));
								}
							}
						}
						resultList.add(result);
					}
				}
			}
		}
		
		return resultList;
	}

	@Override
	public int selectUserReportDetailByPageCount(Map<String, Object> bean) {
		// TODO Auto-generated method stub
		return wxReportMapper.selectUserReportByPageCount(bean);
	}

	@Override
	public List<WxReport> selectAllUserReportByUserId(Map<String, Object> bean) {
		WxReportExample example = new WxReportExample();
		WxReportExample.Criteria exaReportInfo = example.createCriteria();
		exaReportInfo.andUserIdEqualTo(bean.get("userId").toString());
		exaReportInfo.andStatusEqualTo(new BigDecimal(0));
		exaReportInfo.andIsPayEqualTo(new BigDecimal(1));
		if(StringUtil.isNotNullOrEmpty(bean.get("isExpired"))){
			exaReportInfo.andIsExpiredEqualTo(new BigDecimal(bean.get("isExpired").toString()));
		}
		if(StringUtil.isNotNullOrEmpty(bean.get("isRead"))){
			exaReportInfo.andIsReadEqualTo(new BigDecimal(bean.get("isRead").toString()));
		}
		return wxReportMapper.selectByExample(example);
	}
	
	@Override
    public List<WxReport> selectReport(WxReport reportInfo) {
        WxReportExample exa = new WxReportExample();
        WxReportExample.Criteria cri =  exa.createCriteria();
        if(StringUtil.isNotNullOrEmpty(reportInfo.getUserId())){
            cri.andUserIdEqualTo(reportInfo.getUserId());
        }
        if(StringUtil.isNotNullOrEmpty(reportInfo.getCommunityId())){
            cri.andCommunityIdEqualTo(reportInfo.getCommunityId());
        }
        cri.andStatusEqualTo(new BigDecimal("0")).andIsPayEqualTo(new BigDecimal(1));
        return wxReportMapper.selectByExample(exa);
    }

	@Override
	public List<WxReport> getWxReportByUserIdAndCommunityId(String userId, String communityId) {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andUserIdEqualTo(userId).andCommunityIdEqualTo(StringUtil.parseBigDecimal(communityId,null))
				.andStatusEqualTo(new BigDecimal(0)).andIsExpiredEqualTo(new BigDecimal(0))
				.andIsPayEqualTo(new BigDecimal(1));
		return wxReportMapper.selectByExample(exa);
	}

	@Override
	public int updateReporStatus() {

		return wxReportMapper.updateReporStatus();
	}

	@Override
	public int updateReporRead() {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andStatusEqualTo(new BigDecimal(0)).andIsExpiredEqualTo(new BigDecimal(0)).andIsReadEqualTo(new BigDecimal(1));
		WxReport wxReport = new WxReport();
		wxReport.setIsRead(new BigDecimal(0));
		return wxReportMapper.updateByExampleSelective(wxReport,exa);
	}

	@Override
	public int addReport(WxReport wxReport) {
		wxReport.setId(commonMapper.getUuid());
		return wxReportMapper.insertSelective(wxReport);
	}

	@Override
	public int updateReporPay(String out_trade_no) {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andStatusEqualTo(new BigDecimal(0)).andIsPayEqualTo(new BigDecimal(0)).andIdEqualTo(out_trade_no);
		WxReport wxReport = new WxReport();
		wxReport.setIsPay(new BigDecimal(1));
		wxReport.setSubscribeDate(new java.sql.Date(System.currentTimeMillis()));
		return wxReportMapper.updateByExampleSelective(wxReport,exa);
	}

	@Override
	public WxReport selectReportById(String reportId) {
		return wxReportMapper.selectByPrimaryKey(reportId);
	}

	@Override
	public List<WxReport> getReportCont(String communityId) {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andCommunityIdEqualTo(StringUtil.parseBigDecimal(communityId,null))
                .andIsPayEqualTo(new BigDecimal(1))
                .andStatusEqualTo(new BigDecimal(0))
                .andIsExpiredEqualTo(new BigDecimal(0));

		return wxReportMapper.selectByExample(exa);
	}

	@Override
	public int updateReporReadByUserIdAndCommunityId(String userId, String communityId) {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andStatusEqualTo(new BigDecimal(0))
				.andIsExpiredEqualTo(new BigDecimal(0))
				.andIsReadEqualTo(new BigDecimal(0))
					.andCommunityIdEqualTo(StringUtil.parseBigDecimal(communityId,null))
				.andUserIdEqualTo(userId);
		WxReport wxReport = new WxReport();
		wxReport.setIsRead(new BigDecimal(1));
		return wxReportMapper.updateByExampleSelective(wxReport,exa);
	}

	@Override
	public int deleteReportByUserId(String userId) {
		WxReportExample exa = new WxReportExample();
		WxReportExample.Criteria cri =  exa.createCriteria();
		cri.andIsPayEqualTo(new BigDecimal(0)).andUserIdEqualTo(userId);
		return wxReportMapper.deleteByExample(exa);
	}
}
