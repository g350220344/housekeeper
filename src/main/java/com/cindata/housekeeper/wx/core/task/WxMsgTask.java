package com.cindata.housekeeper.wx.core.task;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.web.controller.WeixinServer;
import com.cindata.housekeeper.wx.model.WxHouseInfo;
import com.cindata.housekeeper.wx.model.WxLoanInfo;
import com.cindata.housekeeper.wx.model.WxRentInfo;
import com.cindata.housekeeper.wx.model.WxUserInfo;
import com.cindata.housekeeper.wx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WxMsgTask {

	
	    @Resource
	    private WxHouseInfoService wxHouseInfoService;
		@Autowired
		private WxRentService wxRentService;
		@Autowired
		private WxLoanService wxLoanService;
		@Autowired
		private WxUserService wxUserService;
		@Autowired
		private WxMessageService wxMessageService;
		//租赁贷款提醒计时器
		@Scheduled(cron = "0 0 8 * * ? ") // 每天八点三十执行
	    //@Scheduled(cron = "0 30 8 * * ? ") // 每天八点三十执行
		//@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
		//@Scheduled(cron="0 0/1 *  * * ? ")   //每5分钟执行一次
	    public void taskCycleWx() {
	    	System.out.println("使用SpringMVC框架配置定时任务");
	        List<WxUserInfo> userInfoList= wxUserService.getAllUser();
			String accessToken = WeixinServer.getAccessToken();
	        for(int i=0;i<userInfoList.size();i++){
				WxUserInfo wxUserInfo = userInfoList.get(i);
	        	String userId = wxUserInfo.getUserId();
	        	//获取用户下所有贷款信息
				List<WxLoanInfo> wxLoanInfoList = wxLoanService.selectLoanByUserId(userId);
				//获取用户下所有租房信息
				List<WxRentInfo> wxRentInfoList = wxRentService.selectRentByUserId(userId);
				wxMessageService.sendMsg(wxUserInfo,wxLoanInfoList,wxRentInfoList,StringUtil.getDay(0),accessToken);
			}
	        //System.out.println("更新"+i+"条数据");
	    }
	    //房价提醒定时器
		@Scheduled(cron = "0 45 7 11 * ? ") // 每月11日9点执行
		//@Scheduled(cron = "0 0 9 11 * ? ") // 每月11日9点执行
		//@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
		//@Scheduled(cron="0 0/1 *  * * ? ")   //每5分钟执行一次
		public void taskHouseAvm() {
	    	System.out.println("使用SpringMVC框架配置定时任务");
			List<WxUserInfo> userInfoList= wxUserService.getAllUser();
			String accessToken = WeixinServer.getAccessToken();
			for(int i=0;i<userInfoList.size();i++){
				WxUserInfo wxUserInfo = userInfoList.get(i);
				String userId = wxUserInfo.getUserId();
				//获取用户下所有房产信息
				List<WxHouseInfo> wxHouseInfoList = wxHouseInfoService.getHouseByuserId(userId);
				wxMessageService.sendHouseMsg(wxUserInfo,wxHouseInfoList,StringUtil.getDay(0),accessToken);
			}
			//System.out.println("更新"+i+"条数据");
		}
}
