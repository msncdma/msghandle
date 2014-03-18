package com.anlong.msghandle.util;

import android.util.Log;


/**
 * @Title: IMLog.java 
 * @Package com.anlong.msghandle.util
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:48:22 
 * @version V1.0   
 * @Description: 调试日志类
 */
public class IMLog {
     /**
      * 调试模式：是否调试标示
      */
    public static final boolean DEBUG=true;
    /**
     * 标记调试信息字段,开发人员可以设置便于调试
     */
    public static String TAG="debug";
    
    /**
     * 
     * @Description: TODO 调试正常信息  
     * @param msg
     */
    public static void i(String msg){
    	if( DEBUG){
    		  Log.i(TAG, msg);
    	}
    }
    
    /**
     * 
     * @Description: TODO 调试异常   
     * @param msg
     */
    public static void e(String msg){
    	if( DEBUG){
    		  Log.e(TAG, msg);
    	}
    }
    
    /**
     * 
     * @Description: TODO 调试所有信息   
     * @param msg
     */
    public static void v(String msg){
    	if( DEBUG){
    		  Log.v(TAG, msg);
    	}
    } 
     
    /**
     * 
     * @Description: TODO 调试警告   
     * @param msg
     */
    public static void w(String msg){
    	if( DEBUG){
    		  Log.w(TAG, msg);
    	}
    }
    
    /**
     * 
     * @Description: TODO anlong 调试正常信息    
     * @param msg
     */
    public static void anlong(String msg){
    	if( DEBUG){
    		Log.i("IMsgHandle[anlong]", msg);
    	}
    }
    
     
    public static void i(String TAG,String msg){
    	if( DEBUG){
    		  Log.i(TAG, msg);
    	}
    }
    
    
    public static void e(String TAG,String msg){
    	if( DEBUG){
    		  Log.i(TAG, msg);
    	}
    }
    public static void w(String TAG,String msg){
    	if( DEBUG){
    		  Log.i(TAG, msg);
    	}
    }
    public static void d(String TAG,String msg){
    	if( DEBUG){
    		  Log.i(TAG, msg);
    	}
    }
    
    
	
}
