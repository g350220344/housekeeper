package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.core.common.tools.SMSUtil;
import com.cindata.housekeeper.wx.dao.SmsCodeMapper;
import com.cindata.housekeeper.wx.dao.SmsLogMapper;
import com.cindata.housekeeper.wx.model.SmsCode;
import com.cindata.housekeeper.wx.model.SmsCodeExample;
import com.cindata.housekeeper.wx.service.WxSmsService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Service
public class WxSmsServiceImpl implements WxSmsService {

	
	@Resource
	private SmsLogMapper smsLogger;
	@Resource
	private SmsCodeMapper smsCodeMapper;
	  //key
    private static String apikey = "0ec03b2171ae7785ed472a763572e232";


	@Override
	public SmsCode sendSmsCode(String mobile, String ip, String smsType, String tempId) {
		Random random = new Random();
		int code = random.nextInt(9999) % (9999 - 1000 + 1) + 1000;
		int seq = random.nextInt(9) % (9 - 1 + 1) + 1;
		SmsCode item = new SmsCode();
		try {
			// 先逻辑删除手机号码之前接到的短信验证码
			deleteCode(mobile);

			item.setCode(code + "");
			item.setIp(ip);
			item.setMobile(mobile);
			item.setSendTime(new Timestamp(System.currentTimeMillis()));
			item.setState("1");
			smsCodeMapper.insertSelective(item);
			// 模板177619
			String sendStatus = null;

//			MobileSendSmsLog log = (MobileSendSmsLog) CommonHelper.mapGet(smsSendLog, mobile);
//			String type = "yp";
//			long now = System.currentTimeMillis();
//			if(log != null){
//				long time = log.getTime();
//				if(now - time < 1800000){//如果发送间隔小于30分钟
//					type = log.getOtherType();
//				}
//			}
//			MobileSendSmsLog newLog = new MobileSendSmsLog(type, now);
//			smsSendLog.put(mobile, newLog);
			//判断云片是否成功，成功继续执行，失败调用容联
			//判断是否是短时间内第一次发送，30分钟（从2小时下调）以内再次发送，则变更短信平台，否则继续。
//			if("yp".equals(type)){
			sendStatus = SMSUtil.tplSendSms(mobile, code+"", smsLogger, ip, smsType,tempId);
			JSONObject jsonObject =  JSONObject.fromObject(sendStatus);
			String codes = jsonObject.getString("code");
			if(codes.equals("0")){
				sendStatus="000000";
			}else{
				//sendStatus = send(mobile, "177619", new String[] { code + "", "10" }, ip);
				sendStatus = "-1";
			}
//			}else{
//				sendStatus = send(mobile, "177619", new String[] { code + "", "10" }, ip);
//				if("-1".equals(sendStatus)){
//					sendStatus = SMSUtils.tplSendSms(mobile, code+"", smsLogger, ip, smsType);
//					JSONObject jsonObject =  JSONObject.fromObject(sendStatus);
//					String codes = jsonObject.getString("code");
//					if(codes.equals("0")){
//						sendStatus="000000";
//					}else{
//						sendStatus = "-1";
//					}
//				}
//			}


			item.setSendStatusCode(sendStatus);
		} catch (Exception e) {
			e.printStackTrace();
			item = null;
		}
		return item;
	}

    @Override
    public int check(String mobile, String code) {
        SmsCodeExample scexa = new SmsCodeExample();
        scexa.createCriteria().andMobileEqualTo(mobile).andStateEqualTo("1");
        scexa.setOrderByClause(" SEND_TIME DESC");
        List<SmsCode> list = smsCodeMapper.selectByExample(scexa);
		int cnt = 0; //0：验证码错误 1:成功 -1验证码失效
        if(!list.isEmpty()){

			SmsCode sc = list.get(0);
			if(code.equals(sc.getCode())){
				Timestamp sendTime = sc.getSendTime();
				long sendL = 0l;
				if (sendTime != null) {
					sendL = sendTime.getTime();
				}
				if (System.currentTimeMillis() - sendL > 10 * 60 * 1000) {
					cnt = -1;
				} else {
					cnt = 1;
				}
			}


		}
        return cnt;
    }
    public int deleteCode(String mobile) {
        SmsCodeExample scexa = new SmsCodeExample();
        scexa.createCriteria().andMobileEqualTo(mobile);
        SmsCode item = new SmsCode();
        item.setState("0");// 状态1有效0失效
        return smsCodeMapper.updateByExampleSelective(item, scexa);
    }
}
