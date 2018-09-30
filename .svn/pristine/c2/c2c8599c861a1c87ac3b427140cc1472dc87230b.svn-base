package com.cindata.housekeeper.web.service.impl;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.dao.*;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.*;
import com.cindata.housekeeper.web.model.HouseInfoExample.Criteria;
import com.cindata.housekeeper.web.service.HouseInfoService;
import com.google.common.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class HouseInfoServiceImpl  implements HouseInfoService{
	private static final int DEF_DIV_SCALE = 2;
    @Resource
    private HouseInfoMapper houseInfoMapper;
    @Resource
    private CommonMapper commonMapper;
    @Resource
    private HouseAvmLogMapper houseAvmLogMapper;
    @Resource
    private ChangeHomeInfoMapper changeInfoMapper;
    @Resource
    private HouseChangeLogMapper houseChangeLogMapper;
    private HttpServletRequest request;
   
    @Override
    public int addHouse(HouseInfo houseInfo) {
        houseInfo.setHouseId(commonMapper.getSeq("HOUSE_SEQ"));
        //获取相似案例
        Long communityId =houseInfo.getCommunityId().longValue();
        BigDecimal square = houseInfo.getBuildingsquare();
        Long cityId = houseInfo.getCityId().longValue();
        List<AvmCaseData> list = null;
        int maxSalePrice = 0;
        int minSalePrice = 0;
        int maxRentPrice = 0;
        int minRentPrice = 0;
        if(StringUtil.isNotNullOrEmpty(square) && StringUtil.isNotNullOrEmpty(communityId)&& StringUtil.isNotNullOrEmpty(cityId)) {
            Parameter param = new Parameter();
            param.setSquare(square);
            param.setCityId(cityId);
            param.setCommunityId(communityId);
            String resBody = OpenapiPoster.post(param, "avm/getSameSaleListing");
            JSONResult<List<AvmCaseData>> bean= (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<List<AvmCaseData>>>(){}.getType());
            list = bean.getData();
            if(list != null && !list.isEmpty()){
                int listSize = list.size();
                for(int i=0;i<listSize;i++){
                    AvmCaseData avmCaseData = list.get(i);
                    int sqmprice = avmCaseData.getSqmprice().intValue();
                    if (listSize>=5&&i==0){
                        continue;
                    }
                    if(maxSalePrice < sqmprice){
                        maxSalePrice = sqmprice;
                    }
                    if(minSalePrice > sqmprice || minSalePrice==0){
                        minSalePrice = sqmprice;
                    }
                }
            }else{
                BigDecimal price = houseInfo.getAssessSalePrice();
                if(price !=null&&price.intValue()>0){
                    int pi = price.intValue();
                    maxSalePrice = pi + pi / 5;
                    minSalePrice = pi - pi / 5;
                }
            }
            //获取建议租金
            String resBody1 = OpenapiPoster.post(param, "avm/getSameRentListing");
            JSONResult<List<AvmCaseData>> bean1= (JSONResult<List<AvmCaseData>>) CtrlerUtil.json2bean(resBody1, new TypeToken<JSONResult<List<AvmCaseData>>>(){}.getType());
            list = bean1.getData();
            if(list != null && !list.isEmpty()){
                int listSize = list.size();
                for(int i=0;i<listSize;i++){
                    AvmCaseData avmCaseData = list.get(i);
                    int sqmprice = avmCaseData.getSqmprice().intValue();
                    if (listSize>=5&&i==0){
                        continue;
                    }
                    if(maxRentPrice < sqmprice){
                        maxRentPrice = sqmprice;
                    }
                    if(minRentPrice > sqmprice || minRentPrice==0){
                        minRentPrice = sqmprice;
                    }
                    if(maxRentPrice==minRentPrice){
                        BigDecimal price = StringUtil.parseBigDecimal(minRentPrice,new BigDecimal(0));
                        if(price !=null&&price.intValue()>0){
                            int pi = price.intValue();
                            maxRentPrice = pi + pi / 5;
                            minRentPrice = pi - pi / 5;
                        }
                    }
                }
            }else{
                BigDecimal price = houseInfo.getAssessRentPrice();
                if(price !=null&&price.intValue()>0){
                    int pi = price.intValue();
                    maxRentPrice = pi + pi / 5;
                    minRentPrice = pi - pi / 5;
                }
            }
        }
        houseInfo.setMaxSalePrice(new BigDecimal(maxSalePrice));
        houseInfo.setMinSalePrice(new BigDecimal(minSalePrice));
        houseInfo.setMaxRentPrice(new BigDecimal(maxRentPrice));
        houseInfo.setMinRentPrice(new BigDecimal(minRentPrice));
        return houseInfoMapper.insertSelective(houseInfo);
    }

    @Override
    public List<HouseInfo> getHouseByuserId(String userId) {
        HouseInfoExample houseInfoExample =new HouseInfoExample();
        Criteria cri = houseInfoExample.createCriteria();
        cri.andStatusEqualTo("1");
        cri.andUserIdEqualTo(userId);
        houseInfoExample.setOrderByClause("CREATED_DT DESC");
        return houseInfoMapper.selectByExample(houseInfoExample);
    }

    @Override
    public int updateHouse(HouseInfo houseInfo) {
        HouseInfoExample houseInfoExample =new HouseInfoExample();
        Criteria cri = houseInfoExample.createCriteria();
        cri.andHouseIdEqualTo(houseInfo.getHouseId());
        return houseInfoMapper.updateByExampleSelective(houseInfo,houseInfoExample);
    }

	@Override
	public HouseInfo selectHouseInfoByHouseId(Integer houseId) {
		
		return houseInfoMapper.selectHouseInfoByHouseId(houseId);
	}

    @Override
    public int updateHouseAvm() {
        HouseInfoExample houseInfoExample =new HouseInfoExample();
        Criteria cri = houseInfoExample.createCriteria();
        cri.andStatusEqualTo("1");
        List<HouseInfo> list = null;
        List<HouseInfo> HouseInfoList = new ArrayList<HouseInfo>();
        try {
            list = houseInfoMapper.selectByExample(houseInfoExample);
            for (HouseInfo houseInfo:list) {
                Parameter param = new Parameter();
                param.setCommunityId(houseInfo.getCommunityId().longValue());
                param.setSquare(houseInfo.getBuildingsquare());
                param.setCityId(houseInfo.getCityId().longValue());
                String resBody = OpenapiPoster.post(param, "avm/avmSale");
                JSONResult<AssessResult> bean = (JSONResult<AssessResult>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<AssessResult>>(){}.getType());
                AssessResult assessResult = bean.getData();
                if(bean.isSuccess()&&assessResult!=null) {
                    BigDecimal avmSalePrice = assessResult.getSaleAssessPrice();
                    BigDecimal avmRentPrice = assessResult.getRentAssessPrice();

                    Date date = new Date(System.currentTimeMillis());
                    houseInfo.setAssessTime(date);
                    houseInfo.setAssessSalePrice(avmSalePrice);
                    cri.andHouseIdEqualTo(houseInfo.getHouseId());
                    houseInfoMapper.updateByExampleSelective(houseInfo, houseInfoExample);
                    HouseAvmLog houseAvmLog = new HouseAvmLog();
                    houseAvmLog.setHouseId(houseInfo.getHouseId());
                    houseInfo.setAssessSalePrice(avmSalePrice.setScale(0, BigDecimal.ROUND_HALF_UP));
                    houseInfo.setAssessRentPrice(avmRentPrice.setScale(0, BigDecimal.ROUND_HALF_UP));
                    houseInfo.setAssessTime(date);
                    houseAvmLogMapper.insertSelective(houseAvmLog);
                    HouseInfoList.add(houseInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!HouseInfoList.isEmpty()){
            return HouseInfoList.size();
        }else {
            return 0;
        }
    }

    @Override
    public int addHouseAvm(HouseAvmLog houseAvmLog) {
        return houseAvmLogMapper.insertSelective(houseAvmLog);
    }

    @Override
    public List<HouseAvmLog> getHouseAvmLogByHouseId(BigDecimal houseId) {
        HouseAvmLogExample houseAvmLogExample =new HouseAvmLogExample();
        HouseAvmLogExample.Criteria cri = houseAvmLogExample.createCriteria();
        cri.andHouseIdEqualTo(houseId);
        Date date =StringUtil.getDate(StringUtil.getEndDay(StringUtil.getLastMM()));
        cri.andAssessTimeLessThan(date);
        houseAvmLogExample.setOrderByClause("ASSESS_TIME DESC");
        List<HouseAvmLog> list =houseAvmLogMapper.selectByExample(houseAvmLogExample);
        return list;
    }

    @Override
   	public HouseInfo lastInsertHouse(String userId) {

        HouseInfo house = null;
        List<HouseInfo> list = new ArrayList<HouseInfo>();
        HouseInfoExample houseInfoExample = new HouseInfoExample();
        houseInfoExample.createCriteria().andUserIdEqualTo(userId);
        houseInfoExample.setOrderByClause("CREATED_DT DESC");
        list = houseInfoMapper.selectByExample(houseInfoExample);
        if(!list.isEmpty()) {
            house = list.get(0);
        }
          return house;
   	}

   	@Override
   	public int replaceSuggestion(HouseChangeLog param) {

   		return houseChangeLogMapper.insertSelective(param);
   	}

    @Override
    public List<Map> getHouseTop(Parameter params) {

        return houseInfoMapper.getHouseTop(params);
    }

    @Override
    public List<Map> getHousePriceTop(String groupId) {
        return houseInfoMapper.getHousePriceTop(groupId);
    }

    @Override
    public List<HouseInfo> getHouseList(Parameter params) {
        CommonHelper.setPage(params, 1, 12);
        return houseInfoMapper.getHouseList(params);
    }

    @Override
    public List<Map> getHouseListCount(Parameter params) {
        return houseInfoMapper.getHouseListCount(params);
    }

    @Override
    public Map houseCountAndPrice() {
        String groupId = LoginFilter.userInfo.getGroupId();
        Parameter parameter = new Parameter();
        parameter.setGroupId(groupId);

        return houseInfoMapper.houseCountAndPrice(parameter);
    }

    @Override
    public Map houseCountAndPriceYesterday() {
        String groupId = LoginFilter.userInfo.getGroupId();
        Date yesterday =StringUtil.getDate(StringUtil.getDay(-1));
        Date now = new Date(System.currentTimeMillis());
        Parameter parameter = new Parameter();
        parameter.setGroupId(groupId);
        parameter.setStartDate(yesterday);
        parameter.setEndDate(now);
        return houseInfoMapper.houseCountAndPrice(parameter);
    }

    @Override
    public Map userAvgHouse() {
        String groupId = LoginFilter.userInfo.getGroupId();
        Parameter parameter = new Parameter();
        parameter.setGroupId(groupId);

        return houseInfoMapper.userAvgHouse(parameter);
    }

	@Override
	public int houseAvmDayLimit(Parameter param) {
		int dayLimit  = houseInfoMapper.houseAvmDayLimit(param);
		return dayLimit;
	}

	@Override
	public int houseAvmMonthLimit(Parameter param) {
		int monthLimit  = houseInfoMapper.houseAvmMonthLimit(param);
		return monthLimit;
	}

	@Override
	public List<HouseInfo> getHouseTop() {
		
		List<HouseInfo> list = houseInfoMapper.getHouseTopPx();
		return list;
	}


}
