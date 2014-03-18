package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: GroupInfoListImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装机构列表请求数据流 
 * @author anlong 
 * @date 2013-4-28 下午3:17:24 
 * @version V1.0
 */
public class GroupInfoListImpl extends AbstractMsgHandle {
	
	private static GroupInfoListImpl instance = null;
	
	public static GroupInfoListImpl getInstance(){
		if ( instance == null )
			instance = new GroupInfoListImpl();
		return instance;
	}
	
	/*@Override
	public void execute(Request109 request109) throws Exception {
		// 封装机构列表请求数据流
		InitServerManager.startRequestMessageService(request109);
	}*/
}
