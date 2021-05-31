package com.wh.utills;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface MyColl {
	//public optional
	public static Map<Integer,String> listToMap(List<Object[]>  list) {
		Map<Integer,String> map=new LinkedHashMap<>();
		for(Object[] ob:list) {
			Integer i=Integer.valueOf(ob[0].toString());
			String s=ob[1].toString();
			map.put(i, s);
		}//for
		return map;
	}//method
}//MyColl
