package com.anlong.msghandle.handle;

import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.response.Response1000;
import com.anlong.msghandle.socket.InitFileSocketServer;
import com.anlong.msghandle.util.ByteAndInt;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;

public class ImageResponseHandle {
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
	InputStream inputStream = null;
	// 是否有可读流
	int isSize = 0;
	
	public void ImageDecode(Object request){
		
		try {
			if (request == null)
				return;
			
			if(request instanceof Request100){
				
				IMLog.anlong("上传图片等待响应中...");
				
				inputStream = InitFileSocketServer.getInputStream();
				if (inputStream == null)
					return;
				
				// TODO 获取请求对象
				Request100 request100 = (Request100)request;
				
				// 消息字节大小,4个字节
				int msgSize = 0;
				
				// 定时等待响应
				getInstanceTimer(inputStream);
				while (!timerCancel) {
					//IMLog.anlong("等待上传图片响应..");
					// 等待0.5秒
					Thread.sleep(500);
				}
				
				// TODO 超时处理
				if (timeOut){
					IMLog.anlong("等待上传图片响应超时!");
					// TODO 通知页面更新提示
					try {
						Object obj = setResponse1000(request100, msgSize, (short)1);
						Utils.notifyMessage(obj,HandleStaticValue.BCODE1002);
					} catch (Exception e) {
						IMLog.anlong("监听队列没有找到 " + HandleStaticValue.BCODE1002 + "!");
						IMLog.anlong("已丢弃一个没有注册监听的数据包:" + HandleStaticValue.BCODE1002 + "!");
					}
					// 关闭Socket连接
					closeFileSocket();
					return;
				}
				
				// TODO 读取图片文件字节大小的响应
				byte[] dataSize = new byte[HandleStaticValue.PROTOCOL_SIZE];
				if(inputStream.read(dataSize) == HandleStaticValue.PROTOCOL_SIZE){
					msgSize = ByteAndInt.byteArray2Int(dataSize);
					IMLog.anlong("响应的图片文件字节大小:" + msgSize);
				}
				
				dataSize = null;
				
				// TODO 分发事件
				try {
					Object obj = setResponse1000(request100, msgSize, (short)0);
					Utils.notifyMessage(obj,HandleStaticValue.BCODE1002);
				} catch (Exception e) {
					IMLog.anlong("监听队列没有找到 " + HandleStaticValue.BCODE1002 + "!");
					IMLog.anlong("已丢弃一个没有注册监听的数据包:" + HandleStaticValue.BCODE1002 + "!");
				}
				// 关闭Socket连接
				closeFileSocket();
			}// end instance of
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(InitFileSocketServer.getInstance() != null){
				try {
					// TODO 关闭Socket
					InitFileSocketServer.closeSocketConnection();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @Title: closeFileSocket 
	 * @Description: TODO 关闭Socket连接
	 * @author anlong 
	 * @param      
	 * @return void     
	 * @throws
	 */
	private void closeFileSocket(){
		try {
			if(InitFileSocketServer.getInstance() != null){
				try {
					// TODO 关闭Socket
					InitFileSocketServer.closeSocketConnection();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * @Title: setResponse1000 
	 * @Description: TODO 封装对象
	 * @author anlong 
	 * @param @param request100
	 * @param @param msgSize
	 * @param @param rtCode
	 * @param @return     
	 * @return Response1000     
	 * @throws
	 */
	private Response1000 setResponse1000(Request100 request100,Integer msgSize,short rtCode){
		try {
			Response1000 response1000 = new Response1000();
			response1000.setFileCode(request100.getFileCode());
			response1000.setFileSize(msgSize);
			response1000.setRtCode(rtCode);
			response1000.setSendType(request100.getSendType());
			response1000.setImageType(request100.getImageType());
			return response1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Title: notifyMessage 
	 * @Description: TODO 启动定时器
	 * @author anlong 
	 * @throws
	 */
	private static void getInstanceTimer(InputStream inputStream){
        if ( timer == null ){
            timer = new Timer();
            // 开启定时器的时间
            startTime = System.currentTimeMillis();
            // 在1秒后执行此任务,每次间隔2秒    
            timer.schedule(new RunTask(inputStream), 1000, 2000);
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
		private InputStream inputStream1 = null;
		
		public RunTask(InputStream inputStream){
			inputStream1 = inputStream;
			
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
			try {
				if ( inputStream1.available() != 0 ){
					timerCancel = true;
					timer.cancel();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
