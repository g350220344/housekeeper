package com.cindata.housekeeper.wx.service.impl;

import com.cindata.housekeeper.core.common.tools.CommonHelper;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.OpenapiPoster;
import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.dao.CommonMapper;
import com.cindata.housekeeper.web.model.ApplyCommunityInfo;
import com.cindata.housekeeper.wx.dao.WxAttentionMapper;
import com.cindata.housekeeper.wx.model.WxAttention;
import com.cindata.housekeeper.wx.model.WxAttentionExample;
import com.cindata.housekeeper.wx.model.WxAttentionExample.Criteria;
import com.cindata.housekeeper.wx.service.WxAttentionService;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WxAttentionServiceImpl implements WxAttentionService {

	
	@Resource
    private CommonMapper commonMapper;
	@Resource
    private WxAttentionMapper wxAttentionMapper;


	@Override
	public int addAttention(WxAttention wxAttention ) {

		int i = wxAttentionMapper.insertSelective(wxAttention);
		return i;
	}



	@Override
	public int canelAttention(String userId,BigDecimal communityId) {
		WxAttentionExample wxAttentionExample = new WxAttentionExample();
		Criteria criteria = wxAttentionExample.createCriteria();
		criteria.andUserIdEqualTo(userId).andDataIdEqualTo(communityId).andStatusEqualTo(new BigDecimal(1));
		WxAttention wxAttention = new WxAttention();
		wxAttention.setStatus(new BigDecimal(0));
		return wxAttentionMapper.updateByExampleSelective(wxAttention,wxAttentionExample);
	}

	@Override
	public List<Map> selectUserAttentionByPage(Map<String, Object> bean) {
		CommonHelper.setPage(bean, 1, 20);
		
		List<Map> dataList = wxAttentionMapper.selectUserAttentionByPage(bean);
		List<Map> resultList = new ArrayList<>();
		if(StringUtil.isNotNullOrEmpty(dataList) && dataList.size() > 0){
			Parameter param = new Parameter();
			ApplyCommunityInfo communityInfo = new ApplyCommunityInfo();
			for(Map data : dataList){
				
				param.setCommunityId(StringUtil.parseLong(data.get("DATA_ID"), null));
				
				String resBody = OpenapiPoster.post(param, "community/getApplyCommunityInfo");
				JSONResult<ApplyCommunityInfo> communityResult = (JSONResult<ApplyCommunityInfo>) CtrlerUtil.json2bean(resBody, new TypeToken<JSONResult<ApplyCommunityInfo>>() {
				}.getType());
				
				communityInfo = communityResult.getData();
				
				Map result = new HashMap();
				//获取小区信息
				result.put("communityId", data.get("DATA_ID"));
				result.put("communityName", communityInfo.getCommunityname());
				result.put("cityName", communityInfo.getCityName());
				result.put("districtName", communityInfo.getDistrictName());
				result.put("address", communityInfo.getDetailaddress());
				
				resultList.add(result);
			}
		}
		
		return resultList;
	}

	@Override
	public int selectUserAttentionByPageCount(Map<String, Object> bean) {
		
		return wxAttentionMapper.selectUserAttentionByPageCount(bean);
	}

	@Override
	public List<WxAttention> getWxAttentionInfoByUserIdAndCommunityId(String userId, String communityId) {
		WxAttentionExample wxAttentionExample = new WxAttentionExample();
		Criteria criteria = wxAttentionExample.createCriteria();
		criteria.andUserIdEqualTo(userId).andDataIdEqualTo(StringUtil.parseBigDecimal(communityId,null)).andStatusEqualTo(new BigDecimal(1));
		List<WxAttention> list = wxAttentionMapper.selectByExample(wxAttentionExample);

		return list;
	}

}
