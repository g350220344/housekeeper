package com.cindata.housekeeper.core.common.tools;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class HttpRequest {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
			// 指定编码格式
			in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
//            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, String enc) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setConnectTimeout(5000);
            conn.setReadTimeout(10000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            //out = new PrintWriter(conn.getOutputStream());
			// 获取URLConnection对象对应的输出流，设置utf-8编码
			out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), enc));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    /**
     * httpClient post请求 参数格式json
     * @param
     * @param url
     * @param
     * @return
     */
	public static String httpPostWithJson(String url,String jsonParm){
	    String result = null;
	    HttpPost post = null;
	    try {


	    	HttpClient httpClient = new DefaultHttpClient();
	        // 设置超时时间
	        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 15000);
	        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 15000);
	            
	        post = new HttpPost(url);
	        // 构造消息头
	        post.setHeader("Content-type", "application/json; charset=utf-8");
	        post.setHeader("Connection", "Close");


	        String sessionId = getSessionId();
	        post.setHeader("SessionId", sessionId);
//	        post.setHeader("appid", appid);
	                    
	        // 构建消息实体
	        StringEntity entity = new StringEntity(jsonParm, Charset.forName("UTF-8"));
	        entity.setContentEncoding("UTF-8");
	        // 发送Json格式的数据请求
	        entity.setContentType("application/json");
	        post.setEntity(entity);
	        
	        HttpResponse response = httpClient.execute(post);
	        
	        // 检验返回码
	        int statusCode = response.getStatusLine().getStatusCode();
	        if(statusCode == HttpStatus.SC_OK){
	        	int retCode = 0;
	            String sessendId = "";
	            // 返回码中包含retCode及会话Id
	            for(Header header : response.getAllHeaders()){
	                if(header.getName().equals("retcode")){
	                    retCode = Integer.parseInt(header.getValue());
	                }
	                if(header.getName().equals("SessionId")){
	                    sessendId = header.getValue();
	                }
	            }
	        }
	        result = EntityUtils.toString(response.getEntity(),"UTF-8");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        if(post != null){
	            try {
	                post.releaseConnection();
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return result;
	}
	/**
	 * 构建唯一会话Id
	 * @return
	 */
	public static String getSessionId() {
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		return str.substring(0, 8) + str.substring(9, 13)
				+ str.substring(14, 18) + str.substring(19, 23)
				+ str.substring(24);
	}
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, String enc,boolean isJsonType) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(10000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), enc));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
    	//uploadFile(new File("C:\\Users\\Administrator\\Pictures\\u13126 - 副本 (2).png"));
    	String res = sendPost("http://125.211.221.35:8081/WebServiceOther.aspx", "action=getAVMprice&CommunityName=" + StringUtil.encode("泰山小区", "UTF-8", "") + "&BuiltYear=2002&Layer=4&LayerHigh=7&ConstructionArea=120&ImmeubleID=", "UTF-8");
    	System.out.println(res);
	}
    
    
    public static String uploadFile(File file) {
		String RequestURL = "http://192.168.30.21:8090/dp/rest/upload/uploadList";
		String BOUNDARY = "------iodjoifjeoifjeofi"; // 边界标识 随机生成
		String PREFIX = "--", LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // 内容类型

		try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(500000);
			conn.setConnectTimeout(500000);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", "UTF-8"); // 设置编码
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);

			// 头
			String boundary = BOUNDARY;

			// 传输内容

			StringBuffer contentBody = new StringBuffer("--" + BOUNDARY);

			// 尾

			String endBoundary = "\r\n--" + boundary + "--\r\n";

			OutputStream outputSteam = conn.getOutputStream();

			// 1. 处理文字形式的POST请求

			contentBody.append("\r\n")

			.append("Content-Disposition: form-data; ");

			String boundaryMessage1 = contentBody.toString();

			outputSteam.write(boundaryMessage1.getBytes("utf-8"));

			/**
			 * 当文件不为空，把文件包装并且上传
			 */

			if (file != null) {
				contentBody = new StringBuffer();

				contentBody.append("\r\n");

				contentBody.append("Content-Disposition: form-data; name=\"fileupload\";");// form中field的名称

				contentBody.append("filename=\"");

				contentBody.append(file.getName() + "\"");// 上传文件的文件名，包括目录

				contentBody.append("\r\n");

				contentBody.append("Content-Type:application/octet-stream");

				contentBody.append("\r\n\r\n");

				String boundaryMessage2 = contentBody.toString();

				outputSteam.write(boundaryMessage2.getBytes("utf-8"));

				// 开始真正向服务器写文件

				DataInputStream dis = new DataInputStream(new FileInputStream(file));

				int bytes = 0;

				byte[] bufferOut = new byte[(int) file.length()];

				bytes = dis.read(bufferOut);

				outputSteam.write(bufferOut, 0, bytes);

				dis.close();

				contentBody.append(BOUNDARY);

				String boundaryMessage = contentBody.toString();

				outputSteam.write(boundaryMessage.getBytes("utf-8"));
			}

			outputSteam.write((BOUNDARY + "--\r\n").getBytes("UTF-8"));

			// 3. 写结尾

			outputSteam.write(endBoundary.getBytes("utf-8"));

			outputSteam.flush();

			outputSteam.close();

			// 4. 从服务器获得回答的内容

			String strLine = "";

			String strResponse = "";

			InputStream in = conn.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			while ((strLine = reader.readLine()) != null)

			{

				strResponse += strLine + "\n";

			}
			return strResponse;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
    
}