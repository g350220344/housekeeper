package com.cindata.housekeeper.wx.service;

import com.cindata.housekeeper.wx.model.WxAttention;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface WxAttentionService {

	int addAttention(WxAttention wxAttention);

	int canelAttention(String userId, BigDecimal communityId);
	/**
	 * 获取用户关注列表（分页）
	 */
	List<Map> selectUserAttentionByPage(Map<String,Object> bean);
	/**
	 * 获取用户关注总数（分页）
	 */
	int selectUserAttentionByPageCount(Map<String, Object> bean);

	/**
	 * 获取用户关注的小区
	 */
	List<WxAttention> getWxAttentionInfoByUserIdAndCommunityId(String userId,String communityId);
}
