package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: UserInfoListImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装用户列表业务请求数据流
 * @author anlong 
 * @date 2013-4-28 下午3:18:25 
 * @version V1.0
 */
public class UserInfoListImpl extends AbstractMsgHandle {
	
	private static UserInfoListImpl instance = null;
	
	public static UserInfoListImpl getInstance(){
		if ( instance == null) 
			instance = new  UserInfoListImpl();
		return instance;
	}
	
	/*@Override
	public void execute(Request106 request106) throws Exception {
		// 封装用户列表业务请求数据流
		InitServerManager.startRequestMessageService(request106);
	}*/
}
