package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request101;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: LoginImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 登录业务处理类
 * @author anlong 
 * @date 2013-4-26 下午8:45:39 
 * @version V1.0
 */
public class LoginImpl101 extends AbstractMsgHandle {
	
	
	public LoginImpl101(){}
	
	@Override
	public void execute(Request101 request101) throws Exception{
		// 封装登录业务请求数据流
		InitServerManager.startRequestMessageService(request101);
	}
	
	

}
