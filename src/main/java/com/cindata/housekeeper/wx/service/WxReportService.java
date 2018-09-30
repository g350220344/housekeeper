package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxReport;

import java.util.List;
import java.util.Map;

public interface WxReportService {

	/**
	 * 获取用户订阅列表（分页）
	 */
	List<Map> selectUserReportByPage(Map<String,Object> bean);
	/**
	 * 获取用户订阅总数（分页）
	 */
	int selectUserReportByPageCount(Map<String, Object> bean);
	
	/**
	 * 获取用户订阅列表明细（分页）
	 */
	List<Map> selectUserReportDetailByPage(Map<String,Object> bean);
	/**
	 * 获取用户订阅总数明细（分页）
	 */
	int selectUserReportDetailByPageCount(Map<String, Object> bean);
	
	List<WxReport> selectAllUserReportByUserId(Map<String, Object> bean);
	
	List<WxReport> selectReport(WxReport reportInfo);

    List<WxReport> getWxReportByUserIdAndCommunityId(String userId, String communityId);

	int updateReporStatus();

	int updateReporRead();

	int addReport(WxReport wxReport);

	int updateReporPay(String out_trade_no);

	WxReport selectReportById(String reportId);

	List<WxReport> getReportCont(String communityId);

	int updateReporReadByUserIdAndCommunityId(String userId, String communityId);

    int deleteReportByUserId(String userId);
}
