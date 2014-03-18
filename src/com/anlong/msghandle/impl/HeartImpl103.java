package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request103;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: HeartImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 心跳业务请求数据流
 * @author anlong 
 * @date 2013-5-7 上午11:41:21 
 * @version V1.0
 */
public class HeartImpl103 extends AbstractMsgHandle {
	
	private static HeartImpl103 instance = null;
	
	public static HeartImpl103 getInstance(){
		if ( instance == null )
			instance = new HeartImpl103();
		return instance;
	}
	
	@Override
	public void execute(Request103 request103) throws Exception {
		// 心跳请求数据流
		InitServerManager.startRequestMessageService(request103);
	}
}
