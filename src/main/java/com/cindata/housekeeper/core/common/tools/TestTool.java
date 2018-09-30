package com.cindata.housekeeper.core.common.tools;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestTool{

	
	
		// TODO Auto-generated method stub
		 public static String hzsz(String text){

			 Pattern p = Pattern.compile(numRegex);  
		     Matcher m = p.matcher(text);  
		       
		     while(m.find()) {  
		         String numZH = m.group();  
		         if(numZH.length() !=1 || numMap.containsKey(numZH) || zhTen.equals(numZH) || dian.equals(numZH)) {  
		             String numALB = NumZHToALB(numZH);  
		             text = text.replaceFirst(numZH, numALB); 

		         }
		     }  
		       
		     return text;
			       
			    }  
		
	
		 
		 
		  private static String NumZHToALB(String numZH) {  
		        double numALB = 0.0;  
		        int formIndex = 0;  
		        for(String unitNum : unitNumMap.keySet()) {  
		            int index = numZH.indexOf(unitNum);  
		            if(index != -1 ) {  
		                numALB += NumZHToALB(numZH.substring(formIndex, index),  unitNumMap.get(unitNum));  
		                formIndex = index + 1;  
		            }  
		        }  
		          
		        numALB += NumZHToALB(numZH.substring(formIndex),  1);  
		        return String.valueOf(numALB);  
		    }  
		  
		  private static String DianToALB(String numZH) {  
		        int numALB = 0;  
		        int formIndex = 0;  
		        String s = "";
		        for(String unitNum : dianMap.keySet()) {  
		            int index = numZH.indexOf(unitNum);  
		            if(index != -1 ) {  
		            	s = numZH.substring(index, numZH.length());
		            	Integer.parseInt(s);
		            }  
		        }  
		          
		        numALB += NumZHToALB(numZH.substring(formIndex),  1);  
		        return String.valueOf(numALB);  
		    }  
		      
		    private static double NumZHToALB(String numZH, int unitNum) {  
		    	 String s = "";
		    	 int indexdian = 0;
		    	 double reduleNum =0.0;
			        for(String dianNum : dianMap.keySet()) {  
			            indexdian = numZH.indexOf(dianNum);  
			            if(indexdian != -1 ) {  
			            	s = numZH.substring(0, indexdian);
			            	//Integer.parseInt(s);
			            }  
			        } 
			        if(indexdian!=-1){
		        int length = s.length();  
		        int numALB = 0;  
		        if(length != 0) {  
		            int fromIndex = 0;  
		            for(String unit : unitMap.keySet()) {  
		                int index = numZH.indexOf(unit, fromIndex);  
		                if(index != -1) {  
		                    fromIndex = index + unit.length();  
		                    String prevChar = zhOne;  
		                    if(index != 0 && numMap.containsKey(prevChar)) {  
		                        prevChar = String.valueOf(numZH.charAt(index - 1));  
		                    }   
		                    numALB += numMap.get(prevChar) * unitMap.get(unit);  
		                }  
		            }  
		              
		            
		            
		            String lastChar = String.valueOf(numZH.charAt(length - 1));  
		            if(numMap.containsKey(lastChar)) {  
		                String pChar = zhTen;  
		                if(length != 1) {  
		                    pChar = String.valueOf(numZH.charAt(length - 2));  
		                    if(zhZero.equals(pChar)) {  
		                        pChar = zhTen;  
		                    }  
		                }  
		                numALB += numMap.get(lastChar) * unitMap.get(pChar)/10;  
		            }  
		        } 
		        if(numZH.length() >= indexdian+3){
			    	   String dianStr = numZH.substring(indexdian+1, numZH.length());
				        
				       String result =  numALB * unitNum +"";
				       
				     String one = dianStr.charAt(0) + "";
				      String two = dianStr.charAt(1) + "";
				     
				      
				     String resultOne = numMap.get(one).toString();
				     String resultTwo = numMap.get(two).toString();
				      String StringresultNum =  result + "." +resultOne + resultTwo;
				      reduleNum = Double.parseDouble(StringresultNum);
			       }
		       if(numZH.length() == indexdian+2){
		    	   String dianStr = numZH.substring(indexdian+1, numZH.length());
			        
			       String result =  numALB * unitNum +"";
			     String results = numMap.get(dianStr).toString();
			      String StringresultNum =  result + "." +results;
			      reduleNum = Double.parseDouble(StringresultNum);
		       }
		       
		      
		       
		       
		       
		       
		       
		       
		       
			        }else{
			        	 int length = numZH.length();
			        	 int numALB = 0;  
					        if(length != 0) {  
					            int fromIndex = 0;  
					            for(String unit : unitMap.keySet()) {  
					                int index = numZH.indexOf(unit, fromIndex);  
					                if(index != -1) {  
					                    fromIndex = index + unit.length();  
					                    String prevChar = zhOne;  
					                    if(index != 0 && numMap.containsKey(prevChar)) {  
					                        prevChar = String.valueOf(numZH.charAt(index - 1));  
					                    }   
					                    numALB += numMap.get(prevChar) * unitMap.get(unit);  
					                }  
					            }  
					              
					            
					            
					            String lastChar = String.valueOf(numZH.charAt(length - 1));  
					            if(numMap.containsKey(lastChar)) {  
					                String pChar = zhTen;  
					                if(length != 1) {  
					                    pChar = String.valueOf(numZH.charAt(length - 2));  
					                    if(zhZero.equals(pChar)) {  
					                        pChar = zhTen;  
					                    }  
					                }  
					                numALB += numMap.get(lastChar) * unitMap.get(pChar)/10; 
					                reduleNum = (double)numALB;
					            }  
					        }  
			        }
		     //int num =  Integer.parseInt(StringresultNum);
		        return reduleNum * unitNum;  
		    }  
		      
		    private static String encodeUnicode(String gbString) {     
		        char[] utfBytes = gbString.toCharArray();     
		        String unicodeBytes = "";     
		        for (int i : utfBytes) {     
		            String hexB = Integer.toHexString(i);     
		            if (hexB.length() <= 2) {     
		                hexB = "00" + hexB;     
		            }     
		            unicodeBytes = unicodeBytes + "\\u" + hexB;     
		        }  
		        return unicodeBytes;  
		    }  
		      
		    private static final String zhZero = "零";  
		    private static final String zhOne = "一";  
		    private static final String zhTen = "十"; 
		    private static final String dian = "."; 
		      
		    private static final Map<String, Integer> numMap = new HashMap<String, Integer>();  
		    static {  
		        numMap.put("零", 0);  
		        numMap.put("一", 1);  
		        numMap.put("二", 2);  
		        numMap.put("三", 3);  
		        numMap.put("四", 4);  
		        numMap.put("五", 5);  
		        numMap.put("六", 6);  
		        numMap.put("七", 7);  
		        numMap.put("八", 8);  
		        numMap.put("九", 9); 
		    }  
		      
		    private static final Map<String, Integer> unitNumMap = new LinkedHashMap<String, Integer>();  
		    static {  
		        unitNumMap.put("亿", 100000000);  
		        unitNumMap.put("万", 10000);  
		    }  
		      
		    private static final Map<String, Integer> unitMap = new LinkedHashMap<String, Integer>();  
		    static {  
		        unitMap.put("千", 1000);  
		        unitMap.put("百", 100);  
		        unitMap.put("十", 10);  
		    }  
		    
		    private static final Map<String, String> dianMap = new LinkedHashMap<String, String>();  
		    static {  
		    dianMap.put("点", ".");		    }  
		   
		      
		    private static String numRegex;  
		    static {  
		        numRegex = "[";  
		        for(String s : numMap.keySet()) {  
		            numRegex += encodeUnicode(s);  
		        }  
		        for(String s : unitMap.keySet()) {  
		            numRegex += encodeUnicode(s);  
		        }  
		        for(String s : unitNumMap.keySet()) {  
		            numRegex += encodeUnicode(s);  
		        }  
		        for(String s : dianMap.keySet()) {  
		            numRegex += encodeUnicode(s);  
		        }  
		       
		        numRegex += "]+";  
		    } 
		  
		    public static void main(String[] args){
		    	
		    	String str = hzsz("七十三点五四一二三平米");
		    	System.out.print(str);
		    	
}
}
