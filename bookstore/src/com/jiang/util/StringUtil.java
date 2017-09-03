package com.jiang.util;
/**
 * 建个工具类，专门用于判空和非空处理
 * @author Administrator
 *
 */
public class StringUtil {
	public static boolean isBlank(String str){
		return str==null || str.trim().length()<1;
	}
	
	public static boolean isNotBlank(String str){
		return str!=null&&str.trim().length()>0;
	}
}
