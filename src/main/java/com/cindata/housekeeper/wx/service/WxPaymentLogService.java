package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxPaymentLog;

public interface WxPaymentLogService {

	int addWxPaymentLog(WxPaymentLog payment_log_notify);
}
