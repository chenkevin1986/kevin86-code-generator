package com.kevin86.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	/**首字母大写*/
    public static String uppercaseString(String str) {
    	//str = str.substring(0, 1).toUpperCase() + str.substring(1);
        char[] cs=str.toCharArray();
        if(cs[0] >= 97 ){ 
        	cs[0]-=32;
        	return String.valueOf(cs);
        }
        return str;
    }
    /**首字母转成小写*/
    public static String lowerCaseStr(String str){
    	char[] cs=str.toCharArray();
        if(cs[0] >= 65 &&cs[0] < 97 ){ 
        	cs[0]+=32;
        	return String.valueOf(cs);
        }
        return str;
    }
    /**全部转成小写*/
    public static String allLowerCaseStr(String str){
    	char[] cs=str.toCharArray();
    	for (int i = 0; i < cs.length; i++) {
			if(cs[i] >= 65 &&cs[i] < 97 ){ 
	        	cs[i]+=32;
			}
		}
    	return new String(cs);
    }
    
    /**
    * 日期转换成字符串
    * @param date  flag-> true:有时分秒    flag:没有时分秒
    * @return str
    */
    public static String dateToStr(Date date,boolean flag) {
    	String timestr= flag?"yyyy-MM-dd HH:mm:ss":"yyyy-MM-dd";
    	SimpleDateFormat format = new SimpleDateFormat(timestr);
    	String str = format.format(date);
    	return str;
    } 

    /**
    * 字符串转换成日期 
    * @param str  flag-> true:有时分秒    flag:没有时分秒
    * @return date
    */
    public static Date strToDate(String str,boolean flag) {
    	String timestr= flag?"yyyy-MM-dd HH:mm:ss":"yyyy-MM-dd";
    	SimpleDateFormat format = new SimpleDateFormat(timestr);
    	Date date = null;
    	try {
    		date = format.parse(str);
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return date;
    }
    //正则表达式的匹配
    public boolean isChange(String arrays){
    	return true;
    }
    
    /**格式为：v00_v01_v02|v10_v11_v2 */
    public static int[][] toArraysByStrings(String arrays){
    	if(arrays == null ||arrays.equals("-1")||arrays.equals("0")){
    		return null;
    	}
    	String[] split0 = arrays.split("\\|");
    	int [][] ss0 = new int[split0.length][]; 
    	for (int i = 0; i < split0.length; i++) {
    		String str = split0[i];
    		String[] split2 = str.split("_");
    		int[] ss = new int[split2.length];
    		for (int j = 0; j < split2.length; j++) {
    			ss[j] = Integer.parseInt(split2[j]);
			}
    		ss0[i]= ss;
		}
    	return ss0;
    }
    
    public static String getPackageByPath(String pro){
    	if(pro == null)
    		throw new NullPointerException("java生成目录 未配置！");
    	pro = pro.replaceAll("/", ".");
    	pro = pro.substring(pro.indexOf(".")+1);
    	return pro;
    }

	/**
	 * 去除字符串中的空格、回车、换行符、制表符
	 * @param str
	 * @return
     */
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	/**
	 * 把带下划线的命名字段 转换成驼峰命名方式
	 * @param str
	 * @return
	 */
	public static String humpNaming(String str){
		String[] split = str.split("_");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			String s = split[i];
			sb.append(uppercaseString(s));
		}
		return lowerCaseStr(sb.toString());
	}

}
