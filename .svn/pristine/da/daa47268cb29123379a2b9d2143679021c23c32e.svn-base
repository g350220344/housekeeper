package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.ChangeHomeInfo;
import com.cindata.housekeeper.web.model.ChangeHomeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChangeHomeInfoMapper {
    int countByExample(ChangeHomeInfoExample example);

    int deleteByExample(ChangeHomeInfoExample example);

    int deleteByPrimaryKey(String statementid);

    int insert(ChangeHomeInfo record);

    int insertSelective(ChangeHomeInfo record);

    List<ChangeHomeInfo> selectByExample(ChangeHomeInfoExample example);

    ChangeHomeInfo selectByPrimaryKey(String statementid);

    int updateByExampleSelective(@Param("record") ChangeHomeInfo record, @Param("example") ChangeHomeInfoExample example);

    int updateByExample(@Param("record") ChangeHomeInfo record, @Param("example") ChangeHomeInfoExample example);

    int updateByPrimaryKeySelective(ChangeHomeInfo record);

    int updateByPrimaryKey(ChangeHomeInfo record);
}