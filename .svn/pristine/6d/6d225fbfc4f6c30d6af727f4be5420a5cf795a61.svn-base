package com.cindata.housekeeper.core.common.tools;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.aspectj.weaver.ast.Var;

//import com.cindata.housekeeper.core.entity.ResultHuanXin;
//import com.cindata.housekeeper.core.util.MD5Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 公共方法
 * 
 * @author yangss
 * 
 */
public class PubMethod {

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isObjNotEmpty(Object obj) {
		if (obj == null || "".equals(obj)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isStrNotEmpty(String str) {
		if (str == null || str.length() <= 0 || "null".equals(str)
				|| "(null)".equals(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断Map对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isMapNotEmpty(Map map) {
		if (map == null || map.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 判断Integer是否为空
	 * 
	 * @param integer
	 * @return
	 */
	public static boolean isIntegerEmpty(Integer integer) {
		if (integer == null || "null".equals(integer)) {
			return false;
		}
		return true;
	}

	/**
	 * 判断集合List是否为空
	 * 
	 * @param t
	 * @return
	 */
	public static boolean isListNotEmpty(List t) {
		if (t.size() < 1) {
			return false;
		}
		return true;
	}

	/**
	 * 把String类型转换为Date类型, 格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date string2Date(String d) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 把String类型转换为自己定义的格式的Date类型
	 * 
	 * @param d
	 * @param format
	 * @return Date
	 */
	public static Date stringToDate(String d, String format) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 把String类型转换为Date类型, 格式yyyy-MM-dd
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date string2Date2(String d) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 把String类型转换为Date类型, 格式yyyy-MM
	 * 
	 * @param str
	 * @param format
	 * @return
	 */
	public static Date string2Date3(String d) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			date = sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 把Date类型转换为String 格式yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @param format
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String Date2string(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 把Date类型转换为String 格式yyyy-MM-dd
	 * 
	 * @param str
	 * @param format
	 * @return yyyy-MM-dd
	 */
	public static String Date2string2(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 把Date类型转换为String 格式yyyy-MM-dd
	 * 
	 * @param str
	 * @param format
	 * @return yyyy-MM-dd
	 */
	public static String Date2stringCpf(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 把Date类型转换为String 格式yyyy-MM-dd HH:mm
	 * 
	 * @param str
	 * @param format
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String Date2string3(Date d) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String s = sdf.format(d);
		return s;
	}

	/**
	 * 判断图片是否是规定宽高
	 * 
	 * @param file
	 * @param fileName
	 * @return
	 */
	public static boolean isUpload(File file, int height, int width) {
		try {
			boolean flag = false;
			if (file != null) {
				BufferedImage bufferedImage = ImageIO.read(file);
				int w = bufferedImage.getWidth();
				int h = bufferedImage.getHeight();
				if (w != width || h != height) {
					flag = false;
				} else {
					flag = true;
				}
			}
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param filePath
	 * @param fileName
	 * @param content
	 * @throws Exception
	 *             生成文件并写入 防止乱码
	 */
	public static void createFile(String filePath, String fileName,
			String content) throws Exception {
		File path = new File(filePath);
		if (!path.exists()) {
			path.mkdirs();
		}
		File file = new File(filePath + fileName);
		file.createNewFile();
		OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(
				file), "gbk");
		BufferedWriter writer = new BufferedWriter(write);
		writer.write(content);
		writer.close();
	}

	/**
	 * @param f
	 * @return 读取file 内容
	 */
	public static String readFile(File f) {
		String fileContent = "";
		try {
			if (f.isFile() && f.exists()) {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(f), "gbk");
				BufferedReader reader = new BufferedReader(read);
				String line;
				while ((line = reader.readLine()) != null) {
					fileContent += line;
				}
				read.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileContent;
	}

	/**
	 * @return 获取 uuid
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 图片自动截取
	 * 
	 * @param srcPath
	 *            读取源图片路径
	 * @param toPath
	 *            写入图片路径
	 * @param readImageFormat
	 *            读取图片格式
	 * @param writeImageFormat
	 *            写入图片格式
	 */
	public static void photoCut(String srcPath, String toPath,
			String readImageFormat, String writeImageFormat, double kuanbigao) {
		InputStream fis = null;
		InputStream fis1 = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			fis = new FileInputStream(srcPath);
			fis1 = new FileInputStream(srcPath);
			// 获取图片的宽和高
			BufferedImage image = ImageIO.read(fis1);
			int width = image.getWidth();
			int height = image.getHeight();
			boolean flag = width * 1.0 / height > kuanbigao;
			// 如果flag为真，以高为基准，计算宽的值
			if (flag) {
				width = height * 5 / 3;
			} else {
				height = width * 3 / 5;
			}
			if (fis1 != null) {
				fis1.close();
			}
			Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat);
			ImageReader reader = (ImageReader) it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			// 定义一个矩形
			Rectangle rect = new Rectangle(0, 0, width, height);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, writeImageFormat, new File(toPath));
			if (fis != null)
				fis.close();
			if (iis != null)
				iis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对图片裁剪，并把裁剪新图片保存
	 * 
	 * @param srcPath
	 *            读取源图片路径
	 * @param toPath
	 *            写入图片路径
	 * @param imgName
	 *            图片名称
	 * @param x
	 *            剪切起始点x坐标
	 * @param y
	 *            剪切起始点y坐标
	 * @param width
	 *            剪切宽度
	 * @param height
	 *            剪切高度
	 * @param prop
	 *            图片缩小比例
	 */
	public static void imageCut(String srcPath, String toPath, String imgName,
			int x1, int y1, int x2, int y2, int prop) {
		FileInputStream fis = null;
		ImageInputStream iis = null;
		String readImageFormat = srcPath
				.substring(srcPath.lastIndexOf(".") + 1);
		String writeImageFormat = srcPath
				.substring(srcPath.lastIndexOf(".") + 1);
		imgName = imgName.replace("big", "small");
		try {
			// 读取图片文件
			fis = new FileInputStream(srcPath);
			Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat);
			ImageReader reader = (ImageReader) it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			// 定义一个矩形
			Rectangle rect = new Rectangle(x1 * prop, y1 * prop, x2 * prop - x1
					* prop, y2 * prop - y1 * prop);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, writeImageFormat,
					new File(toPath + "/" + imgName));
			if (fis != null)
				fis.close();
			if (iis != null)
				iis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对图片裁剪，并把裁剪新图片保存
	 * 
	 * @param srcPath
	 *            读取源图片路径
	 * @param toPath
	 *            写入图片路径
	 * @param imgName
	 *            图片名称
	 * @param x
	 *            剪切起始点x坐标
	 * @param y
	 *            剪切起始点y坐标
	 * @param width
	 *            剪切宽度
	 * @param height
	 *            剪切高度
	 * @param prop
	 *            图片缩小比例
	 */
	public static String imageCutTG(String srcPath, String toPath,
			String imgName, int x1, int y1, int x2, int y2, int prop) {
		FileInputStream fis = null;
		ImageInputStream iis = null;
		String readImageFormat = srcPath
				.substring(srcPath.lastIndexOf(".") + 1);
		String writeImageFormat = srcPath
				.substring(srcPath.lastIndexOf(".") + 1);
		// imgName = imgName.replace("big", "small");
		try {
			// 读取图片文件
			fis = new FileInputStream(srcPath);
			Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat);
			ImageReader reader = (ImageReader) it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(fis);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			// 定义一个矩形
			Rectangle rect = new Rectangle(x1 * prop, y1 * prop, x2 * prop - x1
					* prop, y2 * prop - y1 * prop);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, writeImageFormat,
					new File(toPath + "/" + imgName));
			if (fis != null)
				fis.close();
			if (iis != null)
				iis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgName;
	}

	// 地图相关：开始
	/** 地球半径，以千米(km)为计算单位 */
	private final static double EARTH_RADIUS = 6378.137;

	/** 求弧度大小 */
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 根据地球上两点间的经纬度求距离
	 * 
	 * @param lng1
	 *            经度1
	 * @param lat1
	 *            纬度1
	 * @param lng2
	 *            经度2
	 * @param lat2
	 *            纬度2
	 * @return 两点间的距离千米数(km)
	 */
	public static double getDistance(double lng1, double lat1, double lng2,
			double lat2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double dis = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		dis = dis * EARTH_RADIUS;
		dis = Math.round(dis * 100) / 100.0;// 除数写成100.0减小误差
		return dis;
	}

	// 地图相关：结束

	/**
	 * 根据图片路径获取宽高比例
	 */
	public static double rait(String srcPath) {
		double f1 = 0.0;
		try {
			InputStream fis = new FileInputStream(srcPath);
			// 获取图片的宽和高
			BufferedImage image = ImageIO.read(fis);
			int width = image.getWidth();
			int height = image.getHeight();
			double bl = width * 1.0 / height;
			BigDecimal b = new BigDecimal(bl);
			f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f1;
	}

	/**
	 * 截取内容
	 * 
	 * @param content
	 * @return
	 */
	public static String subStringContent(String content, int length) {
		if (PubMethod.isStrNotEmpty(content)) {
			if (content.length() > length) {
				return content.substring(0, length) + "...";
			}
			return content;
		} else {
			return "";
		}
	}

	/**
	 * 截取内容 不要省略号
	 * 
	 * @param content
	 * @return
	 */
	public static String subStringContent1(String content, int length) {
		if (PubMethod.isStrNotEmpty(content)) {
			if (content.length() > length) {
				return content.substring(0, length);
			}
			return content;
		} else {
			return "";
		}
	}

	/**
	 * @return 把不正确的表情 转换为????
	 */
	public static String changgeFace(char[] str) {
		for (int i = 0; i < str.length; i++) {
			if ((str[i] & 0xF8) == 0xF0) {
				for (int j = 0; j < 4; j++) {
					str[i + j] = '?';
				}
				i += 3;
			}
		}
		return str.toString();
	}

	/**
	 * 写入文件流
	 * 
	 * @param content
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
		boolean flag = false;
		// 打开一个随机访问文件流，按读写方式
		try {
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
			// 文件长度，字节数
			long fileLength = randomFile.length();
			// 将写文件指针移到文件尾。
			randomFile.seek(fileLength);
			randomFile.write(content.getBytes("utf-8"));
			randomFile.close();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 清空txt文件
	 * 
	 * @param content
	 * @param fileName
	 * @throws Exception
	 */
	public static void delTxtFile(File fileName) throws Exception {
		if (!fileName.exists()) {
			fileName.createNewFile();
		}
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName);
			o.write(new String().getBytes());
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Object 转 String
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToString(Object obj) {
		String str = obj != null ? obj.toString() : "";
		return str;
	}

	/**
	 * Object 转 String 为空的话 直接转null
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToStringNull(Object obj) {
		String str = obj != null ? obj.toString() : null;
		return str;
	}

	/**
	 * 读取 Propertie 配置文件内容
	 */
	public static String getProperties(String pname) {
		InputStream inputStream = PubMethod.class.getClassLoader()
				.getResourceAsStream("ftp.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return p.getProperty(pname);
	}

	/**
	 * 修改 Propertie 配置文件内容
	 */
	public static void updateProperties(int userId) {
		Properties p = new Properties();
		try {
			// 修改userId的属性值
			p.setProperty("UserId", userId + "");
			// 文件输出流
			FileOutputStream fos = new FileOutputStream("USERID.properties");
			// 将Properties集合保存到流中
			p.store(fos, null);
			fos.close();// 关闭流
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 判断浏览器是否支持 gzip 压缩
	 * 
	 * @param req
	 * @return boolean 值
	 */
	public static boolean isGzipSupport(HttpServletRequest req) {
		String headEncoding = req.getHeader("accept-encoding");
		if (headEncoding == null || (headEncoding.indexOf("gzip") == -1)) { // 客户端
																			// 不支持
																			// gzip
			return false;
		} else { // 支持 gzip 压缩
			return true;
		}
	}

	/**
	 * 获取多少小时之前
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeDiff(Date date) {
		Calendar cal = Calendar.getInstance();
		long diff = 0;
		Date dnow = cal.getTime();
		String str = "";
		diff = dnow.getTime() - date.getTime();
		if (diff < 86400000) { // 24 * 60 * 60 * 1000=86400000 毫秒
			if (diff >= 60 * 60 * 1000) {// 5 * 60 * 60 * 1000=18000000 毫秒
				str = (int) Math.floor(diff / (60 * 60 * 1000)) + "小时前";
			} else if (diff >= 60000 && diff < 60 * 60 * 1000) {// 1 * 60 *
																// 1000=60000 毫秒
				str = (int) Math.floor(diff / 60000) + "分钟前";
			} else {
				// str = (int) Math.floor(diff / 1000) + "秒前";
				str = "刚刚";
			}
		} else if (diff >= 86400 && diff < 172800000) {
			str = "1天前";
		} else if (diff >= 172800000 && diff < 259200000) {
			str = "2天前";
		} else if (diff >= 259200000 && diff < 345600000) {
			str = "3天前";
		} else {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			str = df.format(date);
		}
		return str;
	}

	/**
	 * 获取用户名称
	 * 
	 * @param request
	 * @return String
	 */
	public static String getSessionUserName(HttpServletRequest request) {

		String session_user_name = request.getSession().getAttribute(
				"SESSION_USER_NAME") != null ? request.getSession()
				.getAttribute("SESSION_USER_NAME").toString() : "";

		return session_user_name;
	}

	/**
	 * 获取用户类型 管理员还还是子账号
	 * 
	 * @param request
	 * @return String
	 */
	public static String getSessionUserType(HttpServletRequest request) {

		String session_user_type = request.getSession().getAttribute(
				"SESSION_USER_TYPE") != null ? request.getSession()
				.getAttribute("SESSION_USER_TYPE").toString() : "";

		return session_user_type;
	}

	/**
	 * 获取用户 权限类型
	 * 
	 * @param request
	 * @return String
	 */
	public static String getSessionRoleId(HttpServletRequest request) {

		String session_role_auth_id = request.getSession().getAttribute(
				"SESSION_ROLE_AUTH_ID") != null ? request.getSession()
				.getAttribute("SESSION_ROLE_AUTH_ID").toString() : "";

		return session_role_auth_id;
	}

	/**
	 * 判断用户是否失效
	 * 
	 * @param request
	 * @return boolean
	 */
	public static boolean isUserTimeout(HttpServletRequest request) {

		boolean flag = false;

		Object obj = request.getSession().getAttribute("SESSION_USER_ID");

		if (obj != null && obj != "") {
			flag = true;
		}
		return flag;
	}

	/**
	 * 压缩图片方法
	 * 
	 * @param oldFile
	 *            将要压缩的图片
	 * @param destFile
	 *            压缩后的图片
	 * @param shuiyinFile
	 *            水印图片
	 * @param width
	 *            不能超过的最大压缩宽
	 * @param height
	 *            不能超过的最大压缩长
	 * @param quality
	 *            压缩清晰度 <b>建议为1.0</b>
	 * @param smallIcon
	 *            压缩图片后,添加的扩展名
	 * @return
	 * @throws IOException
	 */
//	public static void imageZip(File oldFile, File destFile, int width,
//			int height) throws IOException {
//		FileOutputStream out = null;
//		float quality = 1f;
//		try {
//			// 文件不存在时
//			if (!oldFile.exists())
//				return;
//
//			/** 对服务器上的临时文件进行处理 */
//			BufferedImage bufferedImage = ImageIO.read(oldFile);
//			Image srcFile = ImageIO.read(oldFile);
//			// 为等比缩放计算输出的图片宽度及高度
//
//			// /** 宽,高设定 */
//			// BufferedImage tag = new BufferedImage(bufferedImage.getWidth(),
//			// bufferedImage.getHeight(),
//			// BufferedImage.TYPE_INT_RGB);
//
//			/** 宽,高设定 */
//			BufferedImage tag = null;
//			if (oldFile.length() / 1024 >= 8192) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 8,
//						bufferedImage.getHeight() / 8,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 8,
//						bufferedImage.getHeight() / 8, null);
//			} else if (oldFile.length() / 1024 >= 7168) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 7,
//						bufferedImage.getHeight() / 7,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 7,
//						bufferedImage.getHeight() / 7, null);
//			} else if (oldFile.length() / 1024 >= 6144) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 6,
//						bufferedImage.getHeight() / 6,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 6,
//						bufferedImage.getHeight() / 6, null);
//			} else if (oldFile.length() / 1024 >= 5120) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 5,
//						bufferedImage.getHeight() / 5,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 5,
//						bufferedImage.getHeight() / 5, null);
//			} else if (oldFile.length() / 1024 >= 4096) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 4,
//						bufferedImage.getHeight() / 4,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 4,
//						bufferedImage.getHeight() / 4, null);
//			} else if (oldFile.length() / 1024 >= 3072) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 3,
//						bufferedImage.getHeight() / 3,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 3,
//						bufferedImage.getHeight() / 3, null);
//			} else if (oldFile.length() / 1024 >= 2048) {
//
//				tag = new BufferedImage(bufferedImage.getWidth() / 2,
//						bufferedImage.getHeight() / 2,
//						BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth() / 2,
//						bufferedImage.getHeight() / 2, null);
//			} else {
//
//				tag = new BufferedImage(bufferedImage.getWidth(),
//						bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
//				tag.getGraphics().drawImage(srcFile, 0, 0,
//						bufferedImage.getWidth(), bufferedImage.getHeight(),
//						null);
//			}
//
//			out = new FileOutputStream(destFile);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//			/** 压缩质量 */
//			jep.setQuality(quality, true);
//			encoder.encode(tag, jep);
//			// /** 压缩质量 */
//			if (oldFile.length() / 1024 > 400) {
//				jep.setQuality(quality, true);
//				encoder.encode(tag, jep);
//				while (destFile.length() / 1024 > 200) {
//					System.out.println(destFile.length() / 1024);
//					System.out.println(destFile.length() / 1024 > 200);
//					out = new FileOutputStream(destFile);
//					encoder = JPEGCodec.createJPEGEncoder(out);
//					jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
//					quality = (float) (quality - 0.05);
//					/** 压缩质量 */
//					jep.setQuality(quality, true);
//					encoder.encode(tag, jep);
//				}
//			}
//			out.close();
//			srcFile.flush();
//		} finally {
//			if (out != null)
//				out.close();
//		}
//	}

	/**
	 * 上传图片
	 * 
	 * @date 2016年3月3日 上午11:25:58
	 * @param src
	 * @param dst
	 *            void
	 */
	public static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			final int BUFFER_SIZE = 16 * 1024;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字符串转换。用于sql in 语句拼接 将 1,2,3,4,5,6 转换成 '1','2','3','4','5','6'
	 * 
	 * @param str
	 *            要处理的字符串 ：eg:1,2,3,4,5,6
	 * @param character
	 *            拼接字符串
	 * @param splitStr
	 *            分割字符串
	 * @return 转换后的字符串
	 */
	public static String strSplitAddCharacter(String str, String character,
			String splitStr) {
		String[] list = str.split(splitStr);
		StringBuffer sb = new StringBuffer();
		for (String srt : list) {
			if (!"".equals(sb.toString())) {
				sb.append(splitStr);
			}
			sb.append(character).append(srt).append(character);
		}
		return sb.toString();
	}

	/**
	 * 按倍率缩小图片
	 * 
	 * @param file
	 *            读取图片路径
	 * @param imageFileCpf
	 *            写入图片路径
	 * @param widthRatio
	 *            宽度缩小比例
	 * @param heightRatio
	 *            高度缩小比例
	 * @throws IOException
	 */
//	public static void reduceImageByRatio(File file, File imageFileCpf,
//			int widthRatio, int heightRatio) throws IOException {
//		FileOutputStream out = null;
//		try {
//			// 构造Image对象
//			BufferedImage src = javax.imageio.ImageIO.read(file);
//			int width = src.getWidth();
//			int height = src.getHeight();
//			// 缩小边长
//			BufferedImage tag = new BufferedImage(width / widthRatio, height
//					/ heightRatio, BufferedImage.TYPE_INT_RGB);
//			// 绘制 缩小 后的图片
//			tag.getGraphics().drawImage(src, 0, 0, width / widthRatio,
//					height / heightRatio, null);
//			out = new FileOutputStream(imageFileCpf);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//			encoder.encode(tag);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (out != null) {
//				out.close();
//			}
//		}
//	}

	/**
	 * 读取配置文件内容
	 * 
	 * @return:String
	 * @params:@param key
	 * @params:@param name 文件名称
	 * @params:@return
	 */
	public static String readProperties(String key, String name) {
		Properties p = new Properties();
		String result = "";
		try {
			String path = PubMethod.class.getResource(name).getPath();
			// InputStream in = HttpUtils.class.getResourceAsStream(name);//
			// 这里有人用new
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			;// 这里有人用new
			p.load(in);
			in.close();
			if (p.containsKey(key)) {
				result = p.getProperty(key);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 修改配置文件
	 * 
	 * @return:String
	 * @params:@param key
	 * @params:@param name 文件名称
	 * @params:@return
	 */
	public static void updateProperties(Map<String, String> map, String name) {
		Properties p = new Properties();
		try {
			String path = PubMethod.class.getResource(name).getPath();
			// InputStream in = HttpUtils.class.getResourceAsStream(name);//
			// 这里有人用new
			InputStream in = new BufferedInputStream(new FileInputStream(path));
			;// 这里有人用new
			p.load(in);
			if (map != null && !map.isEmpty()) {
				for (Map.Entry<String, String> entry : map.entrySet()) {
					p.setProperty(entry.getKey(), entry.getValue());
				}
			}
			in.close();

			FileOutputStream fos = new FileOutputStream(path);
			// FileOutputStream fos=new FileOutputStream(name);
			p.store(fos, "update" + name);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 查询当前日期前(后)x天的日期
	 * 
	 * @param date
	 *            当前日期
	 * @param day
	 *            天数（如果day数为负数,说明是此日期前的天数）
	 * @return yyyy-MM-dd
	 */
	public static String beforNumDay(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, day);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 批量 处理手机号 去除区号和 - 去除自己的手机号
	 */
	public static String changePhone(String phones, String phone) {
		String p = "";
		try {
			String ph = phones.replaceAll("-", "").replaceAll(" ", "");
			String ps[] = ph.split(",");
			for (int i = 0; i < ps.length; i++) {
				String pp = ps[i].trim().replaceAll(" ", "")
						.replaceAll(" ", "");
				if (p.length() == 0) {
					if (pp.length() >= 11 && !pp.equals(phone)) {
						p += "'" + pp.substring(pp.length() - 11, pp.length())
								+ "'";
					}
				} else {
					if (pp.length() >= 11 && !pp.equals(phone)) {
						p += ",'" + pp.substring(pp.length() - 11, pp.length())
								+ "'";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * @param obj
	 * @return Object 转换成 int 类型
	 */
	public static int ObjTransitionInt(Object obj) {
		String str = object2Str(obj);
		if (PubMethod.isStrNotEmpty(str)) {
			return Integer.parseInt(str);
		}
		return 0;
	}

	/**
	 * @param obj
	 * @return Object 转换成 double 类型
	 */
	public static double ObjTransitionDouble(Object obj) {
		String str = object2Str(obj);
		if (PubMethod.isStrNotEmpty(str)) {
			return Double.parseDouble(str);
		}
		return 0;
	}

	/**
	 * @param obj
	 * @return Object转换成Date yyyy-MM-dd HH:mm:ss
	 */
	public static Date ObjTransitionDate(Object obj) {
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (obj == null || "".equals(obj) || " ".equals(obj))
			return null;
		Date da = new Date();
		try {
			da = fmtDate.parse(object2Str(obj));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * @param obj
	 * @return Object转换成Date yyyy-MM-dd
	 */
	public static Date ObjTransitionDate2(Object obj) {
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		if (obj == null || "".equals(obj) || " ".equals(obj))
			return null;
		Date da = new Date();
		try {
			da = fmtDate.parse(object2Str(obj));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return da;
	}

	/**
	 * 对象转换成string
	 */
	public static String object2Str(Object obj) {
		return (obj == null || "".equals(obj.toString())) ? "" : obj.toString();
	}

	/**
	 * 对象转换成string
	 */
	public static String object2Strnull(Object obj) {
		return (obj == null || "".equals(obj.toString())) ? null : obj
				.toString();
	}

	/**
	 * json转Map
	 * 
	 * @param jsonData
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> json2Map(String jsonData) {
		Gson g = new GsonBuilder().create();
		Map<String, Object> map = g.fromJson(jsonData,
				new TypeToken<Map<String, String>>() {
				}.getType());

		return map;
	}

	/**
	 * json转Map
	 * 
	 * @param jsonData
	 * @return Map<String,Object>
	 */
	public static Map<String, String> json2Maps(String jsonData) {
		Gson g = new GsonBuilder().create();
		Map<String, String> map = g.fromJson(jsonData,
				new TypeToken<Map<String, String>>() {
				}.getType());

		return map;
	}
	
	/**
	 * 生成交易网会员代码
	 * 
	 * @return String
	 */
	public static String getThirdCustId() {
		SimpleDateFormat df = new SimpleDateFormat("ddHHmmss");// 设置日期格式
		String rdNum = df.format(new Date());
		Random random = new Random();
		int ird = random.nextInt(999999);
		String srd = String.format("%06d", ird);
		String thirdCustId = rdNum + srd;
		return thirdCustId;
	}

	/**
	 * 把Date类型转换为String 格式yyyyMMdd
	 * 
	 * @param str
	 * @param format
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String Date2stringCPF(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String s = sdf.format(d);
		return s;
	}
}