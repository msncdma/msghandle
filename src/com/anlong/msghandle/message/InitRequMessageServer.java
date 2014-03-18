package com.anlong.msghandle.message;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.handle.MsgRequestHandle;
import com.anlong.msghandle.service.InitServerManager;
import com.anlong.msghandle.socket.InitMsgSocketServer;
import com.anlong.msghandle.util.Utils;


/**
 * @Title: InitRequMessageServer.java 
 * @Package com.anlong.msghandle.message
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:17:10 
 * @version V1.0   
 * @Description: 发送消息服务处理线程
 */
public class InitRequMessageServer implements Runnable{
	// 请求对象
	private Object request = null;
	// 定时器
	private static Timer timer = null;
	// 是否已经停止定时器
	private static boolean timerCancel = false;
	// 开启定时器的时间
	private static long startTime = 0;
	// 停止定时器的时间
	private static long endTime = 0;
	// 是否超时
	private static boolean timeOut = false;
	
	/**
	 * 发送消息服务    构造函数
	 * @param object
	 */
	public InitRequMessageServer(Object object){
		request = object;
	}
	
	
	@Override
	public void run() {
		try { 
			
			if(InitMsgSocketServer.getInstance()==null||! InitMsgSocketServer.getInstance().isConnected()){
					// TODO 开启Socket连接
					try {
						InitMsgSocketServer.init(HandleStaticValue.SERVER_IP,HandleStaticValue.SERVER_PORT);
					} catch (java.net.SocketTimeoutException e) {
						Log.e("test", "----警告 InitRequMessageServer socket 连接服务器超时！超时！超时！'请检查ip端口是否正确！：----------->");
						// TODO 通知页面更新提示 
						Utils.notifyMessage(8,HandleStaticValue.BCODE1000);
						return;
					}catch (Exception e) { 
						Log.e("test", "----警告 InitRequMessageServer socket 连接服务器异常。。！：----------->");
						// TODO 通知页面更新提示
						Utils.notifyMessage(8,HandleStaticValue.BCODE1000);
					}
					// TODO 检测Socket连接实例
					getInstanceTimer();
					while(!timerCancel){
						//IMLog.anlong("等待开启Socket连接...");
						// 等待0.05秒
						Thread.sleep(50);
					}  
					// TODO 超时处理
					if (timeOut){
						Log.e("test", "----警告socket 连接服务器超时！超时！超时！：----------->");
						// TODO 通知页面更新提示
						Utils.notifyMessage(8,HandleStaticValue.BCODE1000);
						return;
					}
					// TODO 连上服务器则通知页面更新提示
					Utils.notifyMessage(5,HandleStaticValue.BCODE1000);
					
					// TODO 开启接收消息服务
					InitServerManager.startResponseMessageService();
					// TODO 开启接收消息定时服务
					InitServerManager.startMessageTimerService();
				}
				
			try {
				MsgRequestHandle.getInstance().encode(request);
			} catch (Exception e) {
				Utils.notifyMessage(6,HandleStaticValue.BCODE1000);
				e.printStackTrace();
			}
				
		} catch (Exception e) {
			InitMsgSocketServer.closeSocketConnection();
			// TODO 通知页面更新提示
			Utils.notifyMessage(3,HandleStaticValue.BCODE1000);
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: notifyMessage 
	 * @Description: TODO 启动定时器
	 * @author anlong 
	 * @throws
	 */
	private static void getInstanceTimer(){
        if ( timer == null ){
            timer = new Timer();
            // 开启定时器的时间
            startTime = System.currentTimeMillis();
            // 在1秒后执行此任务,每次间隔2秒    
            timer.schedule(new RunTask(), 1000, 2000);
            //timer.cancel();
        }
    }
	
	/**
	 * @Title: notifyMessage 
	 * @Description: TODO 定时器
	 * @author anlong 
	 * @throws
	 */
	static class RunTask extends TimerTask{
		public RunTask(){
			// 终止定时器的时间
			endTime = System.currentTimeMillis();
			// 检测20秒超时
			if((endTime - startTime) > HandleStaticValue.SERVER_CONNECTION_TIMEOUT){
				timeOut = true;
				timerCancel = true;
				timer.cancel();
			}
		}
		@Override
		public void run(){
			if ( InitMsgSocketServer.getInstance() != null ){
				timerCancel = true;
				timer.cancel();
			} 
		}
	}



}
