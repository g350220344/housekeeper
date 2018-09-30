package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import com.cindata.housekeeper.web.model.SystemUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemUserInfoMapper {
    int countByExample(SystemUserInfoExample example);

    int deleteByExample(SystemUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(SystemUserInfo record);

    int insertSelective(SystemUserInfo record);

    List<SystemUserInfo> selectByExample(SystemUserInfoExample example);

    SystemUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SystemUserInfo record, @Param("example") SystemUserInfoExample example);

    int updateByExample(@Param("record") SystemUserInfo record, @Param("example") SystemUserInfoExample example);

    int updateByPrimaryKeySelective(SystemUserInfo record);

    int updateByPrimaryKey(SystemUserInfo record);

	List<SystemUserInfo> selectAdministratorList(Parameter params);

	List<SystemUserInfo> selectAdministratorListCountNoPage(Parameter params);
}