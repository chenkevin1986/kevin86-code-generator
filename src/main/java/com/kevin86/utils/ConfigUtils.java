package com.kevin86.utils;

import javax.swing.*;
import java.io.*;
import java.util.Map.Entry;
import java.util.Properties;

public class ConfigUtils {
	/**
	 * 读取系统配置文件！
	 */
	public static void readProperties(){
		String path = System.getProperty("user.dir");
		File file = new File(path+ "/config/t2/system.properties");
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(file));
			for (Entry<Object, Object> entry : properties.entrySet()) {
				String key = entry.getKey().toString();
				String value = entry.getValue().toString().replace("${CLASSPATH}", path);
				System.setProperty(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**读取DB配置*/
	public static Properties loadDBProperty() {
		InputStream inputStream = null;
		Properties p = null;
		try {
			String profilepath = System.getProperty("user.dir")+ "/config/t2/db.properties";
			inputStream = new FileInputStream(new File(profilepath));
			p = new Properties();
			p.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	public static Properties loadProperties(String profilepath){
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(profilepath));
			p = new Properties();
			p.load(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	 /**
	    * 更新（或插入）一对properties信息(主键及其键值)
	    * 如果该主键已经存在，更新该主键的值；
	    * 如果该主键不存在，则插件一对键值。
	    * @param keyname 键名
	    * @param keyvalue 键值
	    */
	    public static void writeProperties(String keyname,String keyvalue) {       
	        try {
	        	String profilepath = System.getProperty("user.dir")+ "/config/system.properties";
	        	Properties props = loadProperties(profilepath);
	            OutputStream fos = new FileOutputStream(profilepath);
	            props.setProperty(keyname, keyvalue);
	            props.store(fos, "Update '" + keyname + "' value");
	        } catch (IOException e) {
	            System.err.println("属性文件更新错误");
	        }
	    }

	    
	    public static Properties loadPropertyFile(String fullFile) {
			if (null == fullFile || fullFile.equals(""))
				throw new IllegalArgumentException("Properties file path can not be null : " + fullFile);
			InputStream inputStream = null;
			Properties p = null;
			try {
				String profilepath = System.getProperty("user.dir")+ "/config/" +fullFile;
				System.out.println(profilepath);
				inputStream = new FileInputStream(new File(profilepath));
				p = new Properties();
				p.load(inputStream);
			} catch (FileNotFoundException e) {
				throw new IllegalArgumentException("Properties file not found: "+ fullFile);
			} catch (IOException e) {
				throw new IllegalArgumentException("Properties file can not be loading: " + fullFile);
			} finally {
				try {
					if (inputStream != null)
						inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return p;
		}

	/**
	 * 更新 文本框 缓存 机配置
	 * @param jf
	 * @param key
	 * @param new_value
	 */
	public static void updateProperties(JTextField jf, String key, String new_value){
		jf.setText(new_value);
		System.setProperty(key, new_value);
		writeProperties(key, new_value);
	}

	/**
	 * 新增 文本框 的 系统缓存配置文件
	 * @param jf
	 * @param key
	 * @param value
	 */
	public static void addSetProperites(JTextField jf,String key,String value){
		if ( System.getProperty(key) == null ||
				System.getProperty(key).isEmpty()){
			writeProperties(key,value);
			System.setProperty(key,value);
		}
		jf.setText(System.getProperty(key));
	}
	    
	
	public static void main(String[] args) {
		writeProperties("k1", "2222");
	}

}
