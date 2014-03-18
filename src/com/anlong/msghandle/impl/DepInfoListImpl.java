package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.service.InitServerManager;

/**
 * @ClassName: DepInfoListImpl 
 * @Package: com.anlong.imsghandle.impl
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 封装机构列表请求数据流
 * @author anlong 
 * @date 2013-4-28 下午3:15:46 
 * @version V1.0
 */
public class DepInfoListImpl extends AbstractMsgHandle {
	
	private static DepInfoListImpl instance = null;
	
	public static DepInfoListImpl getInstance(){
		if ( instance == null )
			instance = new DepInfoListImpl();
		return instance;
	}
	
	/*@Override
	public void execute(Request107 request107) throws Exception {
		// 封装机构列表请求数据流
		InitServerManager.startRequestMessageService(request107);
	}*/
}
