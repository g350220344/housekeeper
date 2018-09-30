package com.cindata.housekeeper.wx.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.cindata.housekeeper.core.common.tools.EqualAmountOfInterestUtils;
import com.cindata.housekeeper.core.common.tools.EqualAmountOfPrincipalUtils;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.wx.model.WxLoanInfo;
import com.cindata.housekeeper.wx.model.WxRentInfo;
import com.cindata.housekeeper.wx.service.WxLoanService;
import com.cindata.housekeeper.wx.service.WxRentService;
import com.cindata.housekeeper.wx.service.WxUserService;

/**
 * @description: 贷款
 * @author: liuyanming
 * @create: 2018/8/13 10:44
 **/
@Controller
@RequestMapping(value = "/WxLoan")
public class WxLoanController {


    private static Logger log = LoggerFactory.getLogger(WxLoanController.class);

    @Autowired
    private WxLoanService wxLoanService;
    @Autowired
    private WxUserService wxUserService;

    /**
     * @description: 添加贷款
     * @author: liuyanming
     * @create: 2018/8/13 13:31
     **/
    @RequestMapping(value = "/addLoan", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addLoan(@Validated WxLoanInfo loanInfo, BindingResult br, HttpServletRequest request, HttpServletResponse response) {
        JSONResult res = new JSONResult();
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = br.getAllErrors();
            for (ObjectError err : errors) {
                sb.append(err.getDefaultMessage() + "; ");
            }
            res.setSuccess(false);
            res.setMessage(sb.toString());
            return CtrlerUtil.getRetBody(request, res);
        }
        int i = 0;
        try {
            int j = StringUtil.getTwoMonthsDifferenceNotAbs(StringUtil.getMonthRetDate(loanInfo.getLoanTime(),loanInfo.getTerm().intValue()),new Date());
            if(j>0){
                loanInfo.setState(new BigDecimal(0));
            }else{
                loanInfo.setState(new BigDecimal(1));
            }

            i = wxLoanService.addLoan(loanInfo);
            res.setData(i);
            if (i != 0) {
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            } else {
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(i);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * @description: 根据userId查询贷款
     * @author: liuyanming
     * @create: 2018/8/13 13:31
     **/
    @RequestMapping(value = "/selectLoanByUserId", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectLoanByUserId(HttpServletRequest request, HttpServletResponse response) {
		/*String WxOpenId = request.getParameter("WxOpenId");
		String UserId = wxUserService.selectUserIdByOpenId(WxOpenId);*/
        String userId = request.getParameter("userId");
        if (StringUtils.isBlank(userId)) {
            return CtrlerUtil.getRetBody(request, new JSONResult("userId为空", false));
        }
        int i = 0;
        JSONResult res = new JSONResult();
        try {
            List<WxLoanInfo> list = wxLoanService.selectLoanByUserId(userId);
            res.setData(list);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(i);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * @description: 编辑贷款
     * @author: liuyanming
     * @create: 2018/8/13 13:32
     **/
    @RequestMapping(value = "/updateLoanByLoanId", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateLoanByLoanId(WxLoanInfo loanInfo, HttpServletRequest request, HttpServletResponse response) {
        JSONResult res = new JSONResult();
        if (StringUtils.isBlank(loanInfo.getId())) {
            res.setSuccess(false);
            res.setMessage("id不能为空");
            return CtrlerUtil.getRetBody(request, res);
        }

        int i = 0;
        try {
            i = wxLoanService.updateLoanByLoanId(loanInfo);
            res.setData(i);
            if (i != 0) {
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            } else {
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(i);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * @description: 删除贷款
     * @author: liuyanming
     * @create: 2018/8/13 13:32
     **/
    @RequestMapping(value = "/deleteLoan", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteLoan(WxLoanInfo loanInfo, HttpServletRequest request, HttpServletResponse response) {
        JSONResult res = new JSONResult();
        if (StringUtils.isBlank(loanInfo.getId())) {
            res.setSuccess(false);
            res.setMessage("id不能为空");
            return CtrlerUtil.getRetBody(request, res);
        }
        int i = 0;
        try {
            loanInfo.setState(new BigDecimal(2));
            i = wxLoanService.deleteLoan(loanInfo);
            res.setData(i);
            if (i != 0) {
                res.setMessage("ok");
                res.setStatusCode(1);
                res.setSuccess(true);
            } else {
                res.setMessage("no ok");
                res.setStatusCode(2);
                res.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(i);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

    /**
     * @param
     * @Describe 根据Id查询贷款
     * @Author gaoy
     * @Time 2018/01/31 09:33:02
     **/
    @RequestMapping(value = "/selectLoanById", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectLoanById(WxLoanInfo loanInfo, HttpServletRequest request, HttpServletResponse response) {
        JSONResult res = new JSONResult();
        try {
            if (StringUtils.isBlank(loanInfo.getId())) {
                res.setSuccess(false);
                res.setMessage("id不能为空");
                return CtrlerUtil.getRetBody(request, res);
            }
            List<WxLoanInfo> list = wxLoanService.selectLoan(loanInfo);
            if(list.size() > 0){
                res.setData(list.get(0));
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
     * @param
     * @Describe 根据hourseId查询贷款
     * @Author gaoy
     * @Time 2018/01/31 09:33:02
     **/
    @RequestMapping(value = "/selectLoanByHouseId", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String selectLoanByHouseId(HttpServletRequest request, HttpServletResponse response) {
        String houseId = request.getParameter("houseId");
        JSONResult res = new JSONResult();
        try {
            List<WxLoanInfo> list = wxLoanService.selectLoanByHouseId(houseId);
            res.setData(list);
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
     * @description: 下期还款和贷款列表
     * @author: liuyanming
     * @create: 2018/8/14 14:08
     **/
    @RequestMapping(value = "/list", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String list(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        String houseId = request.getParameter("houseId");
        JSONResult res = new JSONResult();
        if (StringUtils.isBlank(userId)) {
            res.setSuccess(false);
            res.setMessage("userId为空");
            return CtrlerUtil.getRetBody(request, res);
        }
        int i = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
            WxLoanInfo wxLoanInfo = new WxLoanInfo();
            wxLoanInfo.setUserId(userId);
            if (StringUtils.isNotBlank(houseId)) {
                wxLoanInfo.setHouseId(houseId);
            }
            List<WxLoanInfo> list0 = Lists.newArrayList();
            List<WxLoanInfo> list = wxLoanService.selectLoan(wxLoanInfo);
            Date curDate = new Date();
            int curDay = Integer.valueOf(dateFormat.format(curDate));
            int allCurrTerm = 0;
            int allTerm = 0;
            for (WxLoanInfo wx : list) {
                if (wx.getState().toString().equals("0")) {
                    Date loanDate = wx.getLoanTime(); // 开始贷款时间
                    int loanDay = Integer.valueOf(dateFormat.format(loanDate)); //每月几号还款
                    int differenceMonth = StringUtil.getTwoMonthsDifference(loanDate, curDate); // 当前时间和开始贷款时间相差月数
                    int currTerm = 0; // 当前已还期数
                    double invest = wx.getMoney().doubleValue() * 10000; // 本金
                    int month = wx.getTerm().intValue(); // 期数
                    double yearRate = wx.getRate().doubleValue() / 100; // 年利率
                    int nextTerm = 0;// 下一期数
                    if (loanDay < curDay) {
                        wx.setNextDate(StringUtil.getMonthRetDate(loanDate, differenceMonth + 1));
                        currTerm = differenceMonth + 1;
                    } else {
                        String nowTime = StringUtil.formatDateString(new Date(),"yyyy-MM-dd");
                        String loanTime = StringUtil.formatDateString(loanDate,"yyyy-MM-dd");
                        if(nowTime.equals(loanTime)){
                            differenceMonth +=1;
                        }
                        wx.setNextDate(StringUtil.getMonthRetDate(loanDate, differenceMonth));
                        currTerm = differenceMonth;
                    }
                    nextTerm = currTerm + 1;
                    if (StringUtils.isNotBlank(wx.getRepayment())) {
                        if (wx.getRepayment().equals("等额本息")) {
                            wx.setNextMoney(EqualAmountOfInterestUtils.getPerMonthPrincipalInterest(invest, yearRate, month));
                        } else if (wx.getRepayment().equals("等额本金")) {
                            Map<Integer, Double> getPerMonthPrincipalInterest = EqualAmountOfPrincipalUtils.getPerMonthPrincipalInterest(invest, yearRate, month);
                            Iterator<Map.Entry<Integer, Double>> iterator = getPerMonthPrincipalInterest.entrySet().iterator();
                            while (iterator.hasNext()) {
                                Map.Entry<Integer, Double> entry = iterator.next();
                                if (entry.getKey().toString().equals(nextTerm + "")) {
                                    wx.setNextMoney(entry.getValue());
                                    break;
                                }
                            }
                        }
                    }
                    wx.setCurrTerm(currTerm);
                    if (wx.getTerm().intValue() != 0) {
                        wx.setCurrPercent(String.format("%.2f", ((double) ((float) currTerm / wx.getTerm().intValue())) * 100));
                    }
                    list0.add(wx);
                    allCurrTerm += currTerm;
                } else if (wx.getState().toString().equals("1")) {
                    wx.setCurrTerm(wx.getTerm().intValue());
                    wx.setCurrPercent("100");
                    allCurrTerm += wx.getTerm().intValue();
                }
                allTerm += wx.getTerm().intValue();
            }

            Collections.sort(list0, new Comparator<WxLoanInfo>() {
                @Override
                public int compare(WxLoanInfo o1, WxLoanInfo o2) {
                    return o1.getNextDate().getTime() <= o2.getNextDate().getTime() ? -1 : 1;
                }
            });
            Map<String, Object> nextMap = Maps.newHashMap();
            nextMap.put("allCurrTerm", allCurrTerm);
            nextMap.put("allTerm", allTerm);
            if (allTerm != 0) {
                nextMap.put("allPersent", String.format("%.2f", ((double) ((float) allCurrTerm / allTerm)) * 100));
            }
            if (list0.size() > 0) {
                nextMap.put("date", list0.get(0).getNextDate());
                nextMap.put("channelName", list0.get(0).getChannelName());
                nextMap.put("typeName", list0.get(0).getTypeName());
                nextMap.put("money", list0.get(0).getNextMoney());
            }
            Map<String, Object> map = Maps.newHashMap();
            map.put("next", nextMap);
            map.put("list", list);
            res.setData(map);
            res.setMessage("ok");
            res.setStatusCode(1);
            res.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setData(i);
            res.setMessage("no ok");
            res.setStatusCode(2);
            res.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, res);
        return resultStr;
    }

}
