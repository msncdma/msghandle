package com.anlong.msghandle.util;

import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Properties;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.anlong.msghandle.event.MessageEvent;
import com.anlong.msghandle.event.MessageEventSource;


/**
 * @Title: Utils.java 
 * @Package com.anlong.msghandle.util
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:56:43 
 * @version V1.0   
 * @Description: 工具类
 */
public class Utils {
	
	/**
	 * 获取配置文件源
	 * @return
	 * @throws Exception
	 */
	private static Properties getSource() throws Exception {
		ClassLoader classLoader = Utils.class.getClassLoader();
        URL resUrl = classLoader.getResource("/project.properties");
        InputStream input = resUrl.openStream();
        Properties property = new Properties();
        property.load(input);
        return property;
	}
	
	/**
	 * 获取配置文件属性值
	 * @param propertyName
	 * @return
	 */
	public static String getProperty(String propertyName){
		try {
			Properties property = getSource();
	        return property.getProperty(propertyName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 设置配置文件属性值
	 * SERVER_IP=""  , SERVER_PORT=""
	 * @param name
	 * @param value
	 */
	public static void setProperty(String name,String value){
		try {
			Properties property = getSource();
	        property.setProperty(name, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO 通知页面更新提示：1-重连中,2-重连超时,3-消息Socket连接超时,4-IP地址或端口是无效的,
	 * 	    5-连接成功,6-消息响应超时,7-文件Socket连接超时,8-登录服务器连接超时
	 * @author anlong 
	 */
	public static void notifyMessage(Object obj,short bcode){
		try {
			Object object = obj;
			MessageEvent event = new MessageEvent(bcode, object);
			MessageEventSource eventSource=MessageEventSource.getSingleton();
			if(eventSource!=null){
				eventSource.notifyMessageEvent(event);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: isNetworkConnected 
	 * @Description: TODO 判断是否有网络 
	 * @author anlong 
	 * @param @param context
	 * @param @return     
	 * @return boolean     
	 * @throws
	 */
	public static boolean isNetworkConnected(Context context) {  
		if (context != null) {  
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context  
					.getSystemService(Context.CONNECTIVITY_SERVICE);  
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();  
			if (mNetworkInfo != null) {  
				return mNetworkInfo.isAvailable();  
			}  
		}  
		return false;  
		/*State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();  
		  if(State.CONNECTED==state){  
		   Log.i("通知", "GPRS网络已连接");  
		  }  
		    
		  state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();  
		  if(State.CONNECTED==state){  
		   Log.i("通知", "WIFI网络已连接");  
		  }  */
	}  
	
	/**
	 * 获得文件大小的字符串形式
	 * 
	 * @param fileSize
	 * @return
	 * @param
	 */
	public static String getFileSizeString(Long fileS) {
		if (fileS == null) {
			fileS = 0L;
		}
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "";
		if (fileS < 1024) {
			fileSizeString = df.format((double) fileS) + "B";
		} else if (fileS < 1048576) {
			fileSizeString = df.format((double) fileS / 1024) + "K";
		} else if (fileS < 1073741824) {
			fileSizeString = df.format((double) fileS / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) fileS / 1073741824) + "G";
		}
		return fileSizeString;
	}

	/** equals重写 */
	public static boolean equals(String s1, String s2) {
		if (Utils.isNotNull(s1) && Utils.isNotNull(s2) && s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean equals(Object obj1, Object obj2) {
		if (Utils.isNotNull(obj1) && Utils.isNotNull(obj2)
				&& obj1.toString().equals(obj2.toString())) {
			return true;
		} else {
			return false;
		}
	}

	/** 判断是否为空 */
	public static boolean isNull(Object obj1) {
		if (Utils.isNotNull(obj1)) {
			return false;
		} else {
			return true;
		}
	}

	/** 判断是否非空 */
	public static boolean isNotNull(Object obj1) {
		if (null == obj1 || "".equals(obj1.toString())
				|| "null".equals(obj1.toString())) {
			return false;
		} else {
			return true;
		}
	}

	/** int类型转换 */
	public static int getInt(String intValue, int defaultValue) {
		int value = defaultValue;
		try {
			value = Integer.parseInt(intValue);
		} catch (Exception e) {

		}
		return value;
	}

	/** long类型转换 */
	public static long getLong(String longValue, long defaultValue) {
		long value = defaultValue;
		try {
			Long.parseLong(longValue);
		} catch (Exception e) {
		}
		return value;
	}

}
