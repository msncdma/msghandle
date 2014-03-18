package com.anlong.msghandle.message;

import java.io.InputStream;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.handle.MsgResponseHandle;
import com.anlong.msghandle.socket.InitMsgSocketServer;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;


/**
 * @Title: InitRespMessageServer.java 
 * @Package com.anlong.msghandle.message
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:17:34 
 * @version V1.0   
 * @Description: 响应消息服务处理线程
 */
public class InitRespMessageServer implements Runnable {

	public InitRespMessageServer(){}
	
	@Override
	public void run() {
		InputStream inputStream = null;
		MsgResponseHandle msgResponseHandle=new MsgResponseHandle();
		//如果Socket连接实例不存在则退出 
		while(InitMsgSocketServer.getInstance() != null){
			try { 
				// 睡眠0.5秒
				Thread.sleep(500);
				// TODO 检测Socket连接实例
				if (InitMsgSocketServer.getInstance().isConnected()){
					// TODO 读取IO输入流数据
					if (inputStream == null) {
						inputStream = InitMsgSocketServer.getInputStream();
					}
					//响应数据流解析
					if(msgResponseHandle==null){
						 msgResponseHandle=new MsgResponseHandle();
					}
					msgResponseHandle.decode(inputStream); 
				} else { 
					// TODO 跳出循环,退出线程
					IMLog.anlong("Socket处于断开状态,消息响应线程终止.");
					Utils.notifyMessage(3,HandleStaticValue.BCODE1000);
					break;
				}
			} catch (Exception e){
				e.printStackTrace();
				IMLog.anlong("读取IO流时,解析响应数据异常");
				// TODO 通知页面更新提示
				Utils.notifyMessage(3,HandleStaticValue.BCODE1000);
				break;
			}
		}
		IMLog.anlong("===================================================(消息响应)线程终止=========================================================");
	}

}
