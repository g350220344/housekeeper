package com.cindata.housekeeper.web.service.impl;

import com.cindata.housekeeper.core.common.tools.StringUtil;
import com.cindata.housekeeper.web.dao.DistrictInfoMapper;
import com.cindata.housekeeper.web.model.DistrictInfo;
import com.cindata.housekeeper.web.model.DistrictInfoExample;
import com.cindata.housekeeper.web.service.DistrictService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

	private DistrictInfoMapper districtMapper;

	@Override
	public List<DistrictInfo> getDistrictInfoListByDistrictName(String districtName) {
		List<DistrictInfo> list = new ArrayList<DistrictInfo>();
		if(StringUtil.isNotNullOrEmpty(districtName)) {
			DistrictInfoExample districtInfoExample =new DistrictInfoExample();
			DistrictInfoExample.Criteria cri = districtInfoExample.createCriteria();
			cri.andDistrictNameEqualTo(districtName);
			list = districtMapper.selectByExample(districtInfoExample);
		}
		return list;
	}
}
