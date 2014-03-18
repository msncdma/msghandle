package com.anlong.msghandle.common;

/**
 * @ClassName: HandleTimer 
 * @Package: com.anlong.imsghandle.common
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 消息响应定时控制类
 * @author anlong 
 * @date 2013-6-1 下午3:53:23 
 * @version V1.0
 */
public abstract class HandleTimer {
	/**给Key开启响应定时*/
	public abstract void startTimer(String key,String bCode);
	/**给Key结束响应定时*/
	public abstract void cancelTimer(String key);

}
