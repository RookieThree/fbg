package com.jiang.util;
/**
 * ���������࣬ר�������пպͷǿմ���
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
