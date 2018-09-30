package com.cindata.housekeeper.core.common.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SplitDianUtil {

	public static String testDain(String str){
		String StringQian = "";
		String StringHou = "";
		int resultIndex = 0;
		boolean flag = str.contains("点");
		boolean f = false;
		boolean fl = false;
		int z = 0;
		int index = 0;
		String c = "";
		String resultHou = "";
		String resultQian = "";
		String result = "";
		try {
		String shuZi = "一,二,三,四,五,六,七,八,九,十,零,百,千,万";
		String[] shuZiS = shuZi.split(",");
		if(flag){
			
			for(int j=0;j<str.length();j++){
				
				String s = str.charAt(j) + "";
				if("点".equals(s)){
					// index = str.indexOf("点");
					 for(int i =0;i<shuZiS.length;i++){
							
								c = str.charAt(j - 1) + "";
								if(shuZiS[i].equals(c)){
									f = true;
									z = j;
									break;
								}
					 }
				}else{
					continue;
				}
				
				
			}
		}						if(f){
										//int zLength = str.split("点")[0].length();
										for(int q=z-1;q>=0;q--){
											
											String ds = str.charAt(q) + "";
											if(!shuZi.contains(ds)){
												resultIndex = q;
												break;
											}
											/*for(int w=0;w<shuZiS.length;w++){
												if(ds.equals(shuZiS[w])){
													resultIndex = q;
													
													break;
												}else{
													continue;
												}
											}*/
											//while(shuZiS[j].equals(str.charAt(q))){
												// resultIndex = q;
												
											//}
										}
		
										
										StringQian = str.substring(0, resultIndex + 1);
										StringHou = str.substring(resultIndex + 1,str.length());
										fl = false;
										
										 resultHou =  TestTool.hzsz(StringHou);
										 resultQian = NumAndChineseUtil.hzsz(StringQian);
									     result = resultQian + resultHou;
									}
		                      if(!f){
		                    	  result = NumAndChineseUtil.hzsz(str); 
		                      }
			
			  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static void main(String[] args){
		String str = testDain("南岗区华山小区二十栋1单元701室七十三点五四一二三平米");
		String zhuanHuan = TestTool.hzsz(str);
		String result = SplitSquareUtil.zzcf(zhuanHuan);
		System.out.print(result);
	}
}
