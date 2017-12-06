package com.kevin86.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

/**
 * freemarker 模板工具
 * @author kevin chen
 *
 */
public class FreeMarkerUtils {
	
	public final static Configuration cfg = new Configuration();
	
	public static Template getTemplate(String fileName){
		 String ftl = System.getProperty("user.dir")+ "/template/t2";
			try {
				cfg.setDirectoryForTemplateLoading(new File(ftl));
				cfg.setObjectWrapper(new DefaultObjectWrapper()); 
			} catch (IOException e1) {
				e1.printStackTrace();
				return null;
			} 
			Template t  = null;
			try {
				t = cfg.getTemplate(fileName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		return t;
	}
	
	public static void writeTemplate(String outfile,Template t,Map<String, Object> root){
		OutputStream out = null;
		try {
			out = new FileOutputStream(new File(outfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}  
		 try {
			t.process(root, new OutputStreamWriter(out,"UTF-8"));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			 try {
				 if (out!=null)
					 out.close();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 }
	}

}
