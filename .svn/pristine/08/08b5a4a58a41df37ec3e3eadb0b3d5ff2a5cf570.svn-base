package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.UserInfo;
import com.cindata.housekeeper.web.model.UserInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);
    
    int userAvgHouse();

	int userLoginCount();

    List<UserInfo> getUserInfoList(Parameter params);

    List<Map> getUserInfoListCount(Parameter params);

	int countByExample1(Map<String, Object> param);

	int userLoginCount1(Map<String, Object> param);
}