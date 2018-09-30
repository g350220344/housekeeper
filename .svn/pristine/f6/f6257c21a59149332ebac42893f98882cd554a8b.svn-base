package com.cindata.housekeeper.core.common.tools;  
  
import java.io.BufferedReader;  
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;
import java.util.ArrayList;  
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVFileUtil {
	
	public void main123(String[] args) {
		try {
			CSVFileUtil bean = new CSVFileUtil("D:\\temp\\2017.01.07\\xiaoqu.csv");
			File outputfile = new File("D:\\temp\\2017.01.07\\xiaoqu2.csv");
			String line = "";
			int i = 0;
			int good = 0;
			int bad = 0;
			List<String> outPutData = new ArrayList<>();
			//小区ID,小区名称,涉及案例,ETL侧小区名称,,
			while((line = bean.readLine()) != null){
				String outLine = null;
				if(i >= 180000 || i <= 180000 ){
//					System.out.println(line);
					String[] lineArray = fromCSVLine(line, 10);
					//如果“小区”字符串出现多次就过滤掉
					if(lineArray[1].length() >= 26){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("小区") != lineArray[1].lastIndexOf("小区")){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("家属楼") >= 0){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("门市") >= 0){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("附近") >= 0){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("街") != lineArray[1].lastIndexOf("街")){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("园") != lineArray[1].lastIndexOf("园")){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("圆") > 0 && lineArray[1].lastIndexOf("园") > 0){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("家园") > 0 && lineArray[1].lastIndexOf("城") > 0){
						lineArray[4] = "无规则";
						bad++;
					}else if(lineArray[1].indexOf("花园") > 0 && lineArray[1].lastIndexOf("城") > 0){
						lineArray[4] = "无规则";
						bad++;
					}else{
						System.out.println(line);
						good ++;
					}
					outLine = toCSVLine(lineArray);
				}else{
					outLine = line;
				}
				outPutData.add(outLine);
				i ++;
			}
			CSVUtils.exportCsv(outputfile, outPutData, "GBK");
			System.out.println("good:" + good);
			System.out.println("bad:" + bad);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		try {
//			CSVFileUtil bean = new CSVFileUtil("D:\\temp\\2017.01.07\\xq2.csv");
//			File outputfile = new File("D:\\temp\\2017.01.07\\xq3.csv");
//			String line = "";
//			int i = 0;
//			int good = 0;
//			int bad = 0;
//			List<String> outPutData = new ArrayList<>();
//			//小区ID,小区名称,涉及案例,ETL侧小区名称,,
//			while((line = bean.readLine()) != null){
//				String outLine = null;
//				String[] lineArray = fromCSVLine(line, 10);
//				//如果“小区”字符串出现多次就过滤掉
//				Pattern pattern = Pattern.compile("\\d+$");
//				Matcher matcher = pattern.matcher(line);
//				if(matcher.find()){
//					bad++;
//				}else if(lineArray[0].indexOf("房") == 0){
//					bad++;
//				}else if(lineArray[0].indexOf("《") > 0 
//						|| lineArray[0].indexOf("(") > 0
//						|| lineArray[0].indexOf(")") > 0
//						|| lineArray[0].indexOf(")") > 0){
//					bad++;
//				}else if(StringUtil.parseInt(lineArray[0], 0) > 0){
//					bad++;
//				}else if(lineArray[0].indexOf("房") == lineArray[0].length() - 1){
//					bad++;
//				}else{
//					good ++;
//				}
//				System.out.println(line);
//				//outLine = toCSVLine(lineArray);
//				//outPutData.add(outLine);
//				i ++;
//			}
//			//CSVUtils.exportCsv(outputfile, outPutData, "GBK");
//			System.out.println("good:" + good);
//			System.out.println("bad:" + bad);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String line = "123太古街120";
//		Pattern pattern = Pattern.compile("\\d+$");
//		Matcher matcher = pattern.matcher(line);
		System.out.println(line.replaceAll("\\d+$",""));
	}
	
	public static boolean exportCsv(File file, List<String> dataList, String charset){
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, charset);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
	
    // CSV文件编码  
    public static final String ENCODE = "GBK";  
  
    private FileInputStream fis = null;  
    private InputStreamReader isw = null;  
    private BufferedReader br = null;  
  
     
    public CSVFileUtil(String filename) throws Exception {  
        fis = new FileInputStream(filename);  
        isw = new InputStreamReader(fis, ENCODE);  
        br = new BufferedReader(isw);  
    }  
  
    // ==========以下是公开方法=============================  
    /** 
     * 从CSV文件流中读取一个CSV行。 
     * 
     * @throws Exception 
     */  
    public String readLine() throws Exception {  
  
        StringBuffer readLine = new StringBuffer();  
        boolean bReadNext = true;  
  
        while (bReadNext) {  
            //  
            if (readLine.length() > 0) {  
                readLine.append("\r\n");  
            }  
            // 一行  
            String strReadLine = br.readLine();  
  
            // readLine is Null  
            if (strReadLine == null) {  
                return null;  
            }  
            readLine.append(strReadLine);  
  
            // 如果双引号是奇数的时候继续读取。考虑有换行的是情况。  
            if (countChar(readLine.toString(), '"', 0) % 2 == 1) {  
                bReadNext = true;  
            } else {  
                bReadNext = false;  
            }  
        }  
        return readLine.toString();  
    }  
  
    /** 
     *把CSV文件的一行转换成字符串数组。指定数组长度，不够长度的部分设置为null。 
     */  
    public static String[] fromCSVLine(String source, int size) {  
        ArrayList tmpArray = fromCSVLinetoArray(source);  
        if (size < tmpArray.size()) {  
            size = tmpArray.size();  
        }  
        String[] rtnArray = new String[size];  
        tmpArray.toArray(rtnArray);  
        return rtnArray;  
    }  
  
    /** 
     * 把CSV文件的一行转换成字符串数组。不指定数组长度。 
     */  
    public static ArrayList fromCSVLinetoArray(String source) {  
        if (source == null || source.length() == 0) {  
            return new ArrayList();  
        }  
        int currentPosition = 0;  
        int maxPosition = source.length();  
        int nextComma = 0;  
        ArrayList rtnArray = new ArrayList();  
        while (currentPosition < maxPosition) {  
            nextComma = nextComma(source, currentPosition);  
            rtnArray.add(nextToken(source, currentPosition, nextComma));  
            currentPosition = nextComma + 1;  
            if (currentPosition == maxPosition) {  
                rtnArray.add("");  
            }  
        }  
        return rtnArray;  
    }  
  
  
    /** 
     * 把字符串类型的数组转换成一个CSV行。（输出CSV文件的时候用） 
     */  
    public static String toCSVLine(String[] strArray) {  
        if (strArray == null) {  
            return "";  
        }  
        StringBuffer cvsLine = new StringBuffer();  
        for (int idx = 0; idx < strArray.length; idx++) {  
            String item = addQuote(strArray[idx]);  
            cvsLine.append(item);  
            if (strArray.length - 1 != idx) {  
                cvsLine.append(',');  
            }  
        }  
        return cvsLine.toString();  
    }  
  
    /** 
     * 字符串类型的List转换成一个CSV行。（输出CSV文件的时候用） 
     */  
    public static String toCSVLine(ArrayList strArrList) {  
        if (strArrList == null) {  
            return "";  
        }  
        String[] strArray = new String[strArrList.size()];  
        for (int idx = 0; idx < strArrList.size(); idx++) {  
            strArray[idx] = (String) strArrList.get(idx);  
        }  
        return toCSVLine(strArray);  
    }  
  
    // ==========以下是内部使用的方法=============================  
    /** 
     *计算指定文字的个数。 
     * 
     * @param str 文字列 
     * @param c 文字 
     * @param start  开始位置 
     * @return 个数 
     */  
    private int countChar(String str, char c, int start) {  
        int i = 0;  
        int index = str.indexOf(c, start);  
        return index == -1 ? i : countChar(str, c, index + 1) + 1;  
    }  
  
    /** 
     * 查询下一个逗号的位置。 
     * 
     * @param source 文字列 
     * @param st  检索开始位置 
     * @return 下一个逗号的位置。 
     */  
    private static int nextComma(String source, int st) {  
        int maxPosition = source.length();  
        boolean inquote = false;  
        while (st < maxPosition) {  
            char ch = source.charAt(st);  
            if (!inquote && ch == ',') {  
                break;  
            } else if ('"' == ch) {  
                inquote = !inquote;  
            }  
            st++;  
        }  
        return st;  
    }  
  
    /** 
     * 取得下一个字符串 
     */  
    private static String nextToken(String source, int st, int nextComma) {  
        StringBuffer strb = new StringBuffer();  
        int next = st;  
        while (next < nextComma) {  
            char ch = source.charAt(next++);  
            if (ch == '"') {  
                if ((st + 1 < next && next < nextComma) && (source.charAt(next) == '"')) {  
                    strb.append(ch);  
                    next++;  
                }  
            } else {  
                strb.append(ch);  
            }  
        }  
        return strb.toString();  
    }  
  
    /** 
     * 在字符串的外侧加双引号。如果该字符串的内部有双引号的话，把"转换成""。 
     * 
     * @param item  字符串 
     * @return 处理过的字符串 
     */  
    private static String addQuote(String item) {  
        if (item == null || item.length() == 0) {  
            return "\"\"";  
        }  
        StringBuffer sb = new StringBuffer();  
        sb.append('"');  
        for (int idx = 0; idx < item.length(); idx++) {  
            char ch = item.charAt(idx);  
            if ('"' == ch) {  
                sb.append("\"\"");  
            } else {  
                sb.append(ch);  
            }  
        }  
        sb.append('"');  
        return sb.toString();  
    }  
}  