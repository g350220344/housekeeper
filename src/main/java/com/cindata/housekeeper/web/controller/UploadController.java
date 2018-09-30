package com.cindata.housekeeper.web.controller;


import com.cindata.housekeeper.core.common.tools.*;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping(value = "/upload")
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	//@Resource
	//private IFileInfoService fileServ;

	/**
	 * 文件上传 本地调用
	 */
	@RequestMapping(value = "/upload2.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload2(HttpServletRequest request,
			@RequestParam MultipartFile[] fileupload,
			HttpServletResponse response, String model) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "x-requested-with");

		Map result = new HashMap<>();
		result.put("result", 1);
		result.put("msg", "上传成功");
		List<String> pathList = uploadAll(request, fileupload, model);
		result.put("pathList", pathList);
		return CommonHelper.getJsonObject(result);
	}

	/**
	 * 文件上传 APP调用
	 */
	@RequestMapping(value = "/uploadApp.do")
	@ResponseBody
	public String uploadApp(HttpServletRequest request,
			@RequestParam MultipartFile[] fileupload,
			HttpServletResponse response, String model) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");

		Map result = new HashMap<>();
		result.put("result", 1);
		result.put("msg", "上传成功");
		List<String> pathList = uploadAll(request, fileupload, model);
		result.put("pathList", pathList);
		return CommonHelper.getJsonObject(result);
	}

	/*
	 * 文件上传 共通
	 */
	public List<String> uploadAll(HttpServletRequest request,
			@RequestParam MultipartFile[] fileupload, String model) {
		List<String> pathList = new ArrayList<>();
		String type = "", filepath = "", id = "", fileUpload = "";
		// 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
		// 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
		// 并且上传多个文件时，前台表单中的所有<input
		// type="file"/>的name都应该是fileupload，否则参数里的fileupload无法获取到所有上传的文件
		for (MultipartFile myfile : fileupload) {
			if (myfile.isEmpty()) {
				System.out.println("文件未上传");
			} else {
				System.out.println("文件长度: " + myfile.getSize());
				System.out.println("文件类型: " + myfile.getContentType());
				System.out.println("文件名称: " + myfile.getName());
				System.out.println("文件原名: " + myfile.getOriginalFilename());
				System.out.println("========================================");
				int pos = myfile.getOriginalFilename().lastIndexOf(".");
				type = myfile.getOriginalFilename().substring(pos);

				String imageName = new Date().getTime() + type;
				// 得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)
				File imageFile = new File(request.getSession()
						.getServletContext().getRealPath("/upload")
						+ "/" + imageName);
				File imageFile1 = new File(request.getSession()
						.getServletContext().getRealPath("/upload")
						+ "/small_" + imageName);
				fileUpload = request.getSession().getServletContext()
						.getRealPath("/upload")
						+ "/";
				File f1 = new File(fileUpload);

				// 如果文件夹不存在创建文件夹
				if (!f1.exists()) {
					boolean isMkdirsSucess = f1.mkdirs();
					if (!isMkdirsSucess) {
						System.out.println("创建文件目录失败");
					}
				}

				// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
				String realPath = request.getSession().getServletContext()
						.getRealPath("/upload")
						+ "/";
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				try {
					FileUtils.copyInputStreamToFile(myfile.getInputStream(),
							new File(realPath, imageName));
				} catch (IOException e) {
					e.printStackTrace();
				}

				filepath = imageFile.getPath().substring(
						imageFile1.getPath().indexOf("upload") - 1);
				filepath = filepath.replaceAll("\\\\", "/");
				pathList.add(filepath);
//				try {//图片压缩
//					PubMethod.reduceImageByRatio(imageFile, imageFile1, 4, 4);
//
//				} catch (IOException e) {
//					e.printStackTrace();
//				}

			}
		}

		return pathList;
	}
	
	
	/**
	 * 文件上传 跨域
	 */
	@RequestMapping(value = "/uploadList", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(HttpServletRequest request,
						 @RequestParam(value = "file", required = false) MultipartFile[] files,
			HttpServletResponse response, String model) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers", "x-requested-with");
		Map result = new HashMap<>();
//		List<String> pathList = uploadAll(request, fileupload, model);
		List<String> pathList = ImageServerUtil.uploadAllByImageServer(request, files);
		result.put("result", 1);
		result.put("msg", "上传成功");
		result.put("pathList", pathList);
		String resultStr = CtrlerUtil.getRetBody(request, result);
		return resultStr;
	}
	

	/**
	 * 文件上传
	 */
	@RequestMapping(value = "/uploadTest", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String upload(Model model, HttpServletRequest request, //此时传的是参数，不是对象
						 @RequestParam MultipartFile multipartFile)     //使用SpringMVC注解RequestParam来指定表单中的file参数；
			throws IOException {

		String ret = "1";
// 获取上传的文件保存的路径
		String path =  request.getSession().getServletContext().getRealPath("upload");
// 获取上传的文件的名称
		String filename = multipartFile.getOriginalFilename();
//修改文件名称 uuid
		String fileUUIDname = UUID.randomUUID().toString();
//获取后缀
		String prefix=filename.substring(filename.lastIndexOf(".")+1);
//修改后完整的文件名称
		String NewFileName = fileUUIDname + "." + prefix;
//完整的路径
		String completepath = path +"\\"+ NewFileName;
//判空
		if(filename != null && filename != ""){
//判断文件类型
			if(filename.endsWith(".xls") || filename.endsWith(".xlsx")){
//创建文件夹upload
/*File targetFile = new File(path, filename);
//判断文件夹是否已经存在，如果已经存在了重新建
if (!targetFile.exists()) {
targetFile.mkdirs();
}
//转存文件
multipartFile.transferTo(targetFile);*/
				FileUtil.Upload(path, NewFileName, multipartFile);
//把地址传给前台
				model.addAttribute("fileUrl", request.getContextPath() +"/upload/" + filename);
			}else{
				ret = "2";
			}
		}else{
			ret = "3";
		}
		return ret;
	}

	@RequestMapping(value = "/upload3")
	public void import_tg_resource(@RequestParam(value = "file", required = false) MultipartFile[] files, HttpServletRequest request
			,HttpServletResponse response, ModelMap model) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.addHeader("Access-Control-Max-Age", "1800");//30 min
		Long name = StringUtil.parseLong(request.getParameter("name"),null);
		List<String> pathList = new ArrayList<>();
		String filepath = "";
		System.out.println("开始批量上传:文件数量：" + files.length);
		for (MultipartFile myfile : files) {
			/*if (myfile.isEmpty()) {
				logger.error("文件未上传");
			} else {
				logger.debug("文件长度: " + myfile.getSize());
				logger.debug("文件类型: " + myfile.getContentType());
				logger.debug("文件名称: " + myfile.getName());
				logger.debug("文件原名: " + myfile.getOriginalFilename());
				logger.debug("========================================");
				filepath = ImageServerUtil.uploadMultipartFile(myfile);
				pathList.add(filepath);

				try {//这里插入文件表
					//fileServ.insertFile(myfile.getContentType(), filepath, StringUtil.dateFormat(new Date(), "yyyy-MM", ""), null, null, null, null, null);
				} catch (Exception e) {
					logger.error("insert 文件信息表时失败，");
					e.printStackTrace();
				}

			}*/
			/*String path = request.getSession().getServletContext().getRealPath("upload");
			String fileName = file.getOriginalFilename();
			String prefix = fileName.substring(fileName.lastIndexOf("."));
			fileName = new Date().getTime() + prefix;
 System.out.println("保存路径 " + path);
			File targetFile = new File(path, fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
			} catch (IOException e) {
				e.printStackTrace();
			}*/

		}
	}
	@RequestMapping(value = "/upload4")
	public void import_tg_resource( HttpServletRequest request
			,HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.addHeader("Access-Control-Max-Age", "1800");//30 min
		String cityId = ServletRequestHelper.getParameter(request, "file", null);
		String str = cityId.substring(cityId.indexOf(",")+1,cityId.length());
		//String str = cityId;//str为接收的base64
		String fileName = "d://"; // path1为存放的路径,strname为文件名
		byte[] bytes = new byte[0]; // 将base64解码后将字符串放到byte数组
		try {
			bytes = new BASE64Decoder().decodeBuffer(str);
			ByteArrayInputStream in = new ByteArrayInputStream(bytes);
			byte[] buffer = new byte[1024];
			/*File logosavedir = new File(path1);// path1为存放的路径
			if (!logosavedir.exists()) {// 如果不存在文件夹，则自动生成
				logosavedir.mkdirs();
			}*/
			FileOutputStream out = new FileOutputStream(fileName+"111.pdf");
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = in.read(buffer)) != -1) {
				bytesum += byteread;
				out.write(buffer, 0, byteread); // 文件写操作
				out.flush();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 　　* 将一个字符串转化为输入流
	 　　*/
	public static InputStream getStringStream(String sInputString){
	if (sInputString != null && !sInputString.trim().equals("")){
	try{
	ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
	return tInputStringStream;
	}catch (Exception ex){
	ex.printStackTrace();
	}
	}
	return null;
	}
}
