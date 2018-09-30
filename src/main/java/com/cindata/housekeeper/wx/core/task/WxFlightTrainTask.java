package com.cindata.housekeeper.wx.core.task;

import com.cindata.housekeeper.wx.service.WxHouseInfoService;
import com.cindata.housekeeper.wx.service.WxLoanService;
import com.cindata.housekeeper.wx.service.WxRentService;
import com.cindata.housekeeper.wx.service.WxReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class WxFlightTrainTask {

	
	    @Resource
	    private WxHouseInfoService wxHouseInfoService;
		@Resource
		private WxReportService wxReportService;
		@Resource
		private WxLoanService wxLoanService;
		@Resource
		private WxRentService wxRentService;
	    @Scheduled(cron = "0 0 0 10 * ? ") // 每月10号执行执行
	    public void taskCycleWx() {
	        System.out.println("使用SpringMVC框架配置定时任务");
			int i = 0;
			try {
				i = wxHouseInfoService.updateHouseAvm();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("更新"+i+"条数据");
			//更新报告状态
			try {
				i = wxReportService.updateReporRead();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

	@Scheduled(cron = "0 0 0 * * ? ") // 每天0点执行
	//@Scheduled(cron="0/20 * *  * * ? ")   //每5秒执行一次
	public void taskStatus() {
		System.out.println("使用SpringMVC框架配置定时任务");
		int i =0;
		try {
			//更新订阅状态
			i = wxReportService.updateReporStatus();
			System.out.println("订阅数据更新"+i+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("订阅数据更新失败");
		}
		try {
			//更新贷款状态
			i = wxLoanService.updateLoanStatus();
			System.out.println("贷款数据更新"+i+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("贷款数据更新失败");
		}
		try {
			//更新租约状态
			i = wxRentService.updateRentStatus();
			System.out.println("租约数据更新"+i+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("租约数据更新失败");
		}
	}
}
