package com.cindata.housekeeper.web.controller.system;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.filter.LoginFilter;
import com.cindata.housekeeper.web.model.HouseChangeLog;
import com.cindata.housekeeper.web.model.HouseInfo;
import com.cindata.housekeeper.web.model.houseAndUserData;
import com.cindata.housekeeper.web.service.HouseInfoService;
import com.cindata.housekeeper.web.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用服务
 * @author yangss
 * @date   2017.06.20 09:47
 */
@Controller
@RequestMapping(value = "/sys/house")
public class SysHouseController {


    @Resource
    private HouseInfoService houseInfoService;
    @Autowired
	private UserInfoService userInfoService;

    /**
     * 地区房产top排行
     */
    @RequestMapping(value="/getHouseTop", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHouseTop(HttpServletRequest request, HttpServletResponse response){
        JSONResult res = new JSONResult();

        Integer type = StringUtil.parseInt(request.getParameter("type"),null);//1：按省份2：按城市
        Integer topNum = StringUtil.parseInt(request.getParameter("topNum"),null);

        Parameter params = new Parameter();
        try{
            if(type!=null&&topNum!=null){
                params.setType(type);
                params.setTopNum(topNum);
                String groupId = LoginFilter.userInfo.getGroupId();
                params.setGroupId(groupId);
                List<Map> list = houseInfoService.getHouseTop(params);
                res.setData(list);
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
     * 用户房产总值top排行
     */
    @RequestMapping(value="/getHousePriceTop", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHousePriceTop(HttpServletRequest request, HttpServletResponse response){
        JSONResult res = new JSONResult();

        Integer topNum = StringUtil.parseInt(request.getParameter("topNum"),null);

        Parameter params = new Parameter();
        try{
            if(topNum!=null){
                params.setTopNum(topNum);
                String groupId = LoginFilter.userInfo.getGroupId();
                params.setGroupId(groupId);
                List<Map> list = houseInfoService.getHousePriceTop(groupId);
                if(!list.isEmpty()) {
                    if (topNum > list.size()) {
                        topNum = list.size();
                    }
                    list = list.subList(0, topNum);
                    res.setData(list);
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
     * 房产列表
     */
    @RequestMapping(value="/getHouseList", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getHouseList(HttpServletRequest request, HttpServletResponse response){
    	
        JSONResult res = new JSONResult();
        String groupId = LoginFilter.userInfo.getGroupId();
        List<HouseInfo> listData = new ArrayList<HouseInfo>();
        List<Map> list = new ArrayList<Map>();

        Parameter params = new Parameter();
        String userId = request.getParameter("userId");
        Date startDate = StringUtil.parseDate(request.getParameter("startDate"),null);
        Date endDate = StringUtil.parseDate(request.getParameter("endDate"),null);
        endDate = StringUtil.parseDate(StringUtil.getDayDate(endDate,1),null);
        Integer page = StringUtil.parseInt(request.getParameter("page"),null);
        Integer rows = StringUtil.parseInt(request.getParameter("rows"),null);
        Long provinceId = StringUtil.parseLong(request.getParameter("provinceId"),null);
        Long cityId = StringUtil.parseLong(request.getParameter("cityId"),null);
        Long districtId = StringUtil.parseLong(request.getParameter("districtId"),null);
        try {
            params.setStartDate(startDate);
            params.setEndDate(endDate);
            params.setUserId(userId);
            params.setGroupId(groupId);
            params.setPage(page);
            params.setRows(rows);
            params.setProvinceId(provinceId);
            params.setCityId(cityId);
            params.setDistrictId(districtId);
            listData = houseInfoService.getHouseList(params);
            list = houseInfoService.getHouseListCount(params);
			/*Page<UserInfo> pages = new Page<UserInfo>();
			pages.setList(list);*/
            Map map =new HashMap();
            if(!list.isEmpty()){
                map = list.get(0);
                map.put("data",listData);
            }


            res.setData(map);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();;
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
    

    /**
     * 房产及用户的统计数据
     */

    @RequestMapping(value="/houseAndUserData", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String houseCount(HttpServletRequest request, HttpServletResponse response, HouseChangeLog changeInfo,HouseInfo houseInfo){
    	String resultData = "";
    	String resultDataA = "";
    	 Double doubleA = 100000000.0;
    	 Double doubleB = 10000.0;
    	 BigDecimal yi = StringUtil.parseBigDecimal(doubleA, null);
         
         BigDecimal wan = StringUtil.parseBigDecimal(doubleB, null);
         houseAndUserData hAndUser1 = new houseAndUserData();
         
        JSONResult res = new JSONResult();
        try{
        	
            // 总房产
            Map m1 = houseInfoService.houseCountAndPrice();
            Long houseCount = StringUtil.parseLong(m1.get("COUNT"),0L);
            BigDecimal housePrice = StringUtil.parseBigDecimal(m1.get("PRICE"),new BigDecimal(0));
            String housePriceStr = "";
            if(housePrice.compareTo(yi) == 1){
                housePriceStr =  housePrice.divide(yi,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|亿元";
            }else if(housePrice.compareTo(wan) == 1){
                housePriceStr = housePrice.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|万元";
            }else{
                housePriceStr = housePrice.toString()+"|元";
            }
            hAndUser1.setHouseCount(houseCount);
            hAndUser1.setAccessHouseTotal(housePriceStr);
            //昨日添加房产
            Map m2 = houseInfoService.houseCountAndPriceYesterday();
            Long houseCountYesterday = StringUtil.parseLong(m2.get("COUNT"),0L);
            BigDecimal housePriceYesterday = StringUtil.parseBigDecimal(m2.get("PRICE"),new BigDecimal(0));
            String housePriceYesterdayStr = "";
            if(housePriceYesterday.compareTo(yi) == 1){
                housePriceYesterdayStr = housePriceYesterday.divide(yi,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|亿元";
            }else if(housePriceYesterday.compareTo(wan) == 1){
                housePriceYesterdayStr = housePriceYesterday.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|万元";
            }else{
                housePriceYesterdayStr = housePriceYesterday.toString() +"|元";
            }
            hAndUser1.setHouseAddYesterday(houseCountYesterday);
            hAndUser1.setAddAccessHouseYesterday(housePriceYesterdayStr);
            //人均房产和人均房产总值（没添加房产的用户不在统计内）
            Map m3 = houseInfoService.userAvgHouse();
            Long userNum = StringUtil.parseLong( m3.get("USERNAME"),null);
            BigDecimal userAcgHouse = StringUtil.parseBigDecimal(houseCount / userNum ,null).setScale(2,BigDecimal.ROUND_HALF_UP);
            BigDecimal userAcgHousePrice = StringUtil.parseBigDecimal(housePrice.divide(StringUtil.parseBigDecimal(userNum,null),2, BigDecimal.ROUND_HALF_UP) ,null).setScale(2,BigDecimal.ROUND_HALF_UP);
            DecimalFormat df1 = new DecimalFormat("0.##");
            String userAcgHouseStr = df1.format(userAcgHouse).toString() + "|套/人";
            String userAcgHousePriceStr ="";

            if(userAcgHousePrice.compareTo(yi) == 1){
                userAcgHousePriceStr = userAcgHousePrice.divide(yi,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|亿元/人";
            }else if(userAcgHousePrice.compareTo(wan) == 1){
                userAcgHousePriceStr = userAcgHousePrice.divide(wan,2, BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP) +"|万元/人";
            }else{
                userAcgHousePriceStr = userAcgHousePrice.toString()+"|元/人";
            }
            hAndUser1.setUserAvgHouse(userAcgHouseStr);
            hAndUser1.setUserAvgHouseTotal(userAcgHousePriceStr);
            //用户总数
            Long userCounti = userInfoService.getUserCount();
            hAndUser1.setUserCount(userCounti);
            //昨日新增用户数
            Long userCountYesterdayi = userInfoService.userAddYesterday();
            hAndUser1.setUserCountYesterday(userCountYesterdayi);
            //昨日登录数
            Long userLoginYesterdayi = userInfoService.userLoginYesterday();
            hAndUser1.setUserLoginYesterday(userLoginYesterdayi);
            //总登录数
            Long userLoginCounti = userInfoService.userLoginCount();
            hAndUser1.setUserLoginCount(userLoginCounti);

        res.setData(hAndUser1);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        }catch(Exception e){
        	 e.printStackTrace();
             res.setMessage("no ok");
             res.setStatusCode(2);
             res.setSuccess(false);
        }
        
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }
}
