package com.eva.base.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings({ "unchecked"})
public class JsonUtil {

	protected final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	
	/**
	 * 
	 * JSON,使用Jackson转换Java对象.
	 * 
	 */
	public static <X> X renderObject(String json,Class<X> clazz){
		try {
			return (X)objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} 
		return null;
	}
	
	public static <X> X renderMap(Map<String,String> map,Class<X> clazz){
		try {
			return (X)objectMapper.readValue(objectMapper.writeValueAsString(map), clazz);
			
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} 
		return null;
	}
	
	public static Map<String, Object> json2Map(String jsonStr){
		JSONObject json = JSONObject.fromObject(jsonStr);
		Map<String, Object> map = new HashMap<String, Object>();
	    Iterator<String> it = json.keys();  
	    while(it.hasNext()) {  
	        String key = (String) it.next();  
	        map.put(key, json.get(key));  
	    } 
		return map;
	}
	
	public static String objct2Json(Object object){
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return "";
	}

}
