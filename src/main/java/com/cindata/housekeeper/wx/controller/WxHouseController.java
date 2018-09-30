package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.*;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.AssessResult;
import com.cindata.housekeeper.web.model.CityInfo;
import com.cindata.housekeeper.web.model.CommunityMarket;
import com.cindata.housekeeper.web.service.CityService;
import com.cindata.housekeeper.web.service.UserInfoService;
import com.cindata.housekeeper.wx.model.*;
import com.cindata.housekeeper.wx.service.WxHouseInfoService;
import com.cindata.housekeeper.wx.service.WxLoanService;
import com.cindata.housekeeper.wx.service.WxRentService;
import com.google.common.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

@Controller
@RequestMapping(value = "/WxHouse")
public class WxHouseController {

		@Autowired
	    private WxHouseInfoService wxhouseInfoService;
	    @Autowired
		private UserInfoService userInfoService;
	    @Autowired
		private WxLoanService wxLoanService;
	    @Autowired
		private WxRentService rentService;
		@Autowired
		private CityService cityService;
	    /**
	     * 添加房产接口
	     */
	    @RequestMapping(value="/addHouse", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String addHouse(HttpServletRequest request, HttpServletResponse response, WxHouseInfo houseInfo){
	    	//Object session = request.getSession().getAttribute("userInfo");
	    	
	    	
	        JSONResult res = new JSONResult();
	        try {
	            Parameter param = new Parameter();
	            param.setCommunityId(houseInfo.getCommunityId().longValue());
	            param.setSquare(houseInfo.getBuildingsquare());
	            param.setCityId(houseInfo.getCityId().longValue());
				//评估默认属性
				param.setBuildyear("2008");
				param.setAspect("南北");
				param.setFloorplantype("两室两厅");
	            String resBody = OpenapiPoster.post(param, "avm/avmSale");
	            JSONResult<AssessResult> bean = (JSONResult<AssessResult>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<AssessResult>>(){}.getType());
	            AssessResult assessResult = bean.getData();
	            if(bean.isSuccess()) {
	                BigDecimal avmSalePrice = assessResult.getSaleAssessPrice();
	                BigDecimal avmRentPrice = assessResult.getRentAssessPrice();
	                houseInfo.setAssessSalePrice(avmSalePrice.setScale(0, BigDecimal.ROUND_HALF_UP));
	                houseInfo.setAssessRentPrice(avmRentPrice.setScale(0, BigDecimal.ROUND_HALF_UP));
	                houseInfo.setAssessTime(new Date(System.currentTimeMillis()));
	            }else{
					res.setMessage("暂无法评估，可比案例不足");
					res.setStatusCode(5);
					res.setSuccess(false);
					String resultStr = CtrlerUtil.getRetBody(request, res);
					return resultStr;
				}
	           // UserInfo userInfo = userInfoService.getUserInfoByMobile(houseInfo.getUserId());
	           // houseInfo.setReserve1(userInfo.getGroupId());
				houseInfo.setBuyPrice(houseInfo.getBuyPrice().multiply(new BigDecimal(10000)));
	           // houseInfo.setReserve2(houseInfo.getCityId().toString().substring(0,2));
	            if(!StringUtil.isNotNullOrEmpty(houseInfo.getProvinceName())&&!StringUtil.isNotNullOrEmpty( houseInfo.getProvinceId())) {
					if (StringUtil.isNotNullOrEmpty(houseInfo.getCityName())) {
						CityInfo cityInfo = new CityInfo();
						cityInfo.setCityName(houseInfo.getCityName());
						List<CityInfo> cityInfoList = cityService.getCityInfoListBycityName(cityInfo);
						if (cityInfoList.isEmpty()) {
							houseInfo.setProvinceId(StringUtil.parseBigDecimal(cityInfoList.get(0).getProvinceId(), null));
							houseInfo.setProvinceName(cityInfoList.get(0).getProvinceName());
						}
					}
				}
				if(houseInfo.getCityName().indexOf("市")<0){
					houseInfo.setCityName(houseInfo.getCityName()+"市");
				}
	            int i = wxhouseInfoService.addHouse(houseInfo);
	            if(i>0){
	                //评估成功后往用户评估记录表插入数据
	                WxHouseAvmLog houseAvmLog = new WxHouseAvmLog();
	                Date date = new Date(System.currentTimeMillis());
	                houseAvmLog.setHouseId(houseInfo.getHouseId());
	                houseAvmLog.setAssessSalePrice(houseInfo.getAssessSalePrice());
	                houseAvmLog.setAssessRentPrice(houseInfo.getAssessRentPrice());
	                houseAvmLog.setAssessTime(date);
	                wxhouseInfoService.addHouseAvm(houseAvmLog);
	                //获取近5个月小区均价，存入评估记录表中
					//调用openapi 获取上月小区均价

					Date endDate =StringUtil.getDate(StringUtil.getFirsDay(StringUtil.getMonth(-6)));
					Date startDate = StringUtil.getDate(StringUtil.getEndDay(StringUtil.getMonth(-1)));
					param.setStartDate(startDate);
					param.setEndDate(endDate);

					resBody = OpenapiPoster.post(param, "analysis/getCommunityMarketList");
					JSONResult<List<CommunityMarket>> bean2 = (JSONResult<List<CommunityMarket>>) CtrlerUtil.json2bean(resBody, new com.google.gson.reflect.TypeToken<JSONResult<List<CommunityMarket>>>() {
					}.getType());
					List<CommunityMarket> communityMarketList = bean2.getData();

					if(!communityMarketList.isEmpty()){
						for(CommunityMarket communityMarket : communityMarketList){
							BigDecimal assessSalePriceLog = communityMarket.getSalesqmprice();
							BigDecimal assessRentPriceLog = communityMarket.getRentsqmprice();
							houseAvmLog.setHouseId(houseInfo.getHouseId());
							houseAvmLog.setAssessSalePrice(assessSalePriceLog);
							houseAvmLog.setAssessRentPrice(assessRentPriceLog);
							houseAvmLog.setAssessTime(new Date(communityMarket.getDayId().getTime()));
							wxhouseInfoService.addHouseAvm(houseAvmLog);
						}
					}
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
	     * 房产详情
	     */
	    @RequestMapping(value="/getHouseInfo", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String getHouseInfo(HttpServletRequest request, HttpServletResponse response){
	    	BigDecimal houseId = StringUtil.parseBigDecimal(request.getParameter("houseId"),null);
	        JSONResult<WxHouseInfo> res = new JSONResult<>();
	        try {
	        	if(houseId!=null) {
					WxHouseInfo wxHouseInfo = wxhouseInfoService.selectHouseInfoByHouseId(houseId);
					if(wxHouseInfo!=null){
						BigDecimal assessSalePrice = StringUtil.parseBigDecimal(wxHouseInfo.getAssessSalePrice(),new BigDecimal(0));
						BigDecimal buildingsquare = StringUtil.parseBigDecimal(wxHouseInfo.getBuildingsquare(),new BigDecimal(0));
						BigDecimal assessSaleTotalPrice = assessSalePrice.multiply(buildingsquare);
						wxHouseInfo.setAssessSaleTotalPrice(assessSaleTotalPrice.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
						BigDecimal increasePrice =assessSaleTotalPrice.subtract(wxHouseInfo.getBuyPrice());
						wxHouseInfo.setIncreasePrice(increasePrice.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));


						//查询上月估值不存在的话 用小区均价
						String month = StringUtil.getLastMM();
						List<WxHouseAvmLog> list = wxhouseInfoService.getHouseAvmLogByHouseIdAndMonath(houseId,month,month);
						BigDecimal assessSalePriceLog = null;
						if(!list.isEmpty()){
							assessSalePriceLog = list.get(0).getAssessSalePrice();
						}else{
							//调用openapi 获取上月小区均价
							Parameter param = new Parameter();
							param.setMonth(StringUtil.parseDate(month+"-01",null));
							param.setCommunityId(wxHouseInfo.getCommunityId().longValue());
							String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarket");
							JSONResult<CommunityMarket> bean= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
							CommunityMarket data = bean.getData();
							assessSalePriceLog = data.getSalesqmprice();
						}
						if(assessSalePriceLog!=null) {
							BigDecimal assessSaleTotalPriceLog = assessSalePriceLog.multiply(buildingsquare);
							wxHouseInfo.setRisePrice(CommonHelper.getRisePercentNoParam(assessSaleTotalPrice, assessSaleTotalPriceLog));
							BigDecimal increasePriceLog = assessSaleTotalPriceLog.subtract(wxHouseInfo.getBuyPrice());
							wxHouseInfo.setRiseIncreasePrice(CommonHelper.getRisePercentNoParam(increasePrice, increasePriceLog));
						}
						//买入价格 去万元 保留两位小数
						wxHouseInfo.setBuyPrice(wxHouseInfo.getBuyPrice().divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
						int count = wxLoanService.getLoanCountByHouseId(houseId);
						wxHouseInfo.setLoanCount(count);
					}
					if(wxHouseInfo.getStatus().equals("0")){
						res.setData(new WxHouseInfo());
					}else{
						res.setData(wxHouseInfo);
					}

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
	    public String updateHouse(HttpServletRequest request, HttpServletResponse response, WxHouseInfo houseInfo){
	        JSONResult res = new JSONResult();
	        try {
	            int i = wxhouseInfoService.updateHouse(houseInfo);
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
	     * 删除房产接口
	     */
	    @RequestMapping(value="/deleteHouse", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String deleteHouse(HttpServletRequest request, HttpServletResponse response, WxHouseInfo houseInfo){
	        JSONResult res = new JSONResult();
	        try {
	            int i = wxhouseInfoService.deleteHouse(houseInfo);
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
	     * 房产评估
	     */
	    @RequestMapping(value="/houseAvm", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String houseAvm(HttpServletRequest request, HttpServletResponse response){
	        JSONResult<Integer> res = new JSONResult<>();
	        Long CommunityId = Long.valueOf(request.getParameter("communityId"));
	        String square = request.getParameter("square");
	        Long cityid = Long.valueOf(request.getParameter("cityId"));
	        
	        Parameter param = new Parameter();
	        param.setCommunityId(CommunityId);
	        param.setSquare(new BigDecimal(square));
	        param.setCityId(cityid);
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
	     * 房产总值接口
	     */
	    @RequestMapping(value="/getHouseAvmByUserId", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String getHouseAvmByUserId(HttpServletRequest request, HttpServletResponse response){

	        String userId = request.getParameter("userId");
	        JSONResult<HouseAvmInfo> res = new JSONResult();

	        try {
				List<WxHouseInfo> list = wxhouseInfoService.getHouseByuserId(userId);
				Set set = new HashSet();
				BigDecimal price = new BigDecimal(0);
				BigDecimal buyPrice = new BigDecimal(0);
				HouseAvmInfo houseAvmInfo = new HouseAvmInfo();
				if(!list.isEmpty()) {
					for (int i = 0; i < list.size(); i++) {
						WxHouseInfo wxHouseInfo = list.get(i);
						if(wxHouseInfo.getAssessSalePrice()!=null) {
							price = price.add(wxHouseInfo.getBuildingsquare().multiply(wxHouseInfo.getAssessSalePrice()));
						}
						buyPrice = buyPrice.add(wxHouseInfo.getBuyPrice());
						set.add(wxHouseInfo.getCityName());
					}

					Map map = wxhouseInfoService.getRankByUserId(userId);
					BigDecimal rn = (BigDecimal) map.get("RN");
					BigDecimal count = (BigDecimal) map.get("COUNT");
					BigDecimal sortPercent = (rn.divide(count, 2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100)).setScale(0);
					sortPercent = new BigDecimal(100).subtract(sortPercent);
					//本月月供
					List<WxLoanInfo> wxLoanInfoList = wxLoanService.selectLoanByUserIdAndStatus(userId, 0);
					BigDecimal loanPrice = wxLoanService.getLoanPrice(wxLoanInfoList, new java.util.Date());

					//本月收租
					List<WxRentInfo> wxRentInfoList = rentService.selectRentByUserIdAndStatus(userId, 0);
					BigDecimal rentPrice = rentService.getRentPrice(wxRentInfoList, new java.util.Date());


					houseAvmInfo.setCityCount(set.size());
					houseAvmInfo.setHouseCount(list.size());
					houseAvmInfo.setTotalPrice(price.divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP));
					houseAvmInfo.setListCity(set);
					houseAvmInfo.setSortPercent(sortPercent);
					houseAvmInfo.setTotalAppreciation(price.subtract(buyPrice).divide(new BigDecimal(10000), 2, BigDecimal.ROUND_HALF_UP));
					BigDecimal   b   =   new   BigDecimal(CommonHelper.getRisePercentNoParam(price, buyPrice));
					houseAvmInfo.setAppreciationPercent(b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue());
					houseAvmInfo.setLoanPrice(loanPrice);
					houseAvmInfo.setRentPrice(rentPrice);
				}
				res.setData(houseAvmInfo);
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
	     * 房产列表
	     */
	    @RequestMapping(value="/getHouseList", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String getHouseInfoList(HttpServletRequest request, HttpServletResponse response){
			String userId = request.getParameter("userId");
	        JSONResult<List<WxHouseInfo>> res = new JSONResult<>();

	        try {
				List<WxHouseInfo> houseInfoList  = wxhouseInfoService.getHouseByuserId(userId);
				for(WxHouseInfo wxHouseInfo:houseInfoList){
					BigDecimal assessSalePrice = StringUtil.parseBigDecimal(wxHouseInfo.getAssessSalePrice(),new BigDecimal(0));
					BigDecimal buildingsquare = StringUtil.parseBigDecimal(wxHouseInfo.getBuildingsquare(),new BigDecimal(0));
					BigDecimal assessSaleTotalPrice = assessSalePrice.multiply(buildingsquare);
					wxHouseInfo.setAssessSaleTotalPrice(assessSaleTotalPrice.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
					wxHouseInfo.setIncreasePrice(assessSaleTotalPrice.subtract(wxHouseInfo.getBuyPrice()).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
					String houseId = wxHouseInfo.getHouseId().toString();
					//本月月供
					List<WxLoanInfo> wxLoanInfoList = wxLoanService.selectLoanByHouseIdAndStatus(houseId,0);
					BigDecimal loanPrice = wxLoanService.getLoanPrice(wxLoanInfoList,new java.util.Date());
					wxHouseInfo.setLoanPrice(loanPrice);
					//本月收租
					List<WxRentInfo> wxRentInfoList = rentService.selectRentByHouseIdAndStatus(houseId,0);
					BigDecimal rentPrice = rentService.getRentPrice(wxRentInfoList,new java.util.Date());
					wxHouseInfo.setRentPrice(rentPrice);

				}
	            res.setData(houseInfoList);
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
	 * 资产信息
	 */
	@RequestMapping(value="/getAssetsInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAssetsInfo(HttpServletRequest request, HttpServletResponse response){
		BigDecimal houseId = StringUtil.parseBigDecimal(request.getParameter("houseId"),null);
		JSONResult<Map> res = new JSONResult<>();
		Map map = new HashMap();
		String[] dateArray = new String[6];//日期数组
		BigDecimal[] dataArray = new BigDecimal[6];//数据数组
		BigDecimal[] loanDataArray = new BigDecimal[6];//贷款负债数据数组
		try {
			if(houseId!=null) {
				WxHouseInfo wxHouseInfo = wxhouseInfoService.selectHouseInfoByHouseId(houseId);
				if(wxHouseInfo!=null){
					//获取所有贷款
					List<WxLoanInfo> wxLoanInfoList = wxLoanService.selectLoanByHouseIdAndStatus(houseId.toString(),0);
					//查询历史估值不存在的话 用小区均价
					for(int j=0;j<6;j++){
						String date =  StringUtil.dateFormat( StringUtil.getMonth(j-5),"MM月",null,2);
						dateArray[j] = date;
						dataArray[j] = null;
						loanDataArray[j] = null;
						String month = StringUtil.dateFormat( StringUtil.getMonth(j-5),"yyyy-MM",null,2);
						if(!wxLoanInfoList.isEmpty()){
							//计算已还本息和
							Map<String,BigDecimal> loanMap = wxLoanService.getLoanTotalPrice(wxLoanInfoList,StringUtil.parseDate(month+"-01",null));
							//贷款负债 = 总本息 - 已还本息
							BigDecimal loanLiability = loanMap.get("loanTotalPrice").subtract(loanMap.get("loanPrice"));
							loanDataArray[j] = loanLiability;
						}
						List<WxHouseAvmLog> list = wxhouseInfoService.getHouseAvmLogByHouseIdAndMonath(houseId,month,month);
						BigDecimal assessSalePriceLog = null;
						if(j<5){
							if(!list.isEmpty()){
								for(int i=0;i<list.size();i++){
									WxHouseAvmLog wxHouseAvmLog = list.get(0);
									assessSalePriceLog = wxHouseAvmLog.getAssessSalePrice();
								}
							}else{
								//调用openapi 获取上月小区均价
								Parameter param = new Parameter();
								param.setMonth(StringUtil.parseDate(month+"-01",null));
								param.setCommunityId(wxHouseInfo.getCommunityId().longValue());
								String resBody = OpenapiPoster.post(param, "analysis/getCommunityMarket");
								JSONResult<CommunityMarket> bean= (JSONResult<CommunityMarket>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<CommunityMarket>>(){}.getType());
								CommunityMarket data = bean.getData();
								assessSalePriceLog = data.getSalesqmprice();
							}
						}else{
							assessSalePriceLog = wxHouseInfo.getAssessSalePrice();
						}

						if(assessSalePriceLog!=null) {
							BigDecimal assessSaleTotalPriceLog = assessSalePriceLog.multiply(wxHouseInfo.getBuildingsquare());
							dataArray[j] = assessSaleTotalPriceLog.subtract(loanDataArray[j]!=null?loanDataArray[j]:new BigDecimal(0));
						}
					}
					if(!wxLoanInfoList.isEmpty()) {
						List list1 = new ArrayList();
						list1.add(dateArray);
						list1.add(loanDataArray);
						map.put("loanPrice",list1);
						//计算 公积金和商业贷款总值
						BigDecimal gjj = new BigDecimal(0);
						BigDecimal sd = new BigDecimal(0);
						BigDecimal xyd = new BigDecimal(0);
						BigDecimal fdd = new BigDecimal(0);
						for(WxLoanInfo wxLoanInfo : wxLoanInfoList){
							if(wxLoanInfo.getType().toString().equals("1")){
								sd = sd.add(wxLoanInfo.getMoney());
							}else if(wxLoanInfo.getType().toString().equals("2")){
								gjj = gjj.add(wxLoanInfo.getMoney());
							}else if(wxLoanInfo.getType().toString().equals("3")){
								xyd = xyd.add(wxLoanInfo.getMoney());
							}else if(wxLoanInfo.getType().toString().equals("4")){
								fdd = fdd.add(wxLoanInfo.getMoney());
							}
						}
						map.put("gjj",gjj);
						map.put("sd",sd);
						map.put("xyd",xyd);
						map.put("fdd",fdd);
					}
				}
				List list = new ArrayList();
				list.add(dateArray);
				list.add(dataArray);
				map.put("housePrice",list);
				BigDecimal housePriceNow = dataArray[5];
				if(housePriceNow!=null){
					map.put("housePriceNow",housePriceNow.divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
					Double d = StringUtil.parseDouble(housePriceNow.multiply(new BigDecimal(0.7)).divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP),null);
					map.put("preCredit",d>0?d:0);
				}


				res.setData(map);
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
	     * 下期还款
	     */
	    @RequestMapping(value="/periodRepayment", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String periodRepayment(HttpServletRequest request, HttpServletResponse response){

	    	java.util.Date dateTime = new java.util.Date();
	    	java.util.Date nowTime = new java.util.Date();
	    	Date dateResult = null;
	    	String typeResult = "";
	    	int resultFactdiff = 0;
	        String houseId = ServletRequestHelper.getParameter(request, "houseId", null);
	        String repaymentSchedule = "";
	        JSONResult<List<periodRepaymentInfo>> res = new JSONResult<List<periodRepaymentInfo>>();
	        List resultList = new ArrayList();

	        List<periodRepaymentInfo> listperiodRepaymentInfo = new ArrayList<periodRepaymentInfo>();
	        //到期时间
	        Calendar expireTime = Calendar.getInstance();
	        String rentStatus = "";
	        try {
	        	List<WxLoanInfo> LoanInfo = wxLoanService.selectLoanByHouseId(houseId);

	        	for(WxLoanInfo wxLoanInfo : LoanInfo){
	        		  BigDecimal totalLoan = new BigDecimal(0);
	        		periodRepaymentInfo periodRepaymentinfo = new periodRepaymentInfo();

	        	BigDecimal LoanMoney = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
	        	  //贷款金额
	          	BigDecimal money = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
	          	//还款方式
	          	String repayment = wxLoanInfo.getRepayment();
	          	//年利率
	          	BigDecimal rate = wxLoanInfo.getRate();
	          	//贷款渠道
	          	String channel = wxLoanInfo.getChannel();
	          	//贷款时间
	          	java.util.Date dateLoan = wxLoanInfo.getLoanTime();
	          	//贷款类型
	          	BigDecimal type = wxLoanInfo.getType();

	          	if(type.compareTo(new BigDecimal(1)) == 0){
	          		typeResult = "商业按揭贷款";
	          	}
	        	if(type.compareTo(new BigDecimal(2)) == 0){
	          		typeResult = "公积金贷款";
	          	}
	        	if(type.compareTo(new BigDecimal(3)) == 0){
	          		typeResult = "信用贷";
	          	}
	        	if(type.compareTo(new BigDecimal(4)) == 0){
	          		typeResult = "房抵贷";
	          	}
	          	//还款月数
	          	Double repatMonthNum = wxLoanInfo.getTerm().multiply(new BigDecimal(12)).doubleValue();
	          	int termLoan = wxLoanInfo.getTerm().intValue();

	          	expireTime.setTime(dateLoan);
	          	expireTime.add(Calendar.YEAR, termLoan);
	          	dateTime = expireTime.getTime();
	          	if(dateTime.after(nowTime)){
	          		rentStatus = "贷款未结清";
	          	}else{
	          		rentStatus = "贷款已结清";
	          	}






	          	//月利率
	          	BigDecimal monthly = rate.divide(new BigDecimal(12), 2,BigDecimal.ROUND_HALF_UP).divide(new BigDecimal(100));
	          	BigDecimal monthlySupply = new BigDecimal(0);
	          	Calendar calendar = Calendar.getInstance();

          		calendar.setTime(dateLoan);
          		Calendar now = Calendar.getInstance();
	          	if("等额本息".equals(repayment)){
	          		//每月月供额=〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数〕-1

	          		BigDecimal first = money.multiply(monthly).multiply(new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(), repatMonthNum)));
	          		BigDecimal two = new BigDecimal(Math.pow(new BigDecimal(1).add(monthly).doubleValue(),repatMonthNum));

	          		totalLoan = totalLoan.add(first.divide(two,2,BigDecimal.ROUND_HALF_UP).subtract(new BigDecimal(1)));


	          		int date = calendar.get(Calendar.DATE);

	          		//租约开始的下个月


	          		//当前时间
	          		java.util.Date dateNow = new java.util.Date();
	          		//Calendar now = Calendar.getInstance();
	          		//贷款年份和月份
	          		int year = now.get(Calendar.YEAR);
	          		int month1 = calendar.get(Calendar.MONTH);
	          		//当前月份
	          		int month2 = now.get(Calendar.MONTH);
	          		now.set(year, month2,date);
	          		now.add(Calendar.MONTH, 1);

	          		 dateResult = new Date(now.getTime().getTime());
	          		now.add(Calendar.MONTH, -1);
	          	//贷款的月份个数
	         		 int resultyear = (now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
	         	     int resultmonth = now.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
	         	     //已经还款月份数
	         	      resultFactdiff = resultyear + resultmonth;

	         	    repaymentSchedule = new BigDecimal(resultFactdiff).divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString() + "%";
	          	}
	        	if("等金本息".equals(repayment)){
	          		//每月月供额=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
	          		BigDecimal first = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);
	          		//每月应还本金
	          		BigDecimal monthRepayMoney = money.divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP);

	          		int date = calendar.get(Calendar.DATE);

	          		//租约开始的下个月


	          		//当前时间
	          		java.util.Date dateNow = new java.util.Date();


	          		int year = now.get(Calendar.YEAR);
	          		int month1 = calendar.get(Calendar.MONTH);
	          		int month2 = now.get(Calendar.MONTH);
	          		now.set(year, month2,date);
	          		now.add(Calendar.MONTH, 1);


	          		 dateResult = new Date(now.getTime().getTime());
	          		now.add(Calendar.MONTH, -1);
	          		//贷款的月份个数
	          		 int resultyear = (now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) * 12;
	          	     int resultmonth = now.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
	          	     //已经还款月份数
	          	      resultFactdiff = resultyear + resultmonth;
	          	     //已归还本金累计额
	          	     BigDecimal alreadyRepayMoney = monthRepayMoney.multiply(new BigDecimal(resultFactdiff));

	          	     BigDecimal two = monthly.multiply(money.subtract(alreadyRepayMoney));
	          	     BigDecimal three =  first.add(two);
	          	     totalLoan = totalLoan.add(three);
	          	   repaymentSchedule = new BigDecimal(resultFactdiff).divide(new BigDecimal(repatMonthNum),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).toString() + "%";
	          	}

	        	periodRepaymentinfo.setRentStatus(rentStatus);
	        	periodRepaymentinfo.setRepaymentDate(dateResult);
	        	periodRepaymentinfo.setRepaymentChannel(channel);
	        	periodRepaymentinfo.setRepaymentSchedule(repaymentSchedule);
	        	periodRepaymentinfo.setRepaymentDateAlready(new Integer(resultFactdiff));
	        	periodRepaymentinfo.setRepaymentDateTotal(new Integer(repatMonthNum.intValue()));
	        	periodRepaymentinfo.setRepaymentPrice(totalLoan);
	        	periodRepaymentinfo.setRepaymentType(typeResult);
	        	listperiodRepaymentInfo.add(periodRepaymentinfo);


	        	}
	            res.setData(listperiodRepaymentInfo);
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
	     * 资产分布图
	     */
	    @RequestMapping(value="/assetDistribution", produces="text/html;charset=UTF-8")
	    @ResponseBody
	    public String assetDistribution(HttpServletRequest request, HttpServletResponse response){
	    	Date dateResult = null;
	    	int resultFactdiff = 0;
	        String houseId = ServletRequestHelper.getParameter(request, "houseId", null);
	        String repaymentSchedule = "";
	        JSONResult res = new JSONResult();
	        List resultList = new ArrayList();
	        BigDecimal totalLoan = new BigDecimal(0);
	        String typeName = "";
	        Map map = new HashMap();
	    	java.util.Date date = new java.util.Date();
	    	java.util.Date now = new java.util.Date();
	        try {

	        	WxHouseInfo wxHouseInfo = wxhouseInfoService.selectHouseInfoByHouseId(new BigDecimal(houseId));
	        	  BigDecimal assessSalePrice = StringUtil.parseBigDecimal(wxHouseInfo.getAssessSalePrice(),new BigDecimal(0));
		          BigDecimal buildingsquare = StringUtil.parseBigDecimal(wxHouseInfo.getBuildingsquare(),new BigDecimal(0));
		          BigDecimal assessSalePriceTotal = assessSalePrice.multiply(buildingsquare);

		          List<WxLoanInfo> LoanInfo = wxLoanService.selectLoanByHouseId(houseId);
		        	Calendar rentTime = Calendar.getInstance();
		          if(LoanInfo != null){
		        	for(WxLoanInfo wxLoanInfo : LoanInfo){
		        		periodRepaymentInfo periodRepaymentinfo = new periodRepaymentInfo();


		        	//贷款时间
		          	java.util.Date dateLoan = wxLoanInfo.getLoanTime();
		          	rentTime.setTime(dateLoan);
		          	int term = wxLoanInfo.getTerm().intValue();
		          	//到期时间
		          	rentTime.add(Calendar.YEAR, term);
		          	date = rentTime.getTime();

		          	if(date.after(now)){

		          		 //贷款金额
			          	BigDecimal money = wxLoanInfo.getMoney().multiply(new BigDecimal(10000));
			          	//还款方式
			          	String repayment = wxLoanInfo.getRepayment();
			          	//年利率
			          	BigDecimal rate = wxLoanInfo.getRate();
			          	//贷款渠道
			          	String channel = wxLoanInfo.getChannel();

			        	BigDecimal type = wxLoanInfo.getType();

			          	if(type.compareTo(new BigDecimal(1)) == 0){
			          		typeName ="商业按揭贷款";
			    		}
			        	if(type.compareTo(new BigDecimal(2)) == 0){
			          		typeName ="公积金贷款";
			    		}
			        	if(type.compareTo(new BigDecimal(3)) == 0){
			          		typeName ="信用贷";
			    		}
			        	if(type.compareTo(new BigDecimal(4)) == 0){
			          		typeName ="房抵贷";
			    		}

			        	map.put(typeName, money);
		          	}




		        	}
		        	map.put("房净值", assessSalePriceTotal);
		          }else{
		        	  map.put("房净值", assessSalePriceTotal);
		          }

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
	/**
	 * 房产普通详情
	 */
	@RequestMapping(value="/getHouseInfoById", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getHouseInfoById(HttpServletRequest request, HttpServletResponse response){
		BigDecimal houseId = StringUtil.parseBigDecimal(request.getParameter("houseId"),null);
		JSONResult<WxHouseInfo> res = new JSONResult<>();
		try {
			if(houseId!=null) {
				WxHouseInfo wxHouseInfo = wxhouseInfoService.selectHouseInfoByHouseId(houseId);
				if(wxHouseInfo!=null){
					if(wxHouseInfo.getStatus().equals("0")){
						res.setData(new WxHouseInfo());
					}else{
						//买入价格 去万元 保留两位小数
						wxHouseInfo.setBuyPrice(wxHouseInfo.getBuyPrice().divide(new BigDecimal(10000),2,BigDecimal.ROUND_HALF_UP));
						res.setData(wxHouseInfo);
					}
				}else{
					res.setData(new WxHouseInfo());
				}
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

	    
}
