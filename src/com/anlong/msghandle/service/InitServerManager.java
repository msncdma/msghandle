package com.anlong.msghandle.service;

import com.anlong.msghandle.common.MessageTimer;
import com.anlong.msghandle.file.InitImageFileServer;
import com.anlong.msghandle.message.InitRequMessageServer;
import com.anlong.msghandle.message.InitRespMessageServer;


/**
 * @Title: InitServerManager.java 
 * @Package com.anlong.msghandle.service
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:01:07 
 * @version V1.0   
 * @Description: 管理所有线程服务
 */
public class InitServerManager {
	
	private InitServerManager(){}
	
	/**
	 * @Title: startRequestMessageService 
	 * @Description: TODO 发送消息线程服务
	 * @param  object     
	 * @return void     
	 * @throws
	 */
	public static void startRequestMessageService(Object object){
		new Thread(new InitRequMessageServer(object)).start();
	}
	
	/**
	 * @Title: startMessageThreadService 
	 * @Description: TODO 接收消息线程服务
	 * @return void     
	 * @throws
	 */
	public static void startResponseMessageService(){
		new Thread(new InitRespMessageServer()).start();
	}
	
	/**
	 * @Title: startFileThreadService 
	 * @Description: TODO 上传文件线程服务 
	 * @param  request100     
	 * @return void     
	 * @throws
	 */
	public static void startFileUploadThreadService(Object object){
		new Thread(new InitImageFileServer(object)).start();
	}
	
	/**
	 * @Title: startMessageTimerService 
	 * @Description: TODO 消息请求响应计时器 
	 * @author anlong 
	 * @param      
	 * @return void     
	 * @throws
	 */
	public static void startMessageTimerService(){
		new Thread(new MessageTimer()).start();
	}
	
}
