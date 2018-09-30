package com.cindata.housekeeper.web.dao;


import com.cindata.housekeeper.web.model.BackstagePermission;
import com.cindata.housekeeper.web.model.BackstagePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BackstagePermissionMapper {
    long countByExample(BackstagePermissionExample example);

    int deleteByExample(BackstagePermissionExample example);

    int deleteByPrimaryKey(String permissionId);

    int insert(BackstagePermission record);

    int insertSelective(BackstagePermission record);

    List<BackstagePermission> selectByExample(BackstagePermissionExample example);

    BackstagePermission selectByPrimaryKey(String permissionId);

    int updateByExampleSelective(@Param("record") BackstagePermission record, @Param("example") BackstagePermissionExample example);

    int updateByExample(@Param("record") BackstagePermission record, @Param("example") BackstagePermissionExample example);

    int updateByPrimaryKeySelective(BackstagePermission record);

    int updateByPrimaryKey(BackstagePermission record);
}