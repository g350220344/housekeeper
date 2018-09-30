package com.cindata.housekeeper.wx.controller;

import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.ServletRequestHelper;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.wx.model.SmsCode;
import com.cindata.housekeeper.wx.service.WxSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "/WxSms")
public class WxSMSController {

	
	private static Logger log = LoggerFactory.getLogger(WxSMSController.class);
	
	
	
	@Autowired
	private WxSmsService smss;

	/**
	 * 发送手机验证码
	 */
	@RequestMapping(value="/send", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String send(HttpServletRequest request, HttpServletResponse response){

		String mobile = request.getParameter("mobile");

        JSONResult<SmsCode> result = new JSONResult<>();
        String spId = "";
        String tempId = "2437068";
        try {
            SmsCode res = smss.sendSmsCode(mobile, ServletRequestHelper.getIp(request), spId,tempId);
            result.setStatusCode(1);
            result.setSuccess(true);
            result.setMessage("成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatusCode(2);
            result.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, result);
		return resultStr;
	}
    /**
     * 手机验证码 验证接口
     */
    @RequestMapping(value="/check", produces="text/html;charset=UTF-8")
    @ResponseBody
    public String chick(HttpServletRequest request, HttpServletResponse response){

        String mobile = request.getParameter("mobile");
        String code = request.getParameter("code");

        JSONResult<SmsCode> result = new JSONResult<>();
        try {
            int ct = smss.check(mobile,code);
            if(ct == 1){
                result.setStatusCode(1);
                result.setSuccess(true);
                result.setMessage("成功");
            }else if(ct == -1){
                result.setStatusCode(3);
                result.setSuccess(true);
                result.setMessage("验证码已失效，请重新获取验证码。");
            }else if(ct == 0){
                result.setStatusCode(4);
                result.setSuccess(true);
                result.setMessage("验证码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatusCode(2);
            result.setSuccess(false);
        }
        String resultStr = CtrlerUtil.getRetBody(request, result);
        return resultStr;
    }

}
