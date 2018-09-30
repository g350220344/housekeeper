package com.cindata.housekeeper.core.common.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 拆分出面积
 */
public class SplitSquareUtil {


	public static String zzcf(String str){

		boolean flag = false;
		String purposeWant = null;
		 String shuzi = "";
		 String shuZiD = "1,2,3,4,5,6,7,8,9,0";
		 int resultIndex = 0;
		 String StringQian = "";
		String StringHou = "";
		int dianAfter = 0;
		int result = 0;
		boolean fk = true;
		try {
			
			//while(!flag){
				for(int w=0;w<str.length();w++){
					//while(!flag)
					int purposei = 0;
					String eachPing = str.charAt(w) + "";
					String eachPingFang = "";
					if(w<str.length()-1){
						eachPingFang =  str.charAt(w+1)+"";
					}
					String eachPingFangMi = "";
					if(w<str.length()-2){
						eachPingFangMi =  str.charAt(w+2)+"";
					}
					//String eachPingFangMi = str.charAt(w+2)+"";
					String eachPingFangResult = eachPing + eachPingFang;
					String eachPingFangMiResult = eachPingFangResult + eachPingFangMi;
					
					if(eachPing.equals("平")){
						purposei = w;
						
					}
					if(eachPingFangResult.equals("平米")){
						purposei = w;
						
					}
					if(eachPingFangMiResult.equals("平方米")){
						purposei = w;
						
					}
					if(eachPing.equals("㎡")){
						purposei = w;
						
					}
					
					purposeWant = str.substring(0, purposei);
					Pattern pattern = Pattern.compile("\\d+$");
					Matcher matcher = pattern.matcher(purposeWant);
					if(matcher.find()){
						   System.out.println("结尾的数字是："+matcher.group());
						  // shuzi = matcher.group() + "平方米";
							shuzi = matcher.group();
							if(str.contains(".")){
								dianAfter = shuzi.length();
								int z = str.indexOf(shuzi);
								String string = str.charAt(z-1) + "";
								int q = z - 2;
								if(string.equals(".")){
									String[] shuZiS = shuZiD.split(",");
									
									
									while(shuZiD.contains(str.charAt(q) + "")){
										if(q >= 0){
											resultIndex = q;
											q-=1;
											if(q==-1){
												break;
											}
											
										}
										
									}
									
									
									result = z + dianAfter;
									StringQian = str.substring(resultIndex, z);
									StringHou = str.substring(z,result);
									shuzi = StringQian + StringHou;
								}	
							}
							
							flag = true;
							break;
					  }else{
						  flag=false;
					  }
					
				}
				//}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shuzi;
	}	
	
	public static void main(String[] args){
		String str = zzcf("31.5平米");
		//345平方米
		System.out.print(str);
	}
}
