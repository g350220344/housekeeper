package com.cindata.housekeeper.core.common.tools;

import com.cindata.housekeeper.core.entity.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.sql.CLOB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共工具类
 * 
 * @author yss
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CommonHelper {
	
	public static String getGsonObject(Object o) {
/*		Gson jo = new Gson();
		String ret = jo.toJson(o);
		return StringUtil.toString(ret, null);*/
		Gson jo = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd").create();
		String ret = jo.toJson(o);
		return StringUtil.toString(ret, null);
	}

	public static String clobToString(CLOB clob) throws SQLException, IOException {
		String reString = null;
		if(clob != null){
			Reader is = clob.getCharacterStream();// 得到流
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
				sb.append(s);
				s = br.readLine();
			}
			if(sb != null && sb.length() > 0){
				reString = sb.toString();
			}
		}
		return reString;
	}

	public static void main(String[] args) {

		// 45.76233423 126.60247188
		double[] xyRange = LatLonUtil.GetAround(45.76233423, 126.60247188, 1000);
		System.out.println(1);
		// System.out.println(addUpDown(-123.3));
		// System.out.println(getRisePercent(9876, 6789));
		// List a = (List) null;
		// System.out.println(a);
		// System.out.println(subAbs(123.3123, 124.543, null));
		// String source =
		// "[[[1.3569715278553823E7,5596223.62460029],[1.4269278287586961E7,6185064.430764874],[1.4636674688014438E7,5515698.386150433],[1.4083063673671667E7,4831233.859326642],[1.3569715278553823E7,5596223.62460029]]]";
		// String points = null;
		// org.json.JSONArray ja = new org.json.JSONArray(source);
		// StringBuilder pointArray = new StringBuilder();
		// if(ja != null && ja.length() > 0){
		// org.json.JSONArray ja0 = ja.getJSONArray(0);
		// if(ja0 != null && ja0.length() > 0){
		// int ja0l = ja0.length();
		// for (int i = 0 ; i < ja0l ; i ++) {
		// org.json.JSONArray point = ja0.getJSONArray(i);
		// if(point != null && point.length() >= 2){
		// BigDecimal x = StringUtil.parseBigDecimal(point.get(0), null);
		// BigDecimal y = StringUtil.parseBigDecimal(point.get(1), null);
		// if(StringUtil.isNotNullOrEmpty(x) && StringUtil.isNotNullOrEmpty(y)){
		// //3 3, 4 6, 5 3, 3 3
		// pointArray.append(",").append(x).append(" ").append(y);
		// }
		// }
		// }
		// }
		// }
		// if(pointArray != null && pointArray.length() > 0){
		// pointArray.deleteCharAt(0);
		// points = pointArray.toString();
		// }
		// System.out.println(points);

	}

	public static Long subAbs(Long a, Long b, Long def) {
		Long ret = def;
		if (a != null && b != null) {
			ret = Math.abs(a - b);
		}
		return ret;
	}

	public static Long subAbs(Integer a, Integer b, Long def) {
		Long ret = def;
		if (a != null && b != null) {
			ret = (long) Math.abs(a - b);
		}
		return ret;
	}

	public static Double subAbs(Double a, Double b, Double def) {
		Double ret = def;
		if (a != null && b != null) {
			ret = Math.abs(a - b);
		}
		return ret;
	}

	private static List<String> getCateList(int psize) {
		Timestamp now = new Timestamp(System.currentTimeMillis());
		List<String> ret = new ArrayList<>();
		int i = psize;
		while (i > 0) {
			ret.add(StringUtil.dateFormat(StringUtil.getDateAgo(now, 0, i, 0), "yy/MM", ""));
			i--;
		}
		return ret;
	}

	public static String[] getFeatureLine3Json(String order_type, int psize, List<Map> result, String nameColumnName, String[] heads) {
		String[] ret = new String[4];
		String priceColumName = "AVG_PRICE";
		if ("rent".equals(order_type)) {
			priceColumName = "AVG_PRICE_R";
		}
		List<String> cateList = getCateList(psize);
		StringBuilder cateSb = new StringBuilder("[");
		StringBuilder data0 = new StringBuilder("[");
		StringBuilder data1 = new StringBuilder("[");
		StringBuilder data2 = new StringBuilder("[");
		StringBuilder dataAll = new StringBuilder();
		String name0 = "";
		String name1 = "";
		String name2 = "";
		if (heads != null && heads.length >= 3) {
			name0 = heads[0];
			name1 = heads[1];
			name2 = heads[2];
		}
		int max = 0;
		int min = 0;
		Map<String, String> dataMap = new HashMap<>();
		if (result != null && result.size() > 0) {
			for (Map item : result) {
				String cate = StringUtil.toString(item.get("CDATE"), "");
				cate = StringUtil.dateFormat(Date.valueOf(cate + "-01"), "yy/MM", cate);
				String name = StringUtil.toString(item.get(nameColumnName), "");
				String data = StringUtil.toString(item.get(priceColumName), "0");
				dataMap.put(name + cate, data);
			}

			String val0 = "0", val1 = "0", val2 = "0", cs;
			// String val00 = "0", val11 = "0", val22 = "0";
			for (int i = 0; i < psize; i++) {
				cs = cateList.get(i);
				val0 = StringUtil.toString(dataMap.get(name0 + cs), "null");
				val1 = StringUtil.toString(dataMap.get(name1 + cs), "null");
				val2 = StringUtil.toString(dataMap.get(name2 + cs), "null");
				// if(!"0".equals(val0) || !"0".equals(val1) ||
				// !"0".equals(val2)){
				cateSb.append("'").append(cs).append("',");
				// val0 = StringUtil.getNumNot0(val0, val00, val1, val2);
				// val1 = StringUtil.getNumNot0(val1, val11, val0, val2);
				// val2 = StringUtil.getNumNot0(val2, val22, val0, val1);
				// val0 = StringUtil.toIntString(val0, "null");
				// val1 = StringUtil.toIntString(val1, "null");
				// val2 = StringUtil.toIntString(val2, "null");
				data0.append(val0).append(",");
				data1.append(val1).append(",");
				data2.append(val2).append(",");
				// val00 = val0;
				// val11 = val1;
				// val22 = val2;
				max = CommonHelper.getMax(max, val0, val1, val2);
				min = CommonHelper.getMin(min, val0, val1, val2);

				// }
			}

		}
		data0.deleteCharAt(data0.length() - 1).append("]");
		data1.deleteCharAt(data1.length() - 1).append("]");
		data2.deleteCharAt(data2.length() - 1).append("]");
		cateSb.deleteCharAt(cateSb.length() - 1).append("]");

		dataAll.append("[").append("{").append("name: '").append(name2).append("',").append("data: ").append(data2).append("}").append(",")
				.append("{").append("name: '").append(name1).append("',").append("data: ").append(data1).append("}").append(",")
				.append("{").append("name: '").append(name0).append("',").append("data: ").append(data0).append("}").append("]");
		ret[0] = dataAll.toString();
		ret[1] = cateSb.toString();
		ret[2] = max + "";
		ret[3] = min + "";
		return ret;
	}

	public static Double getMax(Double max, Double... item) {
		if (item != null && item.length > 0) {
			for (Double d : item) {
				if (d > 0) {
					if (d > max) {
						max = d;
					}
				}
			}
		}
		return max;
	}

	public static int getMax(int max, String... item) {
		if (item != null && item.length > 0) {
			for (String d : item) {
				int dint = StringUtil.parseInt(d, -999);
				if (dint > 0) {
					if (dint > max) {
						max = dint;
					}
				}

			}
		}
		return max;
	}

	public static Double getMin(Double min, Double... item) {
		if (item != null && item.length > 0) {
			for (Double d : item) {
				if (d > 0) {
					if (d < min || min <= 0) {
						min = d;
					}
				}
			}
		}
		return min;
	}

	public static int getMin(int min, String... item) {
		if (item != null && item.length > 0) {
			for (String d : item) {
				int dint = StringUtil.parseInt(d, -999);
				if (dint > 0) {
					if (dint < min || min <= 0) {
						min = dint;
					}
				}
			}
		}
		return min;
	}

	/**
	 * 重做了Map的get方法，将map对象是否为空的判断从主代码块中抽离。
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static Object listGet(List list, int index) {
		Object ret = null;
		if (list != null && list.size() > index) {
			ret = list.get(index);
		}
		return ret;
	}

	/**
	 * 重做了Map的get方法，将map对象是否为空的判断从主代码块中抽离。
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static Object mapGet(Map map, Object key) {
		Object ret = null;
		if (map != null) {
			ret = map.get(key);
		}
		return ret;
	}

	public static int indexOfArray(List<Integer[]> list, Integer[] item) {
		int ret = -1;
		if (list != null && !list.isEmpty() && item != null && item.length > 0) {
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Integer[] listi = list.get(i);
				if (listi != null && listi.length > 0 && listi.length == item.length) {
					int j = 0;
					int c = 0;
					while (j < listi.length) {
						if (!listi[j].equals(item[j])) {
							c = 1;
						}
						if (c > 0) {
							break;
						}
						j++;
					}
					if (c == 0) {
						ret = i;
					}
				}
			}
		}
		return ret;
	}

	public static boolean isMobileNO(String mobiles) {

		Pattern p = Pattern.compile("^((1[0-9][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);

		return m.matches();

	}

	/**
	 * 根据小区周边配套数量，获取小区周边便利度评分 配套措施 数量 得分 1-3 不太便利 1-5 1 3-5 普通 5-10 2 5-7 较便利
	 * 10-15 3 8以上 非常便利 15-20 4 20-25 5 25-30 6 30-35 7 35-40 8 40-45 9 45- 10
	 */
	public static int getCommunityScoreByMatingCount(Integer cnt) {
		int ret = 0;
		if (cnt == 0) {
			ret = 0;
		} else if (1 <= cnt && cnt < 5) {
			ret = 1;
		} else if (5 <= cnt && cnt < 10) {
			ret = 2;
		} else if (10 <= cnt && cnt < 15) {
			ret = 3;
		} else if (15 <= cnt && cnt < 20) {
			ret = 4;
		} else if (20 <= cnt && cnt < 25) {
			ret = 5;
		} else if (25 <= cnt && cnt < 30) {
			ret = 6;
		} else if (30 <= cnt && cnt < 35) {
			ret = 7;
		} else if (35 <= cnt && cnt < 40) {
			ret = 8;
		} else if (40 <= cnt && cnt < 45) {
			ret = 9;
		} else if (45 <= cnt) {
			ret = 10;
		}
		return ret;
	}

	/**
	 * 根据周边交通线路数量，获取小区交通便利评分 交通条件 数量 得分 1-3 不太便利 1 1 3-5 普通 2 2 5-7 较便利 3 3 8以上
	 * 非常便利 4 4 5 5 5-10 6 10-15 7 15-20 8 20-25 9 25- 10
	 */
	public static int getCommunityScoreByBusLineCount(Integer cnt) {
		int ret = 0;
		if (cnt == 0) {
			ret = 0;
		} else if (1 == cnt) {
			ret = 1;
		} else if (2 == cnt) {
			ret = 2;
		} else if (3 == cnt) {
			ret = 3;
		} else if (4 == cnt) {
			ret = 4;
		} else if (5 == cnt) {
			ret = 5;
		} else if (5 < cnt && cnt < 10) {
			ret = 6;
		} else if (10 <= cnt && cnt < 15) {
			ret = 7;
		} else if (15 <= cnt && cnt < 20) {
			ret = 8;
		} else if (20 <= cnt && cnt < 25) {
			ret = 9;
		} else if (25 <= cnt) {
			ret = 10;
		}
		return ret;
	}


	public static void setMM(Map param) {
		if (!param.containsKey("mm")) {
			// param.put("mm", "new");
			param.put("mm",
					StringUtil.dateFormat(StringUtil.getDateAgo(new Timestamp(System.currentTimeMillis()), 0, 1, 0), "yyyy-MM", null));
		}/*
		 * else if("all".equals(param.get("mm"))){ param.remove("mm"); }
		 */
		if (!param.containsKey("purpose")) {
			param.put("purpose", "住宅");
		}
		param.remove("start_time");
		param.remove("end_time");
		param.remove("start_day");
		param.remove("end_day");

	}

	public static void setCommunityIdList(Map param) {
		// 这里需要添加小区列表参数
		String community_ids_str = StringUtil.toString(param.get("community_ids"), null);
		String community_names_str = StringUtil.toString(param.get("community_names"), null);
		if (StringUtil.isNotNullOrEmpty(community_ids_str)) {
			String[] community_ids = community_ids_str.split("\\|");
			param.put("community_ids_array", community_ids);
		} else if (StringUtil.isNotNullOrEmpty(community_names_str)) {
			String[] community_names = community_names_str.split("\\|");
			param.put("community_names_array", community_names);
		}
	}

	public static void setTime(Map param) {
		// long def_start = System.currentTimeMillis() - 2592000000l;
		// long def_start = System.currentTimeMillis() - 32832000000l;
		// Timestamp lastMM = StringUtil.getTimestamp(StringUtil.getLastMM() +
		// "-01 00:00:00");
		// Timestamp time2 = CommonHelper.getMonthFristDay(lastMM, 1,
		// 1);//上个月的1号0点，被查询月份
		// Timestamp time1 = CommonHelper.getMonthFristDay(lastMM, -11,
		// 1);//当前月的1号0点，最近一个月 -11
		param.put("start_time", StringUtil.getTimestamp(param.get("start_time"), null));
		param.put("end_time", StringUtil.getTimestamp(param.get("end_time"), null));
		param.put("start_day", StringUtil.getDate(param.get("start_day"), null));
		param.put("end_day", StringUtil.getDate(param.get("end_day"), null));

	}

	public static void setTime(Map param, boolean isPutDef) {
		Timestamp lastMM = StringUtil.getTimestamp(StringUtil.getLastMM() + "-01 00:00:00");
		Timestamp time2 = null;// 上个月的1号0点，被查询月份
		Timestamp time1 = null;// 当前月的1号0点，最近一个月 -11
		Date date2 = null;// 上个月的1号0点，被查询月份
		Date date1 = null;// 当前月的1号0点，最近一个月 -11
		if (isPutDef) {
			time2 = CommonHelper.getMonthFristDay(lastMM, 1, 1);// 上个月的1号0点，被查询月份
			time1 = CommonHelper.getMonthFristDay(lastMM, -35, 1);// 当前月的1号0点，最近一个月
																	// -11
			date2 = new Date(time2.getTime());
			date1 = new Date(time1.getTime());
		}
		param.put("start_time", StringUtil.getTimestamp(param.get("start_time"), time1));
		param.put("end_time", StringUtil.getTimestamp(param.get("end_time"), time2));
		param.put("start_day", StringUtil.getDate(param.get("start_day"), date1));
		param.put("end_day", StringUtil.getDate(param.get("end_day"), date2));
	}

	/**
	 * 把参数中的字典名称转成码
	 */
	public static void updateNameToCode(Map param) {
		if (param == null) {
			return;
		}
		// 户型
		String floorPlanType = StringUtil.toString(param.get("floorPlanType"), null);
		if (StringUtil.isNotNullOrEmpty(floorPlanType)) {
			param.put("floorPlanType", PubDictValue.getRoomTypeNameByCode(floorPlanType));
		}
		// 用途
		String purpose = StringUtil.toString(param.get("purpose"), null);
		if (!StringUtil.isNotNullOrEmpty(purpose)) {
			purpose = StringUtil.toString(param.get("communitytype"), null);
		}
		if (StringUtil.isNotNullOrEmpty(purpose)) {
			String val = PubDictValue.getPurposeCodeByName(purpose);
			if (param.containsKey("purpose")) {
				param.put("purpose", val);
			}
			if (param.containsKey("communitytype")) {
				param.put("communitytype", val);
			}
		}

	}

	public static String getJsonObject(Object o) {
		JSONObject jo = JSONObject.fromObject(o);
		return jo != null ? jo.toString() : null;
	}

	public static String getJsonArray(Collection o) {
		JSONArray jo = JSONArray.fromObject(o);
		return jo != null ? jo.toString() : null;
	}

	public static void setResponseHeader(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

	public static Map<String, Object> setParam(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues.length >= 1) {
				String paramValue = paramValues[0];
				if (paramValue != null) {
					if ("community_id".equals(paramName) || "communityId".equals(paramName) || "city_id".equals(paramName)
							|| "cityId".equals(paramName) || "district_id".equals(paramName) || "districtId".equals(paramName)) {
						paramValue = StringUtil.toString(StringUtil.parseLong(paramValue, null), null);
						map.put(paramName, paramValue);
					} else {
						paramValue = paramValue.trim();
						if (paramValue.length() > 0) {
							if ("null".equals(paramValue)) {
								paramValue = null;
							}
							map.put(paramName, paramValue);
						}
					}
				}
			}
		}
		// map.put("mm", "2017-03");//TODO:测试用，上生产之前一定要注释掉！！！！！！！！！
		map.put("result", 1);
		map.put("msg", "操作成功");
		// map.put("city_id", StringUtil.toString(map.get("city_id"), "2301"));
		return map;
	}

	/**
	 * 构建分页参数
	 * 
	 * @param map
	 *            查询参数bean
	 * @param def_p
	 *            默认页码
	 * @param def_psize
	 *            默认每页条数
	 */
	public static void setPage(Map<String, Object> map, Integer def_p, Integer def_psize) {
		Integer p = StringUtil.parseInt(map.get("p"), def_p);
		Integer psize = StringUtil.parseInt(map.get("psize"), def_psize);

		Integer start_no = psize * (p - 1) + 1;
		Integer end_no = psize * p;
		map.put("start_no", start_no);
		map.put("end_no", end_no);
	}
	/**
	 * 构建分页参数
	 *
	 * @param map
	 *            查询参数bean
	 * @param def_p
	 *            默认页码
	 * @param def_psize
	 *            默认每页条数
	 */
	public static void setPage(Parameter param, Integer def_p, Integer def_psize) {
		Integer p = StringUtil.parseInt(param.getPage(), def_p);
		Integer psize = StringUtil.parseInt(param.getRows(), def_psize);

		Integer start_no = psize * (p - 1) + 1;
		Integer end_no = psize * p;
		param.setStart_no(start_no);
		param.setEnd_no(end_no);
	}
	/**
	 * 构建分页参数
	 * 
	 * @param map
	 *            查询参数bean
	 * @param def_p
	 *            默认页码
	 * @param def_psize
	 *            默认每页条数
	 * @throws ParseException
	 */
	public static void setPageByDays(Map<String, Object> map, Integer def_p, Integer def_psize) {
		setDay(map);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date start_day = df.parse(map.get("start_day").toString());
			java.util.Date end_day = df.parse(map.get("end_day").toString());
			Integer p = 1;
			Integer psize = (int) Math.abs((Math.floor(end_day.getTime() / 1000 / 86400) - Math.floor(start_day.getTime() / 1000 / 86400))) + 1;
			Integer start_no = psize * (p - 1) + 1;
			Integer end_no = psize * p;
			map.put("start_no", start_no);
			map.put("end_no", end_no);
			map.put("psize", psize);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 构建day_ago参数
	 * 
	 * @param map
	 *            查询参数bean
	 * @param def
	 *            默认值
	 */
	public static void setDayAgo(Map<String, Object> map, Integer def) {
		Integer dayAgo = StringUtil.parseInt(map.get("day_ago"), null);
		if (dayAgo == null || dayAgo <= 0) {
			map.put("day_ago", def);
		}
	}

	/**
	 * 构建begin and end day 参数
	 * 
	 * @param map
	 *            查询参数bean
	 * @param def
	 *            默认值
	 */
	public static void setDay(Map<String, Object> map) {
		if (map.get("mm") == null) {
			String start_day = StringUtil.toString(StringUtil.getFirsDay(map.get("start_day") + ""), StringUtil.getLastMM());
			String end_day = StringUtil.toString(StringUtil.getEndDay(map.get("end_day") + ""), StringUtil.getLastMM());
			map.put("start_day", start_day);
			map.put("end_day", end_day);
		} else {
			map.remove("start_day");
			map.remove("end_day");
		}

	}

	/**
	 * 构建中心点范围搜索
	 * 
	 * @param map
	 *            查询参数bean
	 * @param range
	 *            搜索范围(单位：米)
	 */
	public static boolean setXy(Map<String, Object> map, Integer range) {
		final BigDecimal lng = StringUtil.parseBigDecimal(map.get("lng"), null);
		final BigDecimal lat = StringUtil.parseBigDecimal(map.get("lat"), null);
		Integer range_ = StringUtil.parseInt(map.get("range"), range);
		if (lng != null && lat != null) {
			double[] xyRange = LatLonUtil.GetAround(lat.doubleValue(), lng.doubleValue(), range_);
			map.put("min_lat", xyRange[0]);
			map.put("min_lng", xyRange[1]);
			map.put("max_lat", xyRange[2]);
			map.put("max_lng", xyRange[3]);
			return true;
		}
		return false;
	}
	/**
	 * 构建中心点范围搜索
	 * 
	 * @param map
	 *            查询参数bean
	 * @param def_p
	 *            默认页码
	 * @param def_psize
	 *            默认每页条数
	 */
	public static boolean setXy(Map<String, Object> map) {
		final BigDecimal lng = StringUtil.parseBigDecimal(map.get("lng"), null);
		final BigDecimal lat = StringUtil.parseBigDecimal(map.get("lat"), null);
		Integer range_ = StringUtil.parseInt(map.get("range"), 1000);
		if (lng != null && lat != null) {
			double[] xyRange = LatLonUtil.GetAround(lat.doubleValue(), lng.doubleValue(), range_);
			map.put("min_lat", xyRange[0]);
			map.put("min_lng", xyRange[1]);
			map.put("max_lat", xyRange[2]);
			map.put("max_lng", xyRange[3]);
			return true;
		}
		return false;
	}

	public static String getPercent(int z, int m) {
		if (m == 0) {
			return "0.0";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format(Math.abs((float) z / (float) m * 100));
		return result;
	}

	public static String getPercent(double z, double m) {
		if (m == 0) {
			return "0.0";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMaximumFractionDigits(2);
		String result = numberFormat.format(Math.abs((float) z / (float) m * 100));
		return result;
	}

	public static List<Integer[]> getAandBRange(Integer min, Integer max, Integer size, Integer length) {
		// int re = (max - min)/size;
		// re = re == 0 ? 1 : re;
		// int count = (re%length == 0 ? re/length : re/length + 1) * length;
		int count = length;
		int start = min / length * length;
		List<Integer[]> ret = new ArrayList<>();
		if (min < max && count > 0) {
			for (; start < max; start = start + count) {
				ret.add(new Integer[] { start, start + count });
			}
		}
		// Collections.reverse(ret);
		return ret;
	}

	public static Integer cut(Integer source, Integer len) {
		Integer ret = (source / len + 1) * len;
		// if(ret < 500){
		// ret = 500;
		// }else {
		// for(int i = 500; true; i = i + 100) {
		// if(ret > i && ret < (i + 100)){
		// ret = i + 100;
		// break;
		// }
		// }
		// }
		return ret;
	}

	/**
	 * 获取当月的第一天
	 * 
	 * @return
	 */
	public static Timestamp getLastMonthEndDay() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		// cal.add(Calendar.DAY_OF_MONTH, -1);
		String date = StringUtil.dateFormat(cal.getTime(), "yyyy-MM-dd", "");
		return Timestamp.valueOf(date + " 00:00:00");
	}

	/**
	 * 获取某个月的第一天
	 * 
	 * @param months
	 *            月份，格式2016-10
	 * @return
	 */
	public static Timestamp getMonthFristDay(Timestamp months, int addMonths, int whichDay) {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cal.setTime(months);
		cal.add(Calendar.MONTH, addMonths);
		cal.set(Calendar.DAY_OF_MONTH, whichDay);
		// 日期减一,取得上月最后一天时间对象
		// cal.add(Calendar.DAY_OF_MONTH, -1);
		return new Timestamp(cal.getTime().getTime());
	}

	/**
	 * 获取上个月的第一天
	 * 
	 * @return
	 */
	public static Timestamp getLastMonthStartDay() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		// cal.add(Calendar.DAY_OF_MONTH, -1);
		String date = StringUtil.dateFormat(cal.getTime(), "yyyy-MM-dd", "");
		return Timestamp.valueOf(date + " 00:00:00");
	}

	/**
	 * 获取大上个月的第一天
	 * 
	 * @return
	 */
	public static Timestamp getLastLastMonthStartDay() {
		// 取得系统当前时间
		Calendar cal = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cal.add(Calendar.MONTH, -2);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		// cal.add(Calendar.DAY_OF_MONTH, -1);
		String date = StringUtil.dateFormat(cal.getTime(), "yyyy-MM-dd", "");
		return Timestamp.valueOf(date + " 00:00:00");
	}

	public static String addUpDown(String target) {
		String ret = null;
		try {

			if (target != null && target.indexOf("-") == 0) {
				ret = "↓" + target.substring(1);
			} else {
				ret = "↑" + target;
			}

			ret = ret.substring(0, ret.indexOf(".") + 3);
		} catch (Exception e) {

		}

		return ret;
	}

	public static String addUpDown(Double target) {
		String ret = null;
		try {

			if (target != null && target < 0) {
				ret = "↓" + Math.abs(target);
			} else {
				ret = "↑" + target;
			}

			ret = ret.substring(0, ret.indexOf(".") + 3);

		} catch (Exception e) {

		}
		return ret;
	}

	/**
	 * 得到环比
	 * 
	 * @param z
	 * @param m
	 * @return
	 */
	public static String getRisePercent(Double nowValue, Double backValue) {
		if (backValue == null || nowValue == null || backValue == 0 || nowValue == 0) {
			return "0.0";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		double db = (nowValue - backValue) / backValue * 100;
		if (db > 150.0 || db < -150.0) {
			db = 0.0;
		}
		String result = numberFormat.format(db);
		return result;
	}

	/**
	 * 议价空间
	 * 
	 * @param guapai
	 *            挂牌价格
	 * @param chengjiao
	 *            成交价格
	 * @return
	 */
	public static String getPriceRange(Double guapai, Double chengjiao) {
		if (chengjiao == null || guapai == null || guapai == 0) {
			return "0.0";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		String result = numberFormat.format((Math.abs(guapai - chengjiao)) / guapai * 100);
		return result;
	}

	/**
	 * 交易活跃度
	 * 
	 * @param guapai
	 *            挂牌量
	 * @param chengjiao
	 *            成交量
	 * @return
	 */
	public static String getHotScore(Integer guapai, Integer chengjiao) {
		if (chengjiao == null || guapai == null || guapai == 0) {
			return "0.0";
		}
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setGroupingUsed(false);
		String result = numberFormat.format(guapai / chengjiao);
		return result;
	}

	public static Double getRisePercentDouble(Double nowValue, Double backValue) {
		if (backValue == 0) {
			return 0.0;
		}
		Double result = (nowValue - backValue) / backValue * 100;
		if (result > 150 || result < -150) {
			result = 0.0;
		}
		return result;
	}

	/**
	 * 得到环比
	 * 
	 * @param z
	 * @param m
	 * @return
	 */
	public static String getRisePercent(Integer nowValue, Integer backValue) {
		if (backValue == null || nowValue == null || backValue == 0) {
			return "0.0";
		}
		Double a = nowValue.doubleValue();
		Double b = backValue.doubleValue();
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMaximumFractionDigits(2);

		double db = (a - b) / b * 100;
		if (db > 150.0 || db < -150.0) {
			db = 0.0;
		}

		String result = numberFormat.format(db);
		return result;
	}

	/**
	 * 得到环比
	 * 
	 * @param nowValue
	 * @param backValue
	 * @return
	 */
	public static Double getRisePercent(BigDecimal nowValue, BigDecimal backValue) {
		if (nowValue == null || backValue == null || backValue.doubleValue() == 0.0) {
			return 0.0;
		}

		Double db = (nowValue.doubleValue() - backValue.doubleValue()) / backValue.doubleValue() * 100;
		if (db > 150.0 || db < -150.0) {
			db = 0.0;
		}

		return db;
	}
	/**
	 * 得到环比
	 *
	 * @param nowValue
	 * @param backValue
	 * @return
	 */
	public static Double getRisePercentNoParam(BigDecimal nowValue, BigDecimal backValue) {
		if (nowValue == null || backValue == null || backValue.doubleValue() == 0.0) {
			return 0.0;
		}

		Double db = (nowValue.doubleValue() - backValue.doubleValue()) / backValue.abs().doubleValue() * 100;

		return db;
	}
	/**
	 * 计算静态投资回收期 静态投资回收期（平均总价/(平均租金*12)）
	 * 
	 * @param a
	 *            总价
	 * @param b
	 *            租金
	 * @return
	 */
	public static Double getSPP(BigDecimal a, BigDecimal b) {
		a = a == null ? new BigDecimal(0) : a;
		b = b == null ? new BigDecimal(1) : b;
		return a.doubleValue() / (b.doubleValue() * 12.0);
	}

	/**
	 * 计算房价租金比 房价租金比（平均单价/（平均租金/平均面积））
	 * 
	 * @param a
	 *            单价
	 * @param b
	 *            租金
	 * @param c
	 *            面积
	 * @return
	 */
	public static Double getHPTR(BigDecimal a, BigDecimal b, BigDecimal c) {
		a = a == null ? new BigDecimal(0) : a;
		b = b == null ? new BigDecimal(1) : b;
		c = c == null ? new BigDecimal(1) : c;
		return a.doubleValue() / (b.doubleValue() / c.doubleValue());
	}

}
