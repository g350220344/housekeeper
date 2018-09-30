package com.cindata.housekeeper.web.dao;


import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.GroupInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupInfoMapper {
    long countByExample(GroupInfoExample example);

    int deleteByExample(GroupInfoExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(GroupInfo record);

    int insertSelective(GroupInfo record);

    List<GroupInfo> selectByExample(GroupInfoExample example);

    GroupInfo selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") GroupInfo record, @Param("example") GroupInfoExample example);

    int updateByExample(@Param("record") GroupInfo record, @Param("example") GroupInfoExample example);

    int updateByPrimaryKeySelective(GroupInfo record);

    int updateByPrimaryKey(GroupInfo record);

	List selectGroupList();

	List<GroupInfo> getGroupList(Parameter param);

	List<GroupInfo> getCountGroupListNoPage(Parameter params);
}