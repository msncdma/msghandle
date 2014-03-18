package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request110;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: OnlineUserListImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装在线用户请求数据流
 * @author anlong 
 * @date 2013-4-28 下午3:17:57 
 * @version V1.0
 */
public class OnlineUserListImpl110 extends AbstractMsgHandle {
	
	private static OnlineUserListImpl110 instance = null;
	
	public static OnlineUserListImpl110 getInstance(){
		if ( instance == null )
			instance = new OnlineUserListImpl110();
		return instance;
	}
	
	@Override
	public void execute(Request110 request110) throws Exception {
		// 封装在线用户请求数据流
		InitServerManager.startRequestMessageService(request110);
	}
}
