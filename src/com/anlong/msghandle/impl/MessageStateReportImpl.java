package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: MessageStateReportImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装发送消息请求数据流
 * @author anlong 
 * @date 2013-4-28 下午3:17:38 
 * @version V1.0
 */
public class MessageStateReportImpl extends AbstractMsgHandle {
	
	private static MessageStateReportImpl instance = null;
	
	public static MessageStateReportImpl getInstance(){
		if ( instance == null )
			instance = new MessageStateReportImpl();
		return instance;
	}
	
	/*@Override
	public void execute(Request204 request204) throws Exception {
		// 封装发送消息请求数据流
		InitServerManager.startRequestMessageService(request204);
	}*/
}
