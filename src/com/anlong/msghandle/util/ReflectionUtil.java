package com.anlong.msghandle.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @Title: ReflectionUtil.java 
 * @Package com.anlong.msghandle.util
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:55:56 
 * @version V1.0   
 * @Description: 反射业务处理类
 */
public class ReflectionUtil {
 
	@SuppressWarnings("unchecked")
	public static Object invokeMethod(Object obj, String mehtodName,Object... parameter) {
		Class c = obj.getClass();
		Method method = null;
		Object result = null;
		if (parameter == null||parameter.length<1) {
			try {
				method = c.getMethod(mehtodName, new Class[] {});
				result = method.invoke(obj, new Object[] {}); 
			} catch (Exception e) {
				e.printStackTrace();
				return result; 
			} 
		} else {
			Class[] clas = new Class[parameter.length];
			for (int i = 0; i < parameter.length; i++) {
				try {
					clas[i] = parameter[i].getClass();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					continue;
				}
			}
			try {
				method = c.getMethod(mehtodName, clas);
				result = method.invoke(obj, parameter);
			} catch (Exception e) {
				e.printStackTrace();
				return result;
			} 

		}
		return result;
	}

}