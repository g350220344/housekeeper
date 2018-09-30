package com.cindata.housekeeper.core.common.tools;


import com.gxd.mygistool.coordinate.TransTool;

public class GisToolsUtil {
 public static String BDtoMCT(double x, double y) {
  String point=null;
  String xy = TransTool.BdToMct(x, y);
  if (!xy.equalsIgnoreCase("")) {
   point = "'point(" + xy.split(",")[0] + " " + xy.split(",")[1] + ")'";
  }
  return xy;
 }
 public static void main(String[] args) {
  System.out.println(BDtoMCT(126.604099d,45.773486d));
 }
}