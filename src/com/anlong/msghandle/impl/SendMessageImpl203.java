package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request203;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: SendMessageImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装发送消息请求数据流 
 * @author anlong 
 * @date 2013-4-28 下午3:18:05 
 * @version V1.0
 */
public class SendMessageImpl203 extends AbstractMsgHandle {
	
	private static SendMessageImpl203 instance = null;
	
	public static SendMessageImpl203 getInstance(){
		if ( instance == null )
			instance = new SendMessageImpl203();
		return instance;
	}
	
	@Override
	public void execute(Request203 request203) throws Exception {
		// 封装发送消息请求数据流
		InitServerManager.startRequestMessageService(request203);
	}
}
