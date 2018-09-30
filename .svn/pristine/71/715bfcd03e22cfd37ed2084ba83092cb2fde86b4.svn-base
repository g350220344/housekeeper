package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.web.model.UserBehaviorLog;
import com.cindata.housekeeper.web.model.UserBehaviorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBehaviorLogMapper {
    int countByExample(UserBehaviorLogExample example);

    int deleteByExample(UserBehaviorLogExample example);

    int insert(UserBehaviorLog record);

    int insertSelective(UserBehaviorLog record);

    List<UserBehaviorLog> selectByExample(UserBehaviorLogExample example);

    int updateByExampleSelective(@Param("record") UserBehaviorLog record, @Param("example") UserBehaviorLogExample example);

    int updateByExample(@Param("record") UserBehaviorLog record, @Param("example") UserBehaviorLogExample example);
}