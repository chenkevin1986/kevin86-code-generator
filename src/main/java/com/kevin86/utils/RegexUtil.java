package com.kevin86.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	
	public static boolean matches(String str,String regex){
		Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(str); 
        return matcher.matches();
	}

	public static void main(String[] args) {
		String coms = System.getProperty("user.dir");
		String str =coms+"\\src\\dao\\mapper";
		str = str.substring(str.lastIndexOf("src")+4);
		System.out.println(str);
		str = str.replaceAll("\\\\","\\.");
		System.out.println(str);
		str = str.replaceAll("\\.","\\\\");
		System.out.println(str);
		str = coms+"\\src\\"+str;
		System.out.println(str);
		System.out.println(str.split(",").length);
	}
}
