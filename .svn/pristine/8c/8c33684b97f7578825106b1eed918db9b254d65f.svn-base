package com.cindata.housekeeper.web.dao;


import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.BackstageUserInfo;
import com.cindata.housekeeper.web.model.BackstageUserInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackstageUserInfoMapper {
    long countByExample(BackstageUserInfoExample example);

    int deleteByExample(BackstageUserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(BackstageUserInfo record);

    int insertSelective(BackstageUserInfo record);

    List<BackstageUserInfo> selectByExample(BackstageUserInfoExample example);

    BackstageUserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BackstageUserInfo record, @Param("example") BackstageUserInfoExample example);

    int updateByExample(@Param("record") BackstageUserInfo record, @Param("example") BackstageUserInfoExample example);

    int updateByPrimaryKeySelective(BackstageUserInfo record);

    int updateByPrimaryKey(BackstageUserInfo record);

	List<BackstageUserInfo> selectBackStageUser(Parameter param);

	List<BackstageUserInfo> selectCountBackStageUserNoPage(Parameter params);
}