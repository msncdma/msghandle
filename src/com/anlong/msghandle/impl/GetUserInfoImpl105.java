package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request105;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: GetUserInfoImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装获取用户信息业务请求数据流 
 * @author anlong 
 * @date 2013-4-28 下午3:17:14 
 * @version V1.0
 */
public class GetUserInfoImpl105 extends AbstractMsgHandle {
	//频繁请求，单例模式降低内存占用
	private static GetUserInfoImpl105 instance = null;
	
	public static GetUserInfoImpl105 getInstance(){
		if ( instance == null) 
			instance = new GetUserInfoImpl105();
		return instance;
	}
	
	@Override
	public void execute(Request105 request105) throws Exception {
		// 封装获取用户信息业务请求数据流
		InitServerManager.startRequestMessageService(request105);
	}
}
