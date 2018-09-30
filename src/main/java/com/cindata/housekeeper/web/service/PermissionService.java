package com.cindata.housekeeper.web.service;

import java.util.List;

import com.cindata.housekeeper.web.model.BackstagePermission;


public interface PermissionService {

	BackstagePermission selectPermission(String p);

	List<BackstagePermission> queryPermission();

	
}
