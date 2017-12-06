package com.kevin86.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressUtils {
	/**
	 * 获取本地IP地址
	 * @return
	 */
	public static String getLocalIp(){
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	    return ip;
	}

}
