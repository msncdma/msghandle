package com.anlong.msghandle.file;

import java.util.Timer;
import java.util.TimerTask;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.handle.ImageRequestHandle;
import com.anlong.msghandle.handle.ImageResponseHandle;
import com.anlong.msghandle.socket.InitFileSocketServer;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;

/**
 * @ClassName: InitFileServer 
 * @Package: com.anlong.imsghandle.file01
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 图片文件传输服务处理线程
 * @author anlong 
 * @date 2013-5-31 下午2:22:34 
 * @version V1.0
 */
public class InitImageFileServer implements Runnable {
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
	 * 发送图片 构造函数
	 * @param object
	 */
	public InitImageFileServer(Object object){
		request = object;
	}
	
	@Override
	public void run() {
			try {
				if (InitFileSocketServer.getInstance() != null) {
					InitFileSocketServer.closeSocketConnection();
				}
				
				// TODO 开启Socket连接
				try {
					InitFileSocketServer.init(HandleStaticValue.SERVER_IP,getPort());
				}catch(Exception e){
					// TODO 通知页面更新提示
					Utils.notifyMessage(7,HandleStaticValue.BCODE1000);
					return;
				}
				
				// TODO 检测Socket连接实例
				getInstanceTimer();
				while(!timerCancel){
					//IMLog.anlong("等待开启图片上传Socket连接...");
					// 等待0.5秒
					Thread.sleep(500);
				}
				
				// TODO 超时处理
				if (timeOut){
					// TODO 通知页面更新提示
					Utils.notifyMessage(3,HandleStaticValue.BCODE1000);
					return;
				}
				
				// TODO 连上服务器则通知页面更新提示
				Utils.notifyMessage(5,HandleStaticValue.BCODE1000);
				
				// TODO 数据流处理
				if (InitFileSocketServer.getInstance() != null){
					// TODO 图片文件上传
					new ImageRequestHandle().ImageEncode(request);
					// TODO 图片文件上传响应
					new ImageResponseHandle().ImageDecode(request);
				} else {
					IMLog.anlong("图片上传Socket处于断开状态,图片上传失败.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
	}
	
	/**
	 * @Title: getPort 
	 * @Description: TODO 获取端口号并转化为图片发送端口号
	 * @author anlong 
	 * @param 
	 * @return String     
	 * @throws
	 */
	private static int getPort(){
		try {
			// TODO 获取配置端口号
			int port = HandleStaticValue.SERVER_PORT;
			if (port == 0)
				return 0;
				
			// TODO 配置端口号末尾+1 = 图片发送端口号
			return (port + 1);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
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
			if ( InitFileSocketServer.getInstance() != null ){
				timerCancel = true;
				timer.cancel();
			} 
		}
	}

}
