package com.anlong.msghandle.impl;

import com.anlong.msghandle.interfac.AbstractMsgHandle;
import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.service.InitServerManager;

public class SendImageFile extends AbstractMsgHandle {
	
	@Override
	public void execute(Request100 request100) throws Exception {
		
		// TODO 图片文件发送	
		InitServerManager.startFileUploadThreadService(request100);
	}
}
