package com.anlong.msghandle.service;

import com.anlong.msghandle.socket.InitFileSocketServer;
import com.anlong.msghandle.socket.InitMsgSocketServer;

/**
 * @Title: ServerManager.java 
 * @Package com.anlong.msghandle.service
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:01:25 
 * @version V1.0   
 * @Description: TODO
 */
public class ServerManager {
	
	/**
	 * close all socket service 
	 * @Title: closeSocketService 
	 * @Description: TODO 关闭所有Socket服务
	 * @author anlong 
	 * @param      
	 * @return void     
	 * @throws
	 */
	public static void closeSocket() {
		try {
			InitMsgSocketServer.closeSocketConnection();
			InitFileSocketServer.closeSocketConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
