package com.cindata.housekeeper.core.task;

import com.cindata.housekeeper.web.service.HouseInfoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FlightTrainTask  {
    @Resource
    private HouseInfoService houseInfoService;
    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    //@Scheduled(cron = "0 0 0 10 * ? ") // 每月10号执行执行
    public void taskCycle() {
        System.out.println("使用SpringMVC框架配置定时任务");
        //int i = houseInfoService.updateHouseAvm();
        //System.out.println("更新"+i+"条数据");
    }
}