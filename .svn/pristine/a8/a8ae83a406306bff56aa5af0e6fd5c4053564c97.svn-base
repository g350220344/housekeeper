package com.cindata.housekeeper.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.*;
import com.cindata.housekeeper.web.service.HouseInfoService;
import com.cindata.housekeeper.web.service.UserInfoService;
import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 通用服务
 * @author yangss
 * @date   2017.06.20 09:47
 */
@Controller
@RequestMapping(value = "/house")
public class HouseController {


    @Resource
    private HouseInfoService houseInfoService;
    @Autowired
	private UserInfoService userInfoService;

    /**
     * 添加房产接口
     */
    @RequestMapping(value="/addHouse", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String addHouse(HttpServletRequest request, HttpServletResponse response, HouseInfo houseInfo){
    	Object session = request.getSession().getAttribute("userInfo");
    	
    	
        JSONResult res = new JSONResult();
        try {
            Parameter param = new Parameter();
            param.setCommunityId(houseInfo.getCommunityId().longValue());
            param.setSquare(houseInfo.getBuildingsquare());
            param.setCityId(houseInfo.getCityId().longValue());
            String resBody = OpenapiPoster.post(param, "avm/avmSale");
            JSONResult<AssessResult> bean = (JSONResult<AssessResult>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<AssessResult>>(){}.getType());
            AssessResult assessResult = bean.getData();
            if(bean.isSuccess()) {
                BigDecimal avmSalePrice = assessResult.getSaleAssessPrice();
                BigDecimal avmRentPrice = assessResult.getRentAssessPrice();
                houseInfo.setAssessSalePrice(avmSalePrice.setScale(0, BigDecimal.ROUND_HALF_UP));
                houseInfo.setAssessRentPrice(avmRentPrice.setScale(0, BigDecimal.ROUND_HALF_UP));
                houseInfo.setAssessTime(new Date(System.currentTimeMillis()));
            }
            UserInfo userInfo = userInfoService.getUserInfoByMobile(houseInfo.getUserId());
            houseInfo.setReserve1(userInfo.getGroupId());
            houseInfo.setReserve2(houseInfo.getCityId().toString().substring(0,2));
            int i = houseInfoService.addHouse(houseInfo);
            if(i>0){
                //评估成功后往用户评估记录表插入数据
                HouseAvmLog houseAvmLog = new HouseAvmLog();
                Date date = new Date(System.currentTimeMillis());
                houseAvmLog.setHouseId(houseInfo.getHouseId());
                houseAvmLog.setAssessSalePrice(houseInfo.getAssessSalePrice());
                houseAvmLog.setAssessRentPrice(houseInfo.getAssessRentPrice());
                houseAvmLog.setAssessTime(date);
                houseInfoService.addHouseAvm(houseAvmLog);
                res.setData(houseInfo.getHouseId());
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            }else{
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
    /**
     * 编辑房产接口
     */
    @RequestMapping(value="/updateHouse", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String updateHouse(HttpServletRequest request, HttpServletResponse response, HouseInfo houseInfo){
        JSONResult res = new JSONResult();
        try {
            int i = houseInfoService.updateHouse(houseInfo);
            if(i>0){
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            }else{
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
    /**
     * 资产总值接口
     */
    @RequestMapping(value="/getHouseAvmByUserId", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHouseAvmByUserId(HttpServletRequest request, HttpServletResponse response){
    	int px = 0;
        String userId = request.getParameter("userId");
        JSONResult<JSONObject> res = new JSONResult();
        try {
            List<HouseInfo> list = houseInfoService.getHouseByuserId(userId);
            BigDecimal data = new BigDecimal(0);
            BigDecimal totalPrice = new BigDecimal(0);
            BigDecimal houseAvmLogPrice = new BigDecimal(0);
            for (HouseInfo houseInfo:list) {
				/*Parameter param = new Parameter();
				param.setCommunityId(houseInfo.getCommunityId().longValue());
				param.setSquare(houseInfo.getBuildingsquare());
				param.setCityId(houseInfo.getCityId().longValue());
				String resBody = OpenapiPoster.post(param, "avm/avmSale");
				JSONResult bean = (JSONResult) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult>(){}.getType());
				BigDecimal avmPrice = new BigDecimal(bean.getData().toString());
				data = data.add(avmPrice.multiply(param.getSquare()));*/
                BigDecimal avmPrice1 = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(),new BigDecimal(0));
                totalPrice = totalPrice.add(avmPrice1.multiply(houseInfo.getBuildingsquare()));
                List<HouseAvmLog> houseAvmList = houseInfoService.getHouseAvmLogByHouseId(houseInfo.getHouseId());
                if(!houseAvmList.isEmpty()&&StringUtil.isNotNullOrEmpty( houseAvmList.get(0).getAssessSalePrice())){
                    BigDecimal assessSalePrice = StringUtil.parseBigDecimal(houseAvmList.get(0).getAssessSalePrice(),new BigDecimal(0));
                    BigDecimal buildingsquare = StringUtil.parseBigDecimal(houseInfo.getBuildingsquare(),new BigDecimal(0));
                    houseAvmLogPrice = houseAvmLogPrice.add(assessSalePrice.multiply(buildingsquare));
                    //上月无估值房产不参与计算。如果没有可参与的房产，较X月上涨隐藏
                    BigDecimal avmPrice = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(),new BigDecimal(0));
                    data = data.add(avmPrice.multiply(houseInfo.getBuildingsquare()));
                }
            }
            
            List<HouseInfo> listTotal = houseInfoService.getHouseTop();
           int zpx = listTotal.size();
           BigDecimal zpxBigDecimal = new BigDecimal(zpx);
          
            for(int i = 0;i < listTotal.size(); i ++){
            	
            	if(listTotal.get(i).getUserId().equals(userId)){
            		px = i;
            		
            		break;
            	}
            	   
            	}
            BigDecimal pxBigDecimal = new BigDecimal(px);
            //BigDecimal top = pxBigDecimal.divide(zpxBigDecimal,).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal top = pxBigDecimal.divide(zpxBigDecimal, 2, BigDecimal.ROUND_HALF_UP);
            BigDecimal sortPercent1 =new BigDecimal(1).subtract(top);
            BigDecimal sortPercent = sortPercent1.multiply(new BigDecimal(100));
            //String sortPercent = sortPercent1.multiply(new BigDecimal(100)).toString() + "%";
            Double risePercent = CommonHelper.getRisePercentNoParam(data,houseAvmLogPrice);
            //房产升值价格
            BigDecimal risePrice = data.subtract(houseAvmLogPrice).setScale(2,BigDecimal.ROUND_HALF_UP);
            BigDecimal   b   =   new   BigDecimal(risePercent);
            //保留两位小数
            risePercent   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            //总价单位（万）保留一位小数
            totalPrice = totalPrice.divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP);
            
           
            String lastMonth = StringUtil.getLastMM().split("-")[1];
            JSONObject json = JSON.parseObject("{'sortPercent':" +sortPercent+ ",'risePrice':"+risePrice+",'avmPrice':"+totalPrice+",'risePercent':"+risePercent+",'houseCount':"+list.size()+",'lastMonth':"+lastMonth+"}");
            res.setData(json);
            res.setMessage("ok");
            if(houseAvmLogPrice.toString().equals("0")){
                res.setStatusCode(3);//如果没有可参与的房产，较X月上涨隐藏
            }else{
                res.setStatusCode(1);
            }
            res.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * 房产列表
     */
    @RequestMapping(value="/getHouseList", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHouseInfoList(HttpServletRequest request, HttpServletResponse response){
        String userId = ServletRequestHelper.getParameter(request, "userId", null);
        List<HouseInfo> houseInfoList = null;
        JSONResult<List<HouseInfo>> res = new JSONResult<>();
        try {
            houseInfoList = houseInfoService.getHouseByuserId(userId);
          /*  for (HouseInfo houseInfo:houseInfoList){
                BigDecimal assessSalePrice = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(),new BigDecimal(0));
                BigDecimal buildingsquare = StringUtil.parseBigDecimal(houseInfo.getBuildingsquare(),new BigDecimal(0));
                houseInfo.setAssessSaleTotalPrice(assessSalePrice.multiply(buildingsquare).divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP));

            }*/
            res.setData(houseInfoList);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(houseInfoList);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * 房产信息
     */
    @RequestMapping(value="/selectHouseInfoByHouseId", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String selectHouseInfoByHouseId(HttpServletRequest request, HttpServletResponse response){
        Integer houseId = StringUtil.parseInt(ServletRequestHelper.getParameter(request, "houseId", null), null);
        HouseInfo houseInfo = null;
        JSONResult<HouseInfo> res = new JSONResult<>();
        try {
            houseInfo = houseInfoService.selectHouseInfoByHouseId(houseId);
            Parameter param = new Parameter();
            param.setCommunityId(StringUtil.parseLong(houseInfo.getCommunityId(),null));
            String resBody = OpenapiPoster.post(param, "community/getApplyCommunityInfo");
            ApplyCommunityInfo data = null;
            JSONResult<ApplyCommunityInfo> bean= (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<ApplyCommunityInfo>>(){}.getType());
            data = bean.getData();
            if(data != null) {
                houseInfo.setLatitude(data.getLatitude());
                houseInfo.setLongitude(data.getLongitude());

            }
            BigDecimal assessSalePrice = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(),new BigDecimal(0));
            BigDecimal buildingsquare = StringUtil.parseBigDecimal(houseInfo.getBuildingsquare(),new BigDecimal(0));
            BigDecimal maxSalePrice = StringUtil.parseBigDecimal(houseInfo.getMaxSalePrice(),new BigDecimal(0));
            BigDecimal minSalePrice = StringUtil.parseBigDecimal(houseInfo.getMinSalePrice(),new BigDecimal(0));


            houseInfo.setAssessSaleTotalPrice(assessSalePrice.multiply(buildingsquare));
            houseInfo.setMaxSaleTotalPrice(maxSalePrice.multiply(buildingsquare).divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP));
            houseInfo.setMinSaleTotalPrice(minSalePrice.multiply(buildingsquare).divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP));



            res.setData(houseInfo);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            res.setData(houseInfo);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * 房产评估
     */
    @RequestMapping(value="/houseAvm", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String houseAvm(HttpServletRequest request, HttpServletResponse response){
        JSONResult<Integer> res = new JSONResult<>();
        Parameter param = new Parameter();
        param.setCommunityId(588094067l);
        param.setSquare(new BigDecimal(50));
        param.setCityId(2301l);
        String resBody = OpenapiPoster.post(param, "avm/avmSale");
        JSONResult<AssessResult> bean = (JSONResult<AssessResult>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<AssessResult>>(){}.getType());
        AssessResult assessResult = bean.getData();
        int i =0;
        try {
            //i = houseInfoService.updateHouseAvm();
            res.setData(i);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            res.setData(0);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
	/**
	 * 最后添加的房产
	 */
	@RequestMapping(value="/lastInsertHouse", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String lastInsertHouse(HttpServletRequest request, HttpServletResponse response){
		HouseInfo houseInfo = null;
        String userId = ServletRequestHelper.getParameter(request, "userId", null);

        JSONResult<HouseInfo> res = new JSONResult<>();
		try {
            if(StringUtil.isNotNullOrEmpty(userId)) {
                houseInfo = houseInfoService.lastInsertHouse(userId);
                if(houseInfo!=null) {
                    BigDecimal assessSalePrice = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(), new BigDecimal(0));
                    BigDecimal buildingsquare = StringUtil.parseBigDecimal(houseInfo.getBuildingsquare(), new BigDecimal(0));
                    houseInfo.setAssessSaleTotalPrice(assessSalePrice.multiply(buildingsquare));
                }
                res.setData(houseInfo);
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            }else{
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
		} catch (Exception e) {
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
		
	}
	
	/**
	 * 置换建议记录
	 */
	@RequestMapping(value="/houseReplaceSuggestion", produces="text/html;charset=UTF-8")
    @ResponseBody
	public String houseReplaceSuggestion(HttpServletRequest request, HttpServletResponse response, HouseChangeLog changeInfo){
		
		JSONResult res = new JSONResult();
		int i = 0;

        try {
            if(changeInfo!=null) {
                i = houseInfoService.replaceSuggestion(changeInfo);
            }
            if(i>0){
                res.setData(changeInfo);
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            }
            else{
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}
	
	@RequestMapping(value="/houseReplace", produces="text/html;charset=UTF-8")
    @ResponseBody
	public String houseReplace(HttpServletRequest request, HttpServletResponse response, HouseChangeLog changeInfo){
		JSONResult res = new JSONResult();
		try {
			int i = houseInfoService.updateHouseAvm();
           
                res.setData(changeInfo);
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
           
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * 房产增值分析
	 */
	@RequestMapping(value="/houseAppreciationAnalyze", produces="text/html;charset=UTF-8")
    @ResponseBody
	public String houseAppreciationAnalyze(HttpServletRequest request, HttpServletResponse response, HouseChangeLog changeInfo){
		Long begin = System.currentTimeMillis();
		SaleAppreciationAnalyze saleAppreciationAnalyze = new SaleAppreciationAnalyze();
		JSONResult res = new JSONResult();
		BigDecimal saleFen = new BigDecimal(0);
		BigDecimal rent_year_rant = new BigDecimal(0);
		//Double SaleSqmPriceOnYear_on_YearBasis = 0.0;
		Double SaleSqmPriceOnYear_on_YearBasis =0.0;
		BigDecimal rentFen = new BigDecimal(0);
		Double saleFenDouble  = 0.0;
		boolean flag = true;
		BigDecimal tianShuValue = new BigDecimal(0);
		 Double doubleB = 10000.0;
		 BigDecimal wan = new BigDecimal(doubleB);
		 String salefiveTotalManageResult = "";
		 String rentfiveTotalManageResult = "";
		 String salefirstYearManagerResult = "";
		 String rentfirstYearManagerResult = "";
		 Map<String,BigDecimal> tianshu = new HashMap<String,BigDecimal>();
		 BigDecimal   BigDecimalSaleSqmPriceOnYear_on_YearBasis = new BigDecimal("0");
		 String compareValueResult = "";
		//理财利率，暂时写死
		Double liCaiLiLv = 0.06;
		BigDecimal resultLiCaiLiLv = BigDecimal.valueOf(liCaiLiLv);
		tianshu.put("成都市", new BigDecimal(75));
		tianshu.put("天津市", new BigDecimal(66));
		tianshu.put("广州市", new BigDecimal(64));
		tianshu.put("杭州市", new BigDecimal(77));
		tianshu.put("深圳市", new BigDecimal(62));
		tianshu.put("上海市", new BigDecimal(81));
		tianshu.put("北京市", new BigDecimal(73));
		tianshu.put("哈尔滨市", new BigDecimal(67));
		//tianshu.put("其他城市", 58);
		
		//一年365天
		BigDecimal dayOfYear = new BigDecimal("365");
		//理财天数
				//int manageMoneyMattersDay = StringUtil.parseInt(request.getParameter("manageMoneyMattersDay"), null);
				//BigDecimal resultDay = BigDecimal.valueOf(manageMoneyMattersDay);
		//类型（包括出售和出租）
		//String type = request.getParameter("type");
		
		 Integer houseId = StringUtil.parseInt(ServletRequestHelper.getParameter(request, "houseId", null), null);
		// Integer cityId = StringUtil.parseInt(ServletRequestHelper.getParameter(request, "cityId", null), null);
	        HouseInfo houseInfo = null;
	        try {
	        	
	        	
	            houseInfo = houseInfoService.selectHouseInfoByHouseId(houseId);
	            Long cityId = houseInfo.getCityId().longValue();
	            Parameter paramCityId = new Parameter();
	            paramCityId.setCityId(cityId);
	            String resBodycity = OpenapiPoster.post(paramCityId, "common/getCityByCityId");
	            CityInfo citydata = null;
	            JSONResult<CityInfo> beancity= (JSONResult<CityInfo>) CtrlerUtil.json2bean(resBodycity, new TypeToken<JSONResult<CityInfo>>(){}.getType());
	            String cityName = beancity.getData().getCityName();
	           // String cityName = "成都";
	            Iterator iterator = tianshu.entrySet().iterator();
	            if(flag){
	            while(iterator.hasNext()){
	            	Map.Entry entry = (Map.Entry)iterator.next();
	            	Object key = entry.getKey();
	            	if(key.equals(cityName)){
	            		tianShuValue =  (BigDecimal) entry.getValue();
	            		break;
	            	}else{
	            		  tianShuValue =  new BigDecimal(58);
	            	}
	            	
	            }
	          
	            } 
	            
	            
	            BigDecimal assessSalePrice = houseInfo.getAssessSalePrice();
	            if(assessSalePrice==null){
	            	assessSalePrice = new BigDecimal(0);
	            }
	           //租金
	            BigDecimal assessRentPrice = houseInfo.getAssessRentPrice();
	            if(assessRentPrice==null){
	            	assessRentPrice = new BigDecimal(0);
	            }
	            
	            Parameter paramHouse = new Parameter();
	           
	            Long communityId = StringUtil.parseLong(houseInfo.getCommunityId(),null);
	            paramHouse.setCommunityId(communityId);
	            String resBodysale = OpenapiPoster.post(paramHouse, "community/getApplyCommunityInfo");
	            ApplyCommunityInfo saledata = null;
	            JSONResult<ApplyCommunityInfo> beansale= (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBodysale, new TypeToken<JSONResult<ApplyCommunityInfo>>(){}.getType());
	            saledata = beansale.getData();
	            if(saledata != null) {
	                houseInfo.setLatitude(saledata.getLatitude());
	                houseInfo.setLongitude(saledata.getLongitude());

	            }
	          //  BigDecimal assessSalePrice = StringUtil.parseBigDecimal(houseInfo.getAssessSalePrice(),new BigDecimal(0));
	            BigDecimal buildingsquare = StringUtil.parseBigDecimal(houseInfo.getBuildingsquare(),new BigDecimal(0));
	            BigDecimal maxSalePrice = StringUtil.parseBigDecimal(houseInfo.getMaxSalePrice(),new BigDecimal(0));
	            BigDecimal minSalePrice = StringUtil.parseBigDecimal(houseInfo.getMinSalePrice(),new BigDecimal(0));
	            BigDecimal maxRentPrice = StringUtil.parseBigDecimal(houseInfo.getMaxRentPrice(),new BigDecimal(0));
	            BigDecimal minRentPrice = StringUtil.parseBigDecimal(houseInfo.getMinRentPrice(),new BigDecimal(0));
	            
	           BigDecimal MaxSalePrice = maxSalePrice.multiply(buildingsquare).divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP);
	           BigDecimal MinSalePrice =minSalePrice.multiply(buildingsquare).divide(new BigDecimal(10000)).setScale(1,BigDecimal.ROUND_HALF_UP);
	          // BigDecimal MaxRentPrice =maxRentPrice.multiply(buildingsquare);
	          // BigDecimal MinRentPrice =minRentPrice.multiply(buildingsquare);
                BigDecimal MaxRentPrice =maxRentPrice;
                BigDecimal MinRentPrice =minRentPrice;
		
		//Long communityId = StringUtil.parseLong(request.getParameter("communityId"),null);
		
		//房产估值
		//BigDecimal appraisement = StringUtil.parseBigDecimal(request.getParameter("houseAppraisement"), new BigDecimal("0"));
	      BigDecimal appraisement = buildingsquare.multiply(assessSalePrice).setScale(2, BigDecimal.ROUND_HALF_UP);
	      if(appraisement == null){
	    	  appraisement = new BigDecimal(0); 
	      }
		Double doubleAppraisement = appraisement.doubleValue();
		//5年复利累计总值
		//F=P（1+i）^n  F：终值（Future Value） i：利率或折现率  P：现值（Present Value） N：计息期数
		double fiveCompound = doubleAppraisement * (Math.pow((1.0 + liCaiLiLv), 5.0));
		BigDecimal fiveCompoundBigDecimal = BigDecimal.valueOf(fiveCompound);
		
		
			
		//出售成交平均天数
		//BigDecimal saleAvgDay = StringUtil.parseBigDecimal(request.getParameter("saleAvgDay"), new BigDecimal("0"));
		BigDecimal saleAvgDay = tianShuValue;
		//BigDecimal saleAvgDay = (BigDecimal)tianShuValue;
		//Date month = Date.valueOf(request.getParameter("month"));
		//当前时间
		Date month = new Date(System.currentTimeMillis());
		//TODO:默认时间，为了数据，测试用，
		//Date month = StringUtil.getDate("2018-04-01");
		CommunityMarket data = null;
		
		
		
			if(StringUtil.isNotNullOrEmpty(month) && StringUtil.isNotNullOrEmpty(communityId)) {
				Parameter param = new Parameter();
				param.setMonth(month);
				param.setCommunityId(communityId);
				String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarket");
				JSONResult<CommunityMarket> bean= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
				data = bean.getData();
				//同比增长率
			    SaleSqmPriceOnYear_on_YearBasis = data.getSaleSqmPriceOnYear_on_YearBasis();
			    BigDecimalSaleSqmPriceOnYear_on_YearBasis = StringUtil.parseBigDecimal(SaleSqmPriceOnYear_on_YearBasis,null);
			    if(SaleSqmPriceOnYear_on_YearBasis == null){
			    	SaleSqmPriceOnYear_on_YearBasis =0.0;
			    	BigDecimalSaleSqmPriceOnYear_on_YearBasis = new BigDecimal(SaleSqmPriceOnYear_on_YearBasis);
			    }
			  
			}
			
				
			//理财收益
			//BigDecimal manageMoneyMatters = appraisement.multiply(resultLiCaiLiLv).multiply(resultDay).divide(dayOfYear,2,BigDecimal.ROUND_HALF_UP);
			BigDecimal salemanageMoneyMatters = appraisement.multiply(resultLiCaiLiLv);
			//理财总收益
			BigDecimal salemanageMoneyMattersResult = salemanageMoneyMatters.add(appraisement);
			double d1 = doubleAppraisement * (1.0 + liCaiLiLv);	
			
			////5年复利累计利息
			double resultFiveCompound= fiveCompound - doubleAppraisement;
			BigDecimal salefiveCompoundResult = new BigDecimal(resultFiveCompound).setScale(2, BigDecimal.ROUND_HALF_UP);
			
		
			//首年交易损耗成本
			BigDecimal salelossCostFirstYear = saleAvgDay.multiply(salemanageMoneyMatters.divide(new BigDecimal("365"), 2, BigDecimal.ROUND_HALF_UP));
			//5年总收益
			BigDecimal salefiveTotalManage = salefiveCompoundResult.subtract(salelossCostFirstYear).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(salefiveTotalManage.compareTo(wan) == 1){
				salefiveTotalManageResult =salefiveTotalManage.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) + "万元";
			}else{
				salefiveTotalManageResult =salefiveTotalManage.setScale(2,BigDecimal.ROUND_HALF_UP) + "元";
			}
			
			
			//第一年收益
			BigDecimal salefirstYearManager = appraisement.multiply(resultLiCaiLiLv).subtract(salelossCostFirstYear).setScale(2, BigDecimal.ROUND_HALF_UP);
			if(salefirstYearManager.compareTo(wan) == 1){
				salefirstYearManagerResult = salefirstYearManager.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) + "万元";
			}else{
				salefirstYearManagerResult = salefirstYearManager.setScale(2,BigDecimal.ROUND_HALF_UP) + "元";
			}
		
			saleAppreciationAnalyze.setSalefirstYearManagerResult(salefirstYearManagerResult);
		
			saleAppreciationAnalyze.setSaleSqmPriceOnYear_on_YearBasis(SaleSqmPriceOnYear_on_YearBasis);
			saleAppreciationAnalyze.setSalefiveTotalManageResult(salefiveTotalManageResult);
			saleAppreciationAnalyze.setSaleAvgDay(saleAvgDay);
			saleAppreciationAnalyze.setFinancingIncome("6%");
			saleAppreciationAnalyze.setMaxRentPrice(MaxRentPrice);
			saleAppreciationAnalyze.setMinRentPrice(MinRentPrice);
			saleAppreciationAnalyze.setMaxSalePrice(MaxSalePrice);
			saleAppreciationAnalyze.setMinSalePrice(MinSalePrice);
	
			//出租成交平均天数
			int rentAvgDay = 60;
			BigDecimal rentAvgDayBigDecimal = BigDecimal.valueOf(rentAvgDay);
			//月租金
			//BigDecimal rentAppraisement =StringUtil.parseBigDecimal(request.getParameter("rentAppraisement"), new BigDecimal("0"));
			BigDecimal rentAppraisement = assessRentPrice;
			if(appraisement.compareTo(new BigDecimal(0)) == 0){
				rent_year_rant = new BigDecimal(0);		
			}else{
				//租金回报年收益
				 rent_year_rant = rentAppraisement.multiply(new BigDecimal("12")).divide(appraisement,2,BigDecimal.ROUND_HALF_UP);	
			}
			//租金回报年收益
			
			Double rentYearInDouble = rent_year_rant.doubleValue();
			//租金回报年收益
			//BigDecimal rent_year_rant = rentAppraisement.multiply(new BigDecimal("12")).divide(appraisement,2,BigDecimal.ROUND_HALF_UP);
			//租金回报年收益百分比
			String resultrent_year_rant = rent_year_rant.multiply(new BigDecimal("100")).toString() + "%";
			//年租金
			BigDecimal rentYear = rentAppraisement.multiply(new BigDecimal("12"));
			Double rentYearDouble = rentYear.doubleValue();
			//出租闲置损耗成本
			BigDecimal rentXianzhi = rentYear.divide(new BigDecimal("365"),2,BigDecimal.ROUND_HALF_UP).multiply(rentAvgDayBigDecimal);
			//租金理财收益
			BigDecimal rentManageSy = rentYear.multiply(resultLiCaiLiLv);
			//未来一年增长收益
			BigDecimal funtureOneYearIncrease = appraisement.multiply(BigDecimalSaleSqmPriceOnYear_on_YearBasis.divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP));
			//第一年收益
			BigDecimal rentfirstYearManager = funtureOneYearIncrease.add(rentYear).add(rentManageSy).subtract(rentXianzhi);
			String StringrentfirstYearManager = rentfirstYearManager.toString();
			if(StringrentfirstYearManager.length() >=8){
				rentfirstYearManagerResult = rentfirstYearManager.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) + "万元";
			}else{
				rentfirstYearManagerResult = rentfirstYearManager.setScale(2,BigDecimal.ROUND_HALF_UP) + "元";
			}
			//出售评分
			Double salefiveTotalManageDouble = salefiveTotalManage.doubleValue();
			Double rent_year_rantDouble = rent_year_rant.doubleValue();
			if(doubleAppraisement == 0.0){
				saleFenDouble = 0.0;
			}else{
				Double rentJiSuan = 0.07 - rentYearInDouble;
				if(rentJiSuan.compareTo(0.0) == 0.0){
					saleFenDouble = 0.0;
				}else{
					saleFenDouble  = (salefiveTotalManageDouble/5 - rentYearDouble) / doubleAppraisement / (0.07 - rentYearInDouble) * 10;
				}
			}
			
			
			if(saleFenDouble < 0.0){
				saleFenDouble = 0.0;
				saleFen = new BigDecimal(saleFenDouble).setScale(1, BigDecimal.ROUND_HALF_UP);
			}
			if(saleFenDouble > 10.0){
				saleFenDouble = 10.0;
				saleFen = new BigDecimal(saleFenDouble).setScale(1, BigDecimal.ROUND_HALF_UP);
			}
			saleFen = new BigDecimal(saleFenDouble).setScale(1, BigDecimal.ROUND_HALF_UP);
			
			
			//5年房产增值额
			Double DoubleSaleSqmPriceOnYear_on_YearBasis =BigDecimalSaleSqmPriceOnYear_on_YearBasis.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()/100;
			Double fiveCompoundRent = doubleAppraisement * (Math.pow((1.0 + DoubleSaleSqmPriceOnYear_on_YearBasis), 5.0));
			//仅利息
			Double rentFiveCompound= fiveCompoundRent - doubleAppraisement;
			BigDecimal rentFiveIncrease = BigDecimal.valueOf(rentFiveCompound);
			
			//BigDecimal rentFiveIncrease = BigDecimalSaleSqmPriceOnYear_on_YearBasis.divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP).multiply(appraisement).multiply(new BigDecimal("5"));
			//5年总收益
			//5年定投复利累计总值
			//M=a(1+x)[-1+(1+x)^n]/x  M：预期收益     a：每期定投金额     x：收益率     n：定投期数(公式中为n次方)
			double dMath = Math.pow((1.0 + liCaiLiLv), 5.0);
			double resultRentYearDouble= rentYearDouble * (1.0 + liCaiLiLv) * (-1.0 + dMath)/liCaiLiLv;
			BigDecimal fiveRentCompoundBigDecimal = BigDecimal.valueOf(resultRentYearDouble).setScale(2, BigDecimal.ROUND_HALF_UP);
			Double fiveRentCompoundBigDecimalDouble = fiveRentCompoundBigDecimal.doubleValue();
			BigDecimal rentfiveTotalManage = fiveRentCompoundBigDecimal.subtract(rentXianzhi).add(rentFiveIncrease).setScale(2, BigDecimal.ROUND_HALF_UP);
			String rentfiveTotalManageString = rentfiveTotalManage.toString();
			if(rentfiveTotalManageString.length() >=8){
				rentfiveTotalManageResult = rentfiveTotalManage.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) + "万元";
			}else{
				rentfiveTotalManageResult = rentfiveTotalManage.setScale(2,BigDecimal.ROUND_HALF_UP) + "元";
			}
			
			//持有收益
			BigDecimal  benefitOfCarry = funtureOneYearIncrease.add(rentYear).add(rentManageSy);
			//持有评分
		    if(appraisement.compareTo(new BigDecimal(0)) == 0){
		    	rentFen = new BigDecimal(0);
		    }else{
		    	rentFen = rentfiveTotalManage.divide(new BigDecimal(5)).divide(appraisement,4,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal("0.007"), 1, BigDecimal.ROUND_HALF_UP);
		    }
			
			
			BigDecimal big = new BigDecimal(0);
			if(rentFen.compareTo(big) ==-1){
				rentFen = big;
			}
			BigDecimal bigTen = new BigDecimal(10);
			if(rentFen.compareTo(bigTen) ==1){
				rentFen = bigTen;
			}
			String resultCompare = "";
			BigDecimal compare = salefiveTotalManage.subtract(rentfiveTotalManage);
			
			
			if(compare.compareTo(new BigDecimal(0)) == 1){
				resultCompare = "高于";
			}else{
				resultCompare = "低于";
			}
			Double absCompare = compare.doubleValue();
			Double doubleAbsCompare = Math.abs(absCompare);
			compare = new BigDecimal(doubleAbsCompare);
			String compareValue = compare.toString();
			if(compareValue.length() >=8){
				compareValueResult = compare.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) + "万元";
			}else{
				compareValueResult = compare.setScale(2,BigDecimal.ROUND_HALF_UP) + "元";
			}
			
			
			saleAppreciationAnalyze.setSaleFen(saleFen);
			saleAppreciationAnalyze.setRentfirstYearManagerResult(rentfirstYearManagerResult);
			saleAppreciationAnalyze.setRentfiveTotalManageResult(rentfiveTotalManageResult);
			saleAppreciationAnalyze.setRentFen(rentFen);
			saleAppreciationAnalyze.setRentAvgDay(60);
			saleAppreciationAnalyze.setRent_year_rant(resultrent_year_rant);
			saleAppreciationAnalyze.setResultCompare(resultCompare);
			saleAppreciationAnalyze.setCompareValueResult(compareValueResult);
			Long end = System.currentTimeMillis();
			//Long time = end - begin;
			//System.out.println(time);
		}
		catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
			res.setData(saleAppreciationAnalyze);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
			
		
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}
	
	
	/**
	 * 房产评估次数限制
	 */
	@RequestMapping(value="/houseAvmLimit", produces="text/html;charset=UTF-8")
    @ResponseBody
	public String houseAvmLimit(HttpServletRequest request, HttpServletResponse response){
		
		String userId = request.getParameter("userId");
		Date assessTime =  new java.sql.Date(new java.util.Date().getTime());
		
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdfDay.format(assessTime);
		int dayAvm = 0;
		int monthAvm = 0;
		Parameter param = new Parameter();
		Map map = new HashMap();
		
		String startDay = StringUtil.getFirsDay(date);
		String endDay = StringUtil.getEndDay(date);
		Date startDate =  new java.sql.Date(new java.util.Date().getTime());
		Date endDate =  new java.sql.Date(new java.util.Date().getTime());
		
		try {
			startDate = new java.sql.Date(sdfDay.parse(startDay).getTime());
			endDate = new java.sql.Date(sdfDay.parse(endDay).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
		JSONResult res = new JSONResult();
		try {
			if(userId != null){
				param.setUserId(userId);
				param.setAssessTime(assessTime);
				param.setStartDate(startDate);
				param.setEndDate(endDate);
				//dayAvm = houseInfoService.houseAvmDayLimit(param);
				monthAvm = houseInfoService.houseAvmMonthLimit(param);
			}
			if(monthAvm >= 20){
				map.put("monthAvm", "土豪，您这个月的评估次数用完了，下个月再来看看吧");
			}
			if(monthAvm < 20){
				map.put("monthAvm", "当月可评估");
			}
			/*if(dayAvm >= 1){
				map.put("dayAvm", "您今天评估次数已用完");
			}
			
			if(dayAvm < 1){
				map.put("dayAvm", "当日可评估");
			}*/
			
			
			res.setData(map);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	}
