package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.DistrictInfo;
import com.cindata.housekeeper.web.model.DistrictInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictInfoMapper {
    int countByExample(DistrictInfoExample example);

    int deleteByExample(DistrictInfoExample example);

    int insert(DistrictInfo record);

    int insertSelective(DistrictInfo record);

    List<DistrictInfo> selectByExample(DistrictInfoExample example);

    int updateByExampleSelective(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);

    int updateByExample(@Param("record") DistrictInfo record, @Param("example") DistrictInfoExample example);

}