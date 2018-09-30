package com.cindata.housekeeper.web.controller.backstage;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.controller.system.SysUserInfoControllor;
import com.cindata.housekeeper.web.model.AdministratorListInfo;
import com.cindata.housekeeper.web.model.BackStageAndPermissionInfo;
import com.cindata.housekeeper.web.model.BackstagePermission;
import com.cindata.housekeeper.web.model.BackstageUserInfo;
import com.cindata.housekeeper.web.model.BackstageUserList;
import com.cindata.housekeeper.web.model.GroupInfo;
import com.cindata.housekeeper.web.model.GroupList;
import com.cindata.housekeeper.web.model.GroupListInfo;

import com.cindata.housekeeper.web.model.PvUvInfo;
import com.cindata.housekeeper.web.model.SystemUserInfo;
import com.cindata.housekeeper.web.model.pvUvCount;
import com.cindata.housekeeper.web.service.BackstageUserInfoService;
import com.cindata.housekeeper.web.service.PermissionService;
import com.cindata.housekeeper.web.service.PvUvService;
import com.cindata.housekeeper.web.service.UserInfoService;
import com.cindata.housekeeper.core.entity.JSONResult;
import com.cindata.housekeeper.core.common.tools.CtrlerUtil;
import com.cindata.housekeeper.core.common.tools.PayWxCommonUtil;
import com.cindata.housekeeper.core.common.tools.StringUtil;


/**
 * @Describe 后台
 * @Author  gaoy
 * @Time  2018/01/31 09:33:02
 * @param
 **/
@Controller
@RequestMapping(value = "/backstage")
public class BsUserInfoController {
	
	/*private static int uvCount;
	
	

	public static int getUvCount() {
		return uvCount;
	}


	public static void setUvCount(int uvCount) {
		BsUserInfoController.uvCount = uvCount;
	}*/

	@Autowired
	private BackstageUserInfoService backstageUserInfoService;
	@Autowired
	private PermissionService permissionService;
	@Autowired
	private PvUvService pvUvService;
	@Autowired
	private UserInfoService userInfoService;
	
	
	/**
	 * @Describe 登录
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/login", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BackstageUserInfo BackstageUserInfo = null;
		String message = "";
        
		try {
			if(StringUtil.isNotNullOrEmpty(username)){
				BackstageUserInfo = backstageUserInfoService.getBackstageUserInfoByUserName(username);
				if(BackstageUserInfo==null){
					message = "用户名不存在";	
				}else{
					if(password.equals(BackstageUserInfo.getPassword())){
						message = "ok";
						
						res.setData(BackstageUserInfo);
						
						request.getSession().setAttribute("BackstageUserInfo", BackstageUserInfo);
					}else{
						message = "密码错误";
					}
				}
				BackstageUserInfo.setLastLoginTime(new Date(System.currentTimeMillis()));
				//更新最后登录时间
				backstageUserInfoService.updateLastLoginTime(BackstageUserInfo);
			}
			res.setMessage(message);
			res.setStatusCode(1);
			res.setSuccess(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	

	/**
	 * @Describe 修改密码
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/updatepassword", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updatepassword(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		BackstageUserInfo BackstageUserInfoupdate = new BackstageUserInfo();
		BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
		String username = BackstageUserInfo.getUsername();
		//String passwordNew = backstageUserInfoService.selectpasswordByUsername(username);
		
		//初始密码
		String opassword = request.getParameter("opassword");
		//确认密码
		String qrpassword = request.getParameter("qrpassword");
		String message = "";
		int i = 0;
		try {
			if(StringUtil.isNotNullOrEmpty(opassword)){
				if(opassword.length() >=6 && opassword.length() <=14){
					if((BackstageUserInfo.getPassword()).equals(opassword)){
						//修改的新密码
						String password = request.getParameter("password");
						if(password.equals(qrpassword)){
							
							BackstageUserInfo.setPassword(password);
							i = backstageUserInfoService.updatepassword(BackstageUserInfo);	
							
							res.setMessage("ok");
							res.setStatusCode(1);
							res.setSuccess(true);
						}else{
							res.setData("两次输入的密码不一致");
							res.setMessage("no ok");
							res.setStatusCode(2);
							res.setSuccess(false);
						}
						
					}else{
						res.setData("原密码错误");
						res.setMessage("no ok,原密码错误");
						res.setStatusCode(2);
						res.setSuccess(false);
					}
				}else{
					res.setData("密码长度不在范围内");
					res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false);
				}
				
				
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}
	
	
	/**
	 * @Describe 后台人员列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/backstageUserList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String backstageUserList(HttpServletRequest request, HttpServletResponse response){
		JSONResult<BackstageUserList> res = new JSONResult<BackstageUserList>();
		BackstageUserList backstageUserList = new BackstageUserList();
		List<BackStageAndPermissionInfo> resultList = new ArrayList<BackStageAndPermissionInfo>();
		//JSONResult<List<CityInfo>> res = new JSONResult<List<CityInfo>>();
		
		BackstagePermission permissionInfo = null;
		boolean b = false;
		String message = "";
		String result = "";
		BackStageAndPermissionInfo bap = null;
		List<BackstageUserInfo> list = new ArrayList<BackstageUserInfo>();
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("7")){
				String name = request.getParameter("name");
				
				String page = request.getParameter("page");
				String rows = request.getParameter("rows");
				Parameter params = new Parameter();
				params.setPage(StringUtil.parseInt(page, null));
				params.setRows(StringUtil.parseInt(rows, null));
				params.setName(name);
				
				 int count = backstageUserInfoService.countbackstageUserList(params);
				 list = backstageUserInfoService.selectBackstageUser(params);
				 for(BackstageUserInfo buserInfo : list){
					 bap = new BackStageAndPermissionInfo();
					 permissionInfo = new BackstagePermission();
					String permission_Id = buserInfo.getPermissionId();
					//String psermissionIds = buserInfo.getPermissionId();
					String[] ps  = permission_Id.split(",");
					for(String p : ps){
						BackstagePermission permission = permissionService.selectPermission(p);
						String permissionId = permission.getPermission();
						result += permissionId + ",";
						
					}
					result = result.substring(0, result.length()-1);
					permissionInfo.setPermission(result);
					bap.setBackstageUserInfo(buserInfo);
					bap.setBackstagePermission(permissionInfo);
					
					resultList.add(bap);
				 }
				
				 
				 backstageUserList.setResultList(resultList);
				 backstageUserList.setCount(count);
					res.setData(backstageUserList);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true);
			}else{
			
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(true);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}

	
	/**
	 * @Describe 创建企业
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/createGroup", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String createGroup(@RequestParam(value = "file", required = false) MultipartFile[] files,GroupInfo groupInfo,HttpServletRequest request, HttpServletResponse response,ModelMap model){
		
		JSONResult res = new JSONResult();
		String type = request.getParameter("resultType");
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			String resultPath = "";
			String resultAll = "";
			if(permissions.contains("1") && type.equals("add")){
				 String groupName = groupInfo.getGroupName();
				 GroupInfo selectgroupInfo = backstageUserInfoService.selectBank(groupName);
				 if(selectgroupInfo == null){
					 
					 response.addHeader("Access-Control-Allow-Origin", "*");
						response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
						response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
						response.addHeader("Access-Control-Max-Age", "1800");//30 min
						Long name = StringUtil.parseLong(request.getParameter("name"),null);

						System.out.println("开始批量上传:文件数量：" + files.length);
						for (MultipartFile file : files) {
							String path = request.getSession().getServletContext().getRealPath("upload");
							String fileName = file.getOriginalFilename();
							String prefix = fileName.substring(fileName.lastIndexOf("."));
							fileName = new java.util.Date().getTime() + prefix;
				 System.out.println("保存路径 " + path);
							File targetFile = new File(path, fileName);
							if (!targetFile.exists()) {
								targetFile.mkdirs();
							}
							 resultPath = path + "\\"  + fileName;
							 resultAll = resultPath;
							groupInfo.setLogo(resultPath);
							try {
								file.transferTo(targetFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
						//groupInfo.setGroupId(UUID.randomUUID().toString());
					 int i  = backstageUserInfoService.createGroup(groupInfo);
						
					 if(i>0){
						 	res.setData(i);
							res.setMessage("ok");
							res.setStatusCode(1);
							res.setSuccess(true); 
					 }else{
						 	
							res.setMessage("no ok");
							res.setStatusCode(2);
							res.setSuccess(false);
					 }
				 }else{
					 res.setData("此企业已存在");
						res.setMessage("no ok");
						res.setStatusCode(2);
						res.setSuccess(false); 
				 }		
			}
			
			if(permissions.contains("3") && type.equals("update")){
				
				String logo = "";
				 response.addHeader("Access-Control-Allow-Origin", "*");
					response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
					response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
					response.addHeader("Access-Control-Max-Age", "1800");//30 min
					Long name = StringUtil.parseLong(request.getParameter("name"),null);

					System.out.println("开始批量上传:文件数量：" + files.length);
					for (MultipartFile file : files) {
						
						String path = request.getSession().getServletContext().getRealPath("upload");
						String fileName = file.getOriginalFilename();
						
						if(fileName.equals("")){
							GroupInfo  groupInfo1= backstageUserInfoService.querygroup(groupInfo.getGroupId());
							
							if(groupInfo1 != null){
								groupInfo.setLogo(groupInfo1.getLogo());
							}
						}else{
							String prefix = fileName.substring(fileName.lastIndexOf("."));
							fileName = new java.util.Date().getTime() + prefix;
				 System.out.println("保存路径 " + path);
							File targetFile = new File(path, fileName);
							if (!targetFile.exists()) {
								targetFile.mkdirs();
							}
							 resultPath = path + "\\"  + fileName;
							groupInfo.setLogo(resultPath);
							try {
								file.transferTo(targetFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
						
					}
		           int i = backstageUserInfoService.updategroupList(groupInfo);
		           if(i > 0){
		        	    res.setData(i);
						res.setMessage("ok");
						res.setStatusCode(1);
						res.setSuccess(true); 
		           }else{
		        		res.setMessage("no ok");
		    			res.setStatusCode(2);
		    			res.setSuccess(false);
		           }	
				}if(!((permissions.contains("3") && type.equals("update"))|| (permissions.contains("1") && type.equals("add")))){
					res.setMessage("权限不足");
	    			res.setStatusCode(2);
	    			res.setSuccess(false);
				}
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
		
	}
	
	
	/**
	 * @Describe 企业列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/groupList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String groupList(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		GroupListInfo groupList = new GroupListInfo();
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("2")){
				
				String status = request.getParameter("status");
				Date startDate = StringUtil.parseDate(request.getParameter("startDate"),null);
				Date endDate = StringUtil.parseDate(request.getParameter("endDate"),null);
				String groupName = request.getParameter("groupName");
				String page = request.getParameter("page");
				String rows = request.getParameter("rows");
				Parameter params = new Parameter();
				params.setStartDate(startDate);
				params.setEndDate(endDate);
	            params.setStatus(status);
	            params.setGroupName(groupName);
	            params.setPage(StringUtil.parseInt(page, null));
	            params.setRows(StringUtil.parseInt(rows, null));
	           
	            int count = backstageUserInfoService.countgroupList(params);
	            List<GroupList> list = backstageUserInfoService.groupList(params);
	            
	            groupList.setCount(count);
	            groupList.setGroupList(list);
	           
				res.setData(groupList);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true); 
					
			}else{
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 添加管理员
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/addAdministrator", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addAdministrator(SystemUserInfo systemUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		//SystemUserInfo systemUserInfo = new SystemUserInfo();
		String type = request.getParameter("resultType");
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("5") && type.equals("add")){
				String userName = systemUserInfo.getUsername();
				SystemUserInfo systemUserInfoByUserName = backstageUserInfoService.selectUserName(userName);
				if(systemUserInfoByUserName == null){
					String groupName = request.getParameter("groupName");
					GroupInfo selectGroupId = backstageUserInfoService.selectBank(groupName);
					String resultGroupId = selectGroupId.getGroupId();
					systemUserInfo.setGroupId(resultGroupId);
					systemUserInfo.setCreateDate(new Date(System.currentTimeMillis()));
					
					int i = backstageUserInfoService.insertBankadministrator(systemUserInfo);
					if(i > 0){
						res.setData(i);
						res.setMessage("ok");
						res.setStatusCode(1);
						res.setSuccess(true); 
					}else{
						
						res.setMessage("no ok");
						res.setStatusCode(2);
						res.setSuccess(false); 
					}
				  }else{
					res.setData("此用户名已存在");
					res.setMessage("no ok,此用户名已存在");
					res.setStatusCode(2);
					res.setSuccess(false); 
				 }	
					
			   }
			
			if(permissions.contains("5") && type.equals("update")){
				
				int i = backstageUserInfoService.updateAdministratorList(systemUserInfo);
				if(i > 0){
					res.setData(i);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
				}else{
					res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false); 
				}
							
				}
				if(!permissions.contains("5")){
					 res.setMessage("权限不足");
				     res.setStatusCode(2);
					 res.setSuccess(false);
				   }
				
		    } catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		  }
		   String resultStr = CtrlerUtil.getRetBody(request, res);
		   return resultStr;
	    }
	
	
	/**
	 * @Describe 管理员列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/AdministratorList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String AdministratorList(HttpServletRequest request, HttpServletResponse response){
		AdministratorListInfo administratorList = new AdministratorListInfo();
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		SystemUserInfo systemUserInfo = new SystemUserInfo();
		Parameter params = new Parameter();
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("4")){
				String page = request.getParameter("page");
				String rows = request.getParameter("rows");
				String groupId = request.getParameter("groupId");
				 params.setPage(StringUtil.parseInt(page, null));
		         params.setRows(StringUtil.parseInt(rows, null));
		         params.setGroupId(groupId);
		    List<SystemUserInfo> list = backstageUserInfoService.selectAdministratorList(params);
		    int count = backstageUserInfoService.selectAdministratorListCountNoPage(params);
			
			administratorList.setSystemUserInfo(list);
			administratorList.setCount(count);
			res.setData(administratorList);
			res.setMessage("ok");
			res.setStatusCode(1);
			res.setSuccess(true); 
						
			}else{
			res.setMessage("权限不足");
			res.setStatusCode(2);
			res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 编辑管理员列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/updateAdministrator", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateAdministrator(SystemUserInfo updatesystemUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		SystemUserInfo systemUserInfo = new SystemUserInfo();
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("4")){
				
			int i = backstageUserInfoService.updateAdministratorList(updatesystemUserInfo);
			if(i > 0){
				res.setData(i);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true); 
			}else{
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false); 
			}
						
			}else{
			res.setMessage("权限不足");
			res.setStatusCode(2);
			res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 删除管理员
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/deleteAdministrator", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateAdministratorList(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		SystemUserInfo systemUserInfo = new SystemUserInfo();
		String id = request.getParameter("id");
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("4")){
				SystemUserInfo selectsystemUserInfo = backstageUserInfoService.selectAdministrator(id);
				selectsystemUserInfo.setDr(new BigDecimal(1));
				selectsystemUserInfo.setId(id);
			int i = backstageUserInfoService.deleteAdministratorList(selectsystemUserInfo);
			if(i > 0){
				res.setData(i);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true); 
			}else{
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false); 
			}
						
			}else{
			res.setMessage("权限不足");
			res.setStatusCode(2);
			res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 编辑后台人员员列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/updateBackStageList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updateBackStageList(BackstageUserInfo updateBackstageUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		SystemUserInfo systemUserInfo = new SystemUserInfo();
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("7")){
				
			int i = backstageUserInfoService.updateBackStageList(updateBackstageUserInfo);
			if(i > 0){
				res.setData(i);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true); 
			}else{
				res.setMessage("no ok");
				res.setStatusCode(2);
				res.setSuccess(false); 
			}
						
			}else{
			res.setMessage("权限不足");
			res.setStatusCode(2);
			res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 添加后台人员员
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/addBackStageUser", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addBackStageUser(BackstageUserInfo backstageUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
		GroupInfo groupInfo = new GroupInfo();
		SystemUserInfo systemUserInfo = new SystemUserInfo();
		Parameter param = new Parameter();
		String type = request.getParameter("resultType");
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("8") && type.equals("add")){
				
				String username = request.getParameter("username");
				
				List<BackstageUserInfo> list = backstageUserInfoService.selectBackstageUser(param);
				if(list.size() > 0){
				int i = backstageUserInfoService.addBackStageUser(backstageUserInfo);
				if(i > 0){
					res.setData(i);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
				}else{
					res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false); 
				}
				}else{
					res.setMessage("no ok,此用户名已存在");
					res.setStatusCode(2);
					res.setSuccess(false); 
				}
						
			}
			
			if(permissions.contains("8") && type.equals("update")){
				
				int i = backstageUserInfoService.updateBackStageList(backstageUserInfo);
				if(i > 0){
					res.setData(i);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
				}else{
					res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false); 
				}
							
				}
				if(!permissions.contains("8")){
					res.setMessage("权限不足");
					res.setStatusCode(2);
					res.setSuccess(false); 
				}
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	

	/**
	 * @Describe pvuv信息(uv指ip访问项目的总个数，pv指用户访问了项目的总次数)
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/pvUvInfo", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String pvUvInfo(BackstageUserInfo backstageUserInfo,HttpServletRequest request, HttpServletResponse response){
		
		//pvUvCount pvUvCount = new pvUvCount();
		JSONResult res = new JSONResult();
		PvUvInfo pvuvInfo = new PvUvInfo();
		String ip = PayWxCommonUtil.getClientIp(request);
		String type = request.getParameter("type");
		String userid = request.getParameter("userid");
		String groupId =  userInfoService.selectUserGroupIdByUid(userid);
		pvuvInfo.setIp(ip);
		pvuvInfo.setUserid(userid);
		pvuvInfo.setType(type);
		pvuvInfo.setGroupid(groupId);
		try {
		//  PvUvInfo pvUvInfo =	pvUvService.selectByUserip(ip);
		 
			  int i = pvUvService.insertPvUv(pvuvInfo);
				if(i > 0){
					//uvCount+=1;
					res.setData(i);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true);
				}else{
					res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false);
				}
			
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	
	/**
	 * @Describe 修改企业列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/updategroupList", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updategroupList(GroupInfo groupInfo,HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
	
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("3")){
		
	           int i = backstageUserInfoService.updategroupList(groupInfo);
	           
				res.setData(i);
				res.setMessage("ok");
				res.setStatusCode(1);
				res.setSuccess(true); 
					
			}else{
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * @Describe 查询企业
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/querygroup", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String querygroup(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
	
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("3")){
				String groupId = request.getParameter("groupId");
	          GroupInfo  groupInfo= backstageUserInfoService.querygroup(groupId);
	           if(groupInfo != null){
	        	   res.setData(groupInfo);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
	           }else{
	        	   res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(true);
	           }
				
					
			}else{
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * @Describe 查询管理员
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/querySystemUser", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String querySystemUser(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
	
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("5")){
				String id = request.getParameter("id");
				Parameter param = new Parameter();

	          SystemUserInfo  systemUserInfo= backstageUserInfoService.querySystemUser(id);
	           if(systemUserInfo != null){
	        	   res.setData(systemUserInfo);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
	           }else{
	        	   res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false);
	           }
				
					
			}else{
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * @Describe 查询后台人员
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/queryBackStageUser", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryBackStageUser(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
	
		
		try {
			BackstageUserInfo BackstageUserInfo = (BackstageUserInfo)request.getSession().getAttribute("BackstageUserInfo");
			String permissions = BackstageUserInfo.getPermissionId();
			if(permissions.contains("8")){
				String id = request.getParameter("id");
				Parameter param = new Parameter();

	          BackstageUserInfo  backstageUserInfo= backstageUserInfoService.queryBackstageUser(id);
	           if(backstageUserInfo != null){
	        	   res.setData(backstageUserInfo);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
	           }else{
	        	   res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(true);
	           }
				
					
			}else{
				res.setMessage("权限不足");
				res.setStatusCode(2);
				res.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
	
	/**
	 * @Describe 查询权限列表
	 * @Author  gaoy
	 * @Time  2018/01/31 09:33:02
	 * @param
	 **/
	@RequestMapping(value="/queryPermission", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryPermission(HttpServletRequest request, HttpServletResponse response){
		
		JSONResult res = new JSONResult();
	
		try {

	        List<BackstagePermission> list = permissionService.queryPermission();
	           if(list != null){
	        	   res.setData(list);
					res.setMessage("ok");
					res.setStatusCode(1);
					res.setSuccess(true); 
	           }else{
	        	   res.setMessage("no ok");
					res.setStatusCode(2);
					res.setSuccess(false);
	           }
				
		} catch (Exception e) {
			e.printStackTrace();
			//res.setData(cityInfoList);
			res.setMessage("no ok");
			res.setStatusCode(2);
			res.setSuccess(false);
		}
		String resultStr = CtrlerUtil.getRetBody(request, res);
		return resultStr;
	}
}
