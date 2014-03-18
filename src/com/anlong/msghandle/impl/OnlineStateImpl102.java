package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request102;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: OnlineStateImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装在线状态请求数据流
 * @author anlong 
 * @date 2013-4-28 下午3:17:48 
 * @version V1.0
 */
public class OnlineStateImpl102 extends AbstractMsgHandle {
	
	private static OnlineStateImpl102 instance = null;
	
	public static OnlineStateImpl102 getInstance(){
		if ( instance == null) 
			instance = new OnlineStateImpl102();
		return instance;
	}
	
	@Override
	public void execute(Request102 request102) throws Exception {
		// 封装在线状态请求数据流
		InitServerManager.startRequestMessageService(request102);
	}
}
