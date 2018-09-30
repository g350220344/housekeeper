package com.cindata.housekeeper.core.common.tools;

import java.util.HashMap;
import java.util.Map;

public class PubDictValue {

	private static Map<String, String> roomTypeCodeName;
	private static Map<String, String> roomTypeNameCode;
	private static Map<String, Integer> roomTypeNameCount;
	private static Map<String, Integer> roomTypeCodeCount;

	private static Map<String, String> aspectCodeName;
	private static Map<String, String> aspectNameCode;
	private static Map<String, Double> aspectCodeValue;
	private static Map<String, Double> aspectNameValue;

	private static Map<String, String> purposeNameCode;
	private static Map<String, String> purposeCodeName;
	private static Map<String, String> areaTypeCodeName;
	private static Map<String, String> featureTypeCodeName;

	/**
	 * -0.04000东 -0.02000南 -0.05000西 -0.06000北 -0.03500东北 -0.01000东南 -0.04000西北
	 * -0.01500西南 0.00000南北 -0.02500东西 -0.03000 其他 15753692 东 15753693 南
	 * 15753694 西 15753695 北 15753696 东北 15753697 东南 15753698 西北 15753699 西南
	 * 15753700 南北 15753701 东西 15753702 其他
	 * 
	 * 
	 * 其他 15753703 开间 15753704 一室一厅 15753705 两室一厅 15753706 三室一厅 15753707 两室两厅
	 * 15753708 三室两厅 15753709 四室以上 15753710 其他
	 */
	private static void createMap() {
		if (featureTypeCodeName == null) {//特征类别0单价1总价2面积
			featureTypeCodeName = new HashMap<>();
			featureTypeCodeName.put("0", "sqmprice");
			featureTypeCodeName.put("1", "tatprice");
			featureTypeCodeName.put("2", "square");
		}
		if (areaTypeCodeName == null) {//0城市1行政区2小区3位置周边
			areaTypeCodeName = new HashMap<>();
			areaTypeCodeName.put("0", "city");
			areaTypeCodeName.put("1", "dis");
			areaTypeCodeName.put("2", "comm");
			areaTypeCodeName.put("3", "comm");
		}
		if (purposeNameCode == null) {
			purposeNameCode = new HashMap<>();
			purposeNameCode.put("住宅", "15753722");
			purposeNameCode.put("商铺", "15755275");
			purposeNameCode.put("写字楼", "15755276");

		}
		if (purposeCodeName == null) {
			purposeCodeName = new HashMap<>();
			purposeCodeName.put("15753722", "住宅");
			purposeCodeName.put("15755275", "商铺");
			purposeCodeName.put("15755276", "写字楼");
		}
		if (aspectCodeName == null) {
			aspectCodeName = new HashMap<>();
			aspectCodeName.put("15753692", "东");
			aspectCodeName.put("15753693", "南");
			aspectCodeName.put("15753694", "西");
			aspectCodeName.put("15753695", "北");
			aspectCodeName.put("15753696", "东北");
			aspectCodeName.put("15753697", "东南");
			aspectCodeName.put("15753698", "西北");
			aspectCodeName.put("15753699", "西南");
			aspectCodeName.put("15753700", "南北");
			aspectCodeName.put("15753701", "东西");
			aspectCodeName.put("15753702", "其他");
		}

		if (aspectNameCode == null) {
			aspectNameCode = new HashMap<>();
			aspectNameCode.put("东", "15753692");
			aspectNameCode.put("南", "15753693");
			aspectNameCode.put("西", "15753694");
			aspectNameCode.put("北", "15753695");
			aspectNameCode.put("东北", "15753696");
			aspectNameCode.put("东南", "15753697");
			aspectNameCode.put("西北", "15753698");
			aspectNameCode.put("西南", "15753699");
			aspectNameCode.put("南北", "15753700");
			aspectNameCode.put("东西", "15753701");
			aspectNameCode.put("其他", "15753702");
		}

		if (aspectNameValue == null) {
			aspectNameValue = new HashMap<>();
			aspectNameValue.put("东", -0.04000);
			aspectNameValue.put("南", -0.02000);
			aspectNameValue.put("西", -0.05000);
			aspectNameValue.put("北", -0.06000);
			aspectNameValue.put("东北", -0.03500);
			aspectNameValue.put("东南", -0.01000);
			aspectNameValue.put("西北", -0.04000);
			aspectNameValue.put("西南", -0.01500);
			aspectNameValue.put("南北", 0.00000);
			aspectNameValue.put("东西", -0.02500);
			aspectNameValue.put("其他", -0.03000);
		}

		if (aspectCodeValue == null) {
			aspectCodeValue = new HashMap<>();
			aspectCodeValue.put("15753692", -0.04000);
			aspectCodeValue.put("15753693", -0.02000);
			aspectCodeValue.put("15753694", -0.05000);
			aspectCodeValue.put("15753695", -0.06000);
			aspectCodeValue.put("15753696", -0.03500);
			aspectCodeValue.put("15753697", -0.01000);
			aspectCodeValue.put("15753698", -0.04000);
			aspectCodeValue.put("15753699", -0.01500);
			aspectCodeValue.put("15753700", 0.00000);
			aspectCodeValue.put("15753701", -0.02500);
			aspectCodeValue.put("15753702", -0.03000);
		}

		if (roomTypeCodeName == null) {
			roomTypeCodeName = new HashMap<>();
			roomTypeCodeName.put("15753703", "开间");
			roomTypeCodeName.put("15753704", "一室一厅");
			roomTypeCodeName.put("15753705", "两室一厅");
			roomTypeCodeName.put("15753706", "三室一厅");
			roomTypeCodeName.put("15753707", "两室两厅");
			roomTypeCodeName.put("15753708", "三室两厅");
			roomTypeCodeName.put("15753709", "四室以上");
			roomTypeCodeName.put("15753710", "其他");
		}

		if (roomTypeNameCode == null) {
			roomTypeNameCode = new HashMap<>();
			roomTypeNameCode.put("开间", "15753703");
			roomTypeNameCode.put("一室一厅", "15753704");
			roomTypeNameCode.put("两室一厅", "15753705");
			roomTypeNameCode.put("三室一厅", "15753706");
			roomTypeNameCode.put("两室两厅", "15753707");
			roomTypeNameCode.put("三室两厅", "15753708");
			roomTypeNameCode.put("四室以上", "15753709");
			roomTypeNameCode.put("其他", "15753710");
		}

		if (roomTypeNameCount == null) {
			roomTypeNameCount = new HashMap<>();
			roomTypeNameCount.put("开间", 1);
			roomTypeNameCount.put("一室一厅", 1);
			roomTypeNameCount.put("两室一厅", 2);
			roomTypeNameCount.put("三室一厅", 3);
			roomTypeNameCount.put("两室两厅", 2);
			roomTypeNameCount.put("三室两厅", 3);
			roomTypeNameCount.put("四室以上", 4);
			roomTypeNameCount.put("其他", 0);
		}

		if (roomTypeCodeCount == null) {
			roomTypeCodeCount = new HashMap<>();
			roomTypeCodeCount.put("15753703", 1);
			roomTypeCodeCount.put("15753704", 1);
			roomTypeCodeCount.put("15753705", 2);
			roomTypeCodeCount.put("15753706", 3);
			roomTypeCodeCount.put("15753707", 2);
			roomTypeCodeCount.put("15753708", 3);
			roomTypeCodeCount.put("15753709", 4);
			roomTypeCodeCount.put("15753710", 0);
		}
	}

	public static Integer getRoomCountByName(String name) {
		createMap();
		return roomTypeNameCount.get(name);
	}

	public static Integer getRoomCountByCode(String code) {
		createMap();
		return roomTypeCodeCount.get(code);
	}

	public static String getRoomTypeNameByCode(String code) {
		createMap();
		return roomTypeCodeName.get(code);
	}
	public static String getRoomTypeNameByCode(String code, String def) {
		createMap();
		String res = roomTypeCodeName.get(code);
		if(res == null || res.length() == 0){
			res = def;
		}
		return res;
	}
	
	public static String getRoomTypeCodeByName(String name) {
		createMap();
		return roomTypeNameCode.get(name);
	}

	public static Double getAspectValueByName(String name) {
		createMap();
		return aspectNameValue.get(name);
	}

	public static Double getAspectValueByCode(String code) {
		createMap();
		return aspectCodeValue.get(code);
	}
	
	public static String getAspectNameByCode(String code) {
		createMap();
		return aspectCodeName.get(code);
	}
	
	public static String getAspectNameByCode(String code, String def) {
		createMap();
		String ret = aspectCodeName.get(code);
		if(ret == null){
			ret = def;
		}
		return ret;
	}
	
	public static String getAspectCodeByName(String name) {
		createMap();
		return aspectNameCode.get(name);
	}

	public static String getPurposeNameByCode(String code) {
		createMap();
		return purposeCodeName.get(code);
	}

	public static String getPurposeCodeByName(String name) {
		createMap();
		return purposeNameCode.get(name);
	}
	
	public static String getAreaTypeNameByCode(String code){
		createMap();
		return areaTypeCodeName.get(code);
	}
	
	public static String getFeatureTypeNameByCode(String code){
		createMap();
		return featureTypeCodeName.get(code);
	}

}
