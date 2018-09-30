package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.AssessResult;
import com.cindata.housekeeper.wx.model.*;
import com.cindata.housekeeper.wx.service.WxHouseInfoService;
import com.cindata.housekeeper.wx.service.WxRentService;
import com.cindata.housekeeper.wx.service.WxUserService;
import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping(value = "/WxRent")
public class WxRentController {

	private static Logger log = LoggerFactory.getLogger(WxRentController.class);

	@Autowired
	private WxRentService rentService;

	@Autowired
	private WxHouseInfoService wxhouseInfoService;

	@Autowired
	private WxUserService wxUserService;

	/**
	 * @Describe 增加租约
	 * @Author takzhang
	 * @Time 2018/08/13
	 * @param
	 **/
	@RequestMapping(value = "/addLease", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addRent(@Validated WxRentInfo rentInfo, BindingResult br,HttpServletRequest request, HttpServletResponse response) {
		JSONResult<Object> res = new JSONResult<Object>();
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

		JSONResult<WxRentInfo> resWxRentInfo = new JSONResult<WxRentInfo>();
		resWxRentInfo.setStatusCode(1);
		resWxRentInfo.setMessage("ok");
		resWxRentInfo.setSuccess(true);
		try {
			rentService.insertRent(rentInfo);
		} catch (Exception e) {
			resWxRentInfo.setMessage("no ok");
			resWxRentInfo.setStatusCode(2);
			resWxRentInfo.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, resWxRentInfo);
		return resultStr;
	}

	/**
	 * @Describe 修改租约
	 * @Author takZhang
	 * @Time 2018/08/13
	 * @param
	 **/
	@RequestMapping(value = "/updateLease", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateRentInfo(@Validated WxRentInfo rentInfo,BindingResult br, HttpServletRequest request,HttpServletResponse response) {
		JSONResult<Object> res = new JSONResult<Object>();
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

		JSONResult<WxRentInfo> resWxRentInfo = new JSONResult<WxRentInfo>();



		try {
			if (StringUtils.isBlank(rentInfo.getId())) {
				resWxRentInfo.setMessage("ID不能为空");
				resWxRentInfo.setSuccess(false);
				resWxRentInfo.setStatusCode(2);
			}else{
				resWxRentInfo.setMessage("成功");
				resWxRentInfo.setSuccess(true);
				resWxRentInfo.setStatusCode(1);
				rentService.updateRent(rentInfo);
			}
		} catch (Exception e) {
			resWxRentInfo.setMessage(e.getMessage());
			resWxRentInfo.setSuccess(false);
			resWxRentInfo.setStatusCode(2);
		}
		String resultStr = CtrlerUtil.getRetBody(request, resWxRentInfo);
		return resultStr;
	}

	/**
	 * @Describe 修改租约
	 * @Author takZhang
	 * @Time 2018/08/13
	 * @param
	 **/
	@RequestMapping(value = "/delectLease", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String delectLease(WxRentInfo rentInfo, HttpServletRequest request,HttpServletResponse response) {
		JSONResult<WxRentInfo> res = new JSONResult<WxRentInfo>();
		res.setMessage("成功");
		res.setSuccess(true);
		res.setStatusCode(1);
		if (StringUtils.isBlank(rentInfo.getId())) {
			res.setMessage("ID不能为空");
			res.setSuccess(false);
			res.setStatusCode(2);
			return CtrlerUtil.getRetBody(request, res);
		}

		try {
			rentService.deleteRent(rentInfo);
		} catch (Exception e) {
			res.setMessage(e.getMessage());
			res.setSuccess(false);
			res.setStatusCode(2);
		}

		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * @Describe 查询
	 * @Author takZhang
	 * @Time 2018/08/13
	 * @param
	 **/
	@RequestMapping(value = "/selectNextRent", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectNextRent(@Param("houseId") String houseId,HttpServletRequest request, HttpServletResponse response) {
		JSONResult<WxSelectLease> res = new JSONResult<WxSelectLease>();
		res.setMessage("成功");
		res.setSuccess(true);
		res.setStatusCode(1);
		if (StringUtils.isBlank(houseId)) {
			res.setMessage("houseId不能为空");
			res.setSuccess(false);
			res.setStatusCode(2);
			return CtrlerUtil.getRetBody(request, res);
		}

		try {
			WxSelectLease wxSelectLease = rentService.selectNextRent(houseId);

			if (wxSelectLease == null) {//如果为空说明没有租赁的数据
                res.setData(null);res.setSuccess(false);
                return CtrlerUtil.getRetBody(request, res);
            }


			String cycle = wxSelectLease.getCycle();//租赁类型
			Date lDate = wxSelectLease.getLeaseTime();//租赁起始日期
			int termCount = wxSelectLease.getTerm();//租赁月份总数

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lDate);

			if (("1").equals(cycle)) {
                for (int i = 0; i < termCount; i++) {// 1为月付,增加一期一个月
                    if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(),new Date()) > 0) {
                        wxSelectLease.setNextTime(calendar.getTime());
                        break;
                    } else {
                        calendar.add(Calendar.MONTH, 1);// 增加一个月
                    }
                }

            } else if (("2").equals(cycle)) {// 2为季付,增加一期三个月
                for (int i = 0; i < termCount; i += 3) {
                    if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(),new Date()) > 0) {
                        wxSelectLease.setNextTime(calendar.getTime());
                        break;
                    } else {
                        calendar.add(Calendar.MONTH, 3);// 增加三个月
                    }
                }

            } else if (("3").equals(cycle)) {// 3为年付,增加一期十二个月
                for (int i = 0; i < termCount; i += 12) {
                    if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(),new Date()) > 0) {
                        wxSelectLease.setNextTime(calendar.getTime());
                        break;
                    } else {
                        calendar.add(Calendar.MONTH, 12);// 增加十二个月
                    }
                }
            }

			res.setData(wxSelectLease);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setSuccess(false);
			res.setStatusCode(2);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * @Describe 查询
	 * @Author takZhang
	 * @Time 2018/08/13
	 * @param
	 **/
	@RequestMapping(value = "/selectNextRentList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectNextRentList(@Param("houseId") String houseId,HttpServletRequest request, HttpServletResponse response) {
		JSONResult<Map> res = new JSONResult<Map>();
		res.setMessage("成功");
		res.setSuccess(true);
		res.setStatusCode(1);
		if (StringUtils.isBlank(houseId)) {
			res.setMessage("houseId不能为空");
			res.setSuccess(false);
			res.setStatusCode(2);
			return CtrlerUtil.getRetBody(request, res);
		}

		try {
			List<WxSelectLeaseList> l = rentService.selectNextRentList(houseId);
			long totalMoneyMonth = 0; //总租金/月：此房产所有租赁信息的月租金累加
			Map map = new HashMap();
			if(!l.isEmpty()) {
				for (int i = 0; i < l.size(); i++) {
					WxSelectLeaseList wxsl = l.get(i);
					String cycle = wxsl.getCycle();
					Date lDate = wxsl.getLeaseTime();
					int termCount = wxsl.getTerm();
					int imoney = wxsl.getMoney();
					String state = wxsl.getState();

					if ("1".equals(state)) {
						wxsl.setGrandTotal(imoney * termCount);
						wxsl.setMonth(termCount);
						wxsl.setNextTime(null);
					} else {
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(lDate);
						int mark = 0;//每期标记

						if (("1").equals(cycle)) {
							int markNext = 0;//下一期标记
							for (int j = 0; j < termCount; j++) {// 1为月付,增加一期一个月
								if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(), new Date()) >= 0) {
									if (StringUtil.formatDateString(calendar.getTime(), "yyyy-MM-dd").equals(StringUtil.formatDateString(wxsl.getLeaseTime(), "yyyy-MM-dd"))) {
										mark += 1;
										calendar.add(Calendar.MONTH, 1);// 增加一个月
										wxsl.setNextTime(calendar.getTime());
										wxsl.setMonth(mark);
										wxsl.setGrandTotal(mark * imoney);
										mark = 0;
									} else {
										wxsl.setNextTime(calendar.getTime());
										wxsl.setMonth(mark);
										wxsl.setGrandTotal(mark * imoney);
										mark = 0;
										markNext = 1;
									}
									break;
								} else {
									mark += 1;
									calendar.add(Calendar.MONTH, 1);// 增加一个月
								}
							}

							if (markNext == 0) {
								wxsl.setMonth(mark);
								wxsl.setGrandTotal(mark * imoney);
							}
							totalMoneyMonth += imoney;
						} else if (("2").equals(cycle)) {// 2为季付,增加一期三个月
							int markNext = 0;//下一期标记
							for (int j = 0; j < termCount; j += 3) {
								if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(), new Date()) >= 0) {
									if (StringUtil.formatDateString(calendar.getTime(), "yyyy-MM-dd").equals(StringUtil.formatDateString(wxsl.getLeaseTime(), "yyyy-MM-dd"))) {
										mark += 1;
										calendar.add(Calendar.MONTH, 3);// 增加三个月
										wxsl.setNextTime(calendar.getTime());
										wxsl.setMonth(mark * 3);
										wxsl.setGrandTotal(mark * imoney);
										mark = 0;
									} else {
										wxsl.setNextTime(calendar.getTime());
										wxsl.setMonth(mark * 3);
										wxsl.setGrandTotal(mark * imoney);
										mark = 0;
										markNext = 1;
									}

									break;
								} else {
									mark += 1;
									calendar.add(Calendar.MONTH, 3);// 增加三个月
								}
							}

							if (markNext == 0) {
								wxsl.setMonth(mark * 3);
								wxsl.setGrandTotal(mark * imoney);
							}
							totalMoneyMonth += imoney / 3;
						} else if (("3").equals(cycle)) {// 3为年付,增加一期十二个月
							int markNext = 0;//下一期标记
							for (int j = 0; j < termCount; j += 12) {
								if (StringUtil.getTwoMonthsDifferenceNoAbs(calendar.getTime(), new Date()) >= 0) {
									if (StringUtil.formatDateString(calendar.getTime(), "yyyy-MM-dd").equals(StringUtil.formatDateString(wxsl.getLeaseTime(), "yyyy-MM-dd"))) {
										mark += 1;
										calendar.add(Calendar.MONTH, 12);// 增加三个月
										wxsl.setNextTime(calendar.getTime());
										wxsl.setMonth(mark * 12);
										wxsl.setGrandTotal(mark * imoney);
										mark = 0;
									} else {
										wxsl.setNextTime(calendar.getTime());
										wxsl.setGrandTotal(mark * imoney);
										wxsl.setMonth(mark * 12);
										mark = 0;
										markNext = 1;
									}

									break;
								} else {
									mark += 1;
									calendar.add(Calendar.MONTH, 12);// 增加十二个月
								}
							}

							if (markNext == 0) {
								wxsl.setMonth(mark * 12);
								wxsl.setGrandTotal(mark * imoney);
							}
							totalMoneyMonth += imoney/12;
						}
					}
					wxsl.setRatio(new BigDecimal((float) wxsl.getMonth() / wxsl.getTerm() * 100).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
				}
				Collections.sort(l, new Comparator<WxSelectLeaseList>() {
					@Override
					public int compare(WxSelectLeaseList o1, WxSelectLeaseList o2) {
						int i = 0;
						if (o1.getNextTime() != null && o2.getNextTime() != null) {
							i = o1.getNextTime().getTime() <= o2.getNextTime().getTime() ? -1 : 1;
						} else if (o1.getNextTime() == null) {
							i = 1;
						} else if (o2.getNextTime() == null) {
							i = -1;
						}
						return i;
					}
				});
				WxSelectLeaseList wxSelectLeaseList = l.get(0);
				//房产估值
				BigDecimal housePrice = new BigDecimal(0);
				//查询房产信息
				WxHouseInfo wxHouseInfo = wxhouseInfoService.selectHouseInfoByHouseId(StringUtil.parseBigDecimal(houseId,null));
				if(wxHouseInfo!=null){
					housePrice = wxHouseInfo.getAssessSalePrice().multiply(wxHouseInfo.getBuildingsquare());
				}
				BigDecimal lv = new BigDecimal(totalMoneyMonth * 12 / housePrice.doubleValue() * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
				WxSelectLease wxSelectLease = new WxSelectLease(wxSelectLeaseList);
				wxSelectLease.setLv(lv);
				wxSelectLease.setMonthPrice(totalMoneyMonth+"");

				map.put("wxSelectLease",wxSelectLease);
				map.put("wxSelectLeaseList",l);

			}
			res.setData(map);

		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("no ok");
			res.setSuccess(false);
			res.setStatusCode(2);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}

	/**
	 * @Describe 添加租约
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	/*
	 * @RequestMapping(value="/addRent", produces="text/html;charset=UTF-8")
	 * 
	 * @ResponseBody public String addRent(WxRentInfo
	 * loanInfo,HttpServletRequest request, HttpServletResponse response){
	 * 
	 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
	 * wxUserService.selectUserIdByOpenId(WxOpenId); loanInfo.setUserId(UserId);
	 * int i = 0; JSONResult res = new JSONResult(); try { loanInfo.setState(new
	 * BigDecimal(0)); i = rentService.addRent(loanInfo); String houseId =
	 * loanInfo.getHouseId();
	 * 
	 * if(i > 0){ WxHouseInfo wxHouseInfo = new WxHouseInfo();
	 * wxHouseInfo.setHouseId(new BigDecimal(houseId));
	 * wxHouseInfo.setIsrent(new BigDecimal(1));
	 * wxhouseInfoService.updateHouse(wxHouseInfo); }
	 * 
	 * res.setData(i); res.setMessage("ok"); res.setStatusCode(1);
	 * res.setSuccess(true); } catch (Exception e) { e.printStackTrace();
	 * res.setData(i); res.setMessage("no ok"); res.setStatusCode(2);
	 * res.setSuccess(false); } String resultStr =
	 * CtrlerUtil.getRetBody(request, res); return resultStr; }
	 */

	/**
	 * @Describe 根据userId查询租约详情
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/selectRentByUserAndHouseId", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectRentByUserAndHouseId(WxRentInfo loanInfo,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
		 * wxUserService.selectUserIdByOpenId(WxOpenId);
		 * loanInfo.setUserId(UserId);
		 */
		int i = 0;
		JSONResult<List<WxRentInfo>> res = new JSONResult<List<WxRentInfo>>();
		try {
			List<WxRentInfo> list = rentService
					.selectRentByUserAndHouseId(loanInfo);
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
	 * @Describe 根据Id查询租约详情
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/selectRentByRentId", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectRentByRentId(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
		 * wxUserService.selectUserIdByOpenId(WxOpenId);
		 * loanInfo.setUserId(UserId);
		 */
		String id = request.getParameter("id");
		int i = 0;
		JSONResult<WxRentInfo> res = new JSONResult<WxRentInfo>();
		try {
			WxRentInfo wxRentInfo = rentService.selectRentByRentId(id);
			res.setData(wxRentInfo);
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
	 * @Describe 修改租约详情
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	/*
	 * @RequestMapping(value="/updateRentInfo",
	 * produces="text/html;charset=UTF-8")
	 * 
	 * @ResponseBody public String updateRentInfo(WxRentInfo
	 * loanInfo,HttpServletRequest request, HttpServletResponse response){
	 * 
	 * int i = 0; JSONResult res = new JSONResult(); try { i =
	 * rentService.updateRentInfo(loanInfo); res.setData(i);
	 * res.setMessage("ok"); res.setStatusCode(1); res.setSuccess(true); } catch
	 * (Exception e) { e.printStackTrace(); res.setData(i);
	 * res.setMessage("no ok"); res.setStatusCode(2); res.setSuccess(false); }
	 * String resultStr = CtrlerUtil.getRetBody(request, res); return resultStr;
	 * }
	 */

	/**
	 * @Describe 删除租约
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/deleteRentInfo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRentInfo(WxRentInfo loanInfo,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
		 * wxUserService.selectUserIdByOpenId(WxOpenId);
		 * loanInfo.setUserId(UserId);
		 */
		int i = 0;
		JSONResult res = new JSONResult();
		loanInfo.setState(new BigDecimal(0));
		try {
			i = rentService.deleteRentInfo(loanInfo);
			res.setData(i);
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
	 * @Describe 下期收租
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/periodRent", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String periodRent(WxRentInfo wxRentInfo, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
		 * wxUserService.selectUserIdByOpenId(WxOpenId);
		 * loanInfo.setUserId(UserId);
		 */
		WxHouseInfo houseInfo = new WxHouseInfo();
		BigDecimal houseId = new BigDecimal(0);
		String cycleName = "";
		// String userId = request.getParameter("userId");
		BigDecimal resultrentPrice = new BigDecimal(0);
		int i = 0;
		JSONResult res = new JSONResult();
		BigDecimal totalPrice = new BigDecimal(0);
		List<WxRentInfo> resultList = new ArrayList<WxRentInfo>();
		try {
			List<WxRentInfo> list = rentService
					.selectRentByUserAndHouseId(wxRentInfo);
			for (WxRentInfo wxRentHouseInfo : list) {
				WxRentInfo loanInfoResult = rentService
						.periodRent(wxRentHouseInfo);

				resultList.add(loanInfoResult);
				BigDecimal rentPrice = loanInfoResult.getMoney();
				// 总租金
				resultrentPrice = resultrentPrice.add(rentPrice);
				houseId = new BigDecimal(wxRentHouseInfo.getHouseId());

			}

			houseInfo = wxhouseInfoService.selectHouseInfoByHouseId(houseId);

			BigDecimal avmPrice1 = StringUtil.parseBigDecimal(
					houseInfo.getAssessSalePrice(), new BigDecimal(0));
			totalPrice = totalPrice.add(avmPrice1.multiply(houseInfo
					.getBuildingsquare()));

			// 年租金
			BigDecimal rentPriceOnYear = resultrentPrice
					.multiply(new BigDecimal(12));
			// 年出租回报率
			BigDecimal rentOfReturn1 = rentPriceOnYear.divide(totalPrice, 2,
					BigDecimal.ROUND_HALF_UP);
			String rentOfReturn = rentOfReturn1.multiply(new BigDecimal(100))
					.toString() + "%";

			wxRentInfo.setRentOfReturn(rentOfReturn);
			wxRentInfo.setResultrentPrice(resultrentPrice);
			wxRentInfo.setResultrentPrice(resultrentPrice);
			resultList.add(wxRentInfo);
			res.setData(resultList);
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
	 * @Describe 根据HouseId查询租约详情
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/selectRentByHouseId", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectRentByHouseId(WxRentInfo loanInfo,
			HttpServletRequest request, HttpServletResponse response) {

		int i = 0;
		JSONResult res = new JSONResult();
		try {
			List<WxRentInfo> list = rentService.selectRentByHouseId(loanInfo);
			WxRentInfo loanInfo1 = list.get(0);
			res.setData(loanInfo1);
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
	 * @Describe 租赁信息
	 * @Author gaoy
	 * @Time 2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value = "/RentInfo", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String RentInfo(WxRentInfo wxRentInfo, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * String WxOpenId = request.getParameter("WxOpenId"); String UserId =
		 * wxUserService.selectUserIdByOpenId(WxOpenId);
		 * loanInfo.setUserId(UserId);
		 */
		WxHouseInfo houseInfo = new WxHouseInfo();
		BigDecimal houseId = new BigDecimal(0);
		// String userId = request.getParameter("userId");
		BigDecimal resultrentPrice = new BigDecimal(0);
		int i = 0;
		JSONResult res = new JSONResult();
		List<WxRentInfo> resultList = new ArrayList<WxRentInfo>();
		try {
			List<WxRentInfo> list = rentService
					.selectRentByUserAndHouseId(wxRentInfo);
			for (WxRentInfo wxRentHouseInfo : list) {
				WxRentInfo loanInfoResult = rentService
						.periodRent(wxRentHouseInfo);

				resultList.add(loanInfoResult);
				BigDecimal rentPrice = loanInfoResult.getMoney();
				resultrentPrice = resultrentPrice.add(rentPrice);
				houseId = new BigDecimal(wxRentHouseInfo.getHouseId());

			}

			houseInfo = wxhouseInfoService.selectHouseInfoByHouseId(houseId);

			Long CommunityId = Long.valueOf(houseInfo.getCommunityId()
					.toString());
			String square = houseInfo.getBuildingsquare().toString();
			Long cityid = Long.valueOf(houseInfo.getCityId().toString());

			Parameter param = new Parameter();
			param.setCommunityId(CommunityId);
			param.setSquare(new BigDecimal(square));
			param.setCityId(cityid);
			String resBody = OpenapiPoster.post(param, "avm/avmSale");
			JSONResult<AssessResult> bean = (JSONResult<AssessResult>) CtrlerUtil
					.json2bean(resBody,
							new TypeToken<JSONResult<AssessResult>>() {
							}.getType());
			AssessResult assessResult = bean.getData();
			BigDecimal assessPrice = assessResult.getSaleAssessPrice();
			BigDecimal assessResultHouse = assessPrice.multiply(new BigDecimal(square));
			// 年租金
			BigDecimal rentPriceOnYear = resultrentPrice
					.multiply(new BigDecimal(12));
			// 年出租回报率
			BigDecimal rentOfReturn1 = rentPriceOnYear.divide(assessResultHouse, 2,
					BigDecimal.ROUND_HALF_UP);
			String rentOfReturn = rentOfReturn1.multiply(new BigDecimal(100))
					.toString() + "%";

			wxRentInfo.setRentOfReturn(rentOfReturn);

			wxRentInfo.setResultrentPrice(resultrentPrice);
			resultList.add(wxRentInfo);
			res.setData(resultList);
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
