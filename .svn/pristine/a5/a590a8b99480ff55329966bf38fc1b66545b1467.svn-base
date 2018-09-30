package com.cindata.housekeeper.wx.model;

import com.cindata.housekeeper.core.common.tools.StringUtil;

import java.sql.Timestamp;

public class SmsCode {

	private String sendStatusCode;//短信发送状态
	private String sendStatusMsg;//短信发送返回消息
	public String getSendStatusCode() {
		return sendStatusCode;
	}

	public void setSendStatusCode(String sendStatusCode) {
		this.sendStatusCode = sendStatusCode;
	}

	public String getSendStatusMsg() {
		if(!StringUtil.isNotNullOrEmpty(sendStatusMsg)){
			if(StringUtil.isNotNullOrEmpty(sendStatusCode)){
				switch (sendStatusCode) {
					case "160040":
						sendStatusMsg = "您的号码今日获取短信验证码次数过多，为了预防短信轰炸，今日您无法再获取短信验证码，请明日再试。";
						break;

					default:
						sendStatusMsg = "短信下发失败，请稍后重试。错误信息：短信网关未知错误。";
						break;
				}
			}
		}
		return sendStatusMsg;
	}

	public void setSendStatusMsg(String sendStatusMsg) {
		this.sendStatusMsg = sendStatusMsg;
	}

	private String mobile;

	private String ip;

	private String code;

	private String seq;

	private Timestamp sendTime;

	private String state;

	private Timestamp createTime;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq == null ? null : seq.trim();
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
