package com.cindata.housekeeper.core.common.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常用excel处理类工具
 * @author yss
 *
 */
public class ExcelUtil {

	public static List<Map<String, Object>> createExcelRecord(List<Map<String, Object>> dataList, String[] keys) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        if(keys != null && keys.length > 0 && dataList != null && !dataList.isEmpty()){
        	for (Map<String, Object> item : dataList) {
        		Map<String, Object> mapValue = new HashMap<String, Object>();
    			for (String key : keys) {
    				mapValue.put(key, StringUtil.toString(item.get(key), null));
				}
    			listmap.add(mapValue);
    		}
        }
    	
        return listmap;
    }
	
}
