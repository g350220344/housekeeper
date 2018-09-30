package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.wx.dao.WxPaymentLogMapper;
import com.cindata.housekeeper.wx.model.WxPaymentLog;
import com.cindata.housekeeper.wx.service.WxPaymentLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WxPaymentLogServiceImpl implements WxPaymentLogService {

	
	@Resource
    private WxPaymentLogMapper wxPaymentLogMapper;


	@Override
	public int addWxPaymentLog(WxPaymentLog payment_log_notify) {
		return wxPaymentLogMapper.insertSelective(payment_log_notify);
	}
}
