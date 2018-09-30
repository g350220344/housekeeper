package com.cindata.housekeeper.core.common.tools;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {
	
//	public static void main(String[] args) {
//		createFolder("d:\\asdf\\asdf\\asdf\\asdf");
//	}

	/**
	 * 出错了则删除创建的文件夹和文件
	 * */
	public static void deleteFile(File file){
		if(!file.exists()){
			return;
		}
		if(file.isFile()){
			file.delete();
			return;
		}
		File []p = file.listFiles();
		for(int i = 0;i<p.length;i++){
			deleteFile(p[i]);
		}
		file.delete();
	}
	
	/**
	 * 创建目录
	 * @param path C:\\Users\\XXXX\\Desktop\\JavaScript
	 */
	public static boolean createFolder(String path) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			file.mkdirs();
			return false;
		}
		return true;
	}

	public static void createFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据图片路径获取图片base64码
	 * @return
	 */
	public static String getImageStr(String path) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Base64Encoder encoder = new Base64Encoder();
        return encoder.encode(data);
    }
	public static String Upload(String uploadpath,String filename,//path 上传路径  filename 文件名称
								@RequestParam MultipartFile multipartFile) throws IllegalStateException, IOException {
//获取文件后缀名
// String prefix=filename.substring(filename.lastIndexOf(".")+1);
// //修改后的文件名
//        String fileUUIDname = UUID.randomUUID().toString();
		//修改后的文件名(带后缀)
//        String NewFileName = filename + "." + prefix;
		//修改后的完整路径
		//uploadpath = uploadpath + "\\" + NewFileName;
		/**
		 * 此处只负责上传文件没有条件判断(比如文件类型判断)
		 * 参数为    1.上传文件名称   2.上传路径   3.MultipartFile对象
		 */
		File targetFile = new File(uploadpath, filename);
//判断文件夹是否已经存在，如果已经存在了重新建
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
//转存文件
		multipartFile.transferTo(targetFile);
		return "succ";

	}
	}
