package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.wx.model.*;

import java.util.List;
import java.util.Map;

public interface WxMessageService {

	int addMessage(WxMessage wxMessage);

	List<WxMessage> selectMessageByUserId(String userId);

    /**
     * @Describe 消息推送
     * @Author  gaoy
     * @Time  2018/08/08 10:03:40
     * @param
     **/
    public Map sendMsg(WxUserInfo user, List<WxLoanInfo> wxLoanInfoList, List<WxRentInfo> wxRentInfoList, String date,String accessToken);

    public Map  sendHouseMsg(WxUserInfo wxUserInfo, List<WxHouseInfo> wxHouseInfoList, String day,String accessToken);

    long getCount(String userId);

    List<WxMessage> getMessageListByUserId(Parameter parameter);

    long getNoReadCount(String userId);

    List<WxMessage> getNoReadMessageListByUserId(String userId);

    int updateReadStatus(String messageId);
}
