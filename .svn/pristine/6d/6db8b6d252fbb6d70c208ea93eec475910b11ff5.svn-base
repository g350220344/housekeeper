package com.cindata.housekeeper.core.common.tools;

import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageServerUtil {
	
	private static final String FAST_DFS_CONF = ImageServerUtil.class.getResource("/").getPath() + "fdfs_client.conf";
	private static final NameValuePair[] NAME_VALUE_PAIR = new NameValuePair[] { new NameValuePair("g1", "g1") };
	private static final Logger logger = LoggerFactory.getLogger(ImageServerUtil.class);
	
	
	public static void main(String[] args) {
		String s = ImageServerUtil.class.getResource("/").getPath();
		System.out.println(s);
		File f = new File("d://Test//1.pdf");

		String url = uploadFile(f);
		System.out.println(url);
		logger.debug("这是一段中文，为什么是乱码呢？");
	}
	public static List<String> uploadAllByImageServer(HttpServletRequest request,
											   @RequestParam MultipartFile[] fileupload) {
		List<String> pathList = new ArrayList<>();
		String filepath = "";
		// 如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解
		// 如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解
		// 并且上传多个文件时，前台表单中的所有<input
		// type="file"/>的name都应该是fileupload，否则参数里的fileupload无法获取到所有上传的文件
		for (MultipartFile myfile : fileupload) {
			if (myfile.isEmpty()) {
				logger.error("文件未上传");
			} else {
				logger.debug("文件长度: " + myfile.getSize());
				logger.debug("文件类型: " + myfile.getContentType());
				logger.debug("文件名称: " + myfile.getName());
				logger.debug("文件原名: " + myfile.getOriginalFilename());
				logger.debug("========================================");
				filepath = ImageServerUtil.uploadMultipartFile(myfile);
				pathList.add("http://221.208.141.164:8090/"+filepath);

				try {//这里插入文件表
					//fileServ.insertFile(myfile.getContentType(), filepath, StringUtil.dateFormat(new Date(), "yyyy-MM", ""), null, null, null, null, null);
				} catch (Exception e) {
					logger.error("insert 文件信息表时失败，");
					e.printStackTrace();
				}

			}
		}

		return pathList;
	}
	/**
	 * 上传MultipartFile文件
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadFile(File file) {
		String url = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			url = upload(IOUtils.toByteArray(is), file.getName());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return url;
	}

	/**
	 * 上传MultipartFile文件
	 * 
	 * @param file
	 * @return
	 */
	public static String uploadMultipartFile(MultipartFile file) {
		String url = null;
		try {
			url = upload(file.getBytes(), file.getOriginalFilename());
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * 上传文件
	 * 
	 * @param file
	 * @return
	 */
	public static String upload(byte[] file, String name) {
		long time0 = System.currentTimeMillis();
		logger.debug("开始上传文件");
		String url = null;
		try {
			int pos = -1;
			String type = "xfile";
			if(name != null){
				pos = name.lastIndexOf(".");
				if(pos >= 0 && pos < name.length()){
					type = name.substring(pos + 1);
				}
			}
			ClientGlobal.init(FAST_DFS_CONF);
			TrackerClient tracker = new TrackerClient();
			TrackerServer trackerServer = tracker.getConnection();
			StorageServer storageServer = null;
			StorageClient storageClient = new StorageClient(trackerServer,
					storageServer);
			String fileIds[] = storageClient.upload_file(file, type, NAME_VALUE_PAIR);
			logger.debug(fileIds.length + "");
			logger.debug("组名：" + fileIds[0]);
			logger.debug("路径：" + fileIds[1]);
			
			if(fileIds != null && fileIds.length >= 2){
				url = "/" + fileIds[0] + "/" + fileIds[1];
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		long time1 = System.currentTimeMillis();
		logger.debug("上传文件结束");
		logger.debug("用时：" + (time1 - time0) + "毫秒");
		return url;
	}

}
