package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.PvUvInfo;
import com.cindata.housekeeper.web.model.PvUvInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PvUvInfoMapper {
    int countByExample(PvUvInfoExample example);

    int deleteByExample(PvUvInfoExample example);

    int insert(PvUvInfo record);

    int insertSelective(PvUvInfo record);

    List<PvUvInfo> selectByExample(PvUvInfoExample example);

    int updateByExampleSelective(@Param("record") PvUvInfo record, @Param("example") PvUvInfoExample example);

    int updateByExample(@Param("record") PvUvInfo record, @Param("example") PvUvInfoExample example);

	Long dayUvCount(PvUvInfoExample pvUvInfoExample);

	Long historyPvCount(PvUvInfoExample pvUvInfoExample);
}