package com.cindata.housekeeper.web.service;

import com.cindata.housekeeper.web.model.DistrictInfo;

import java.util.List;

public interface DistrictService {
    List<DistrictInfo> getDistrictInfoListByDistrictName(String districtName);
}
