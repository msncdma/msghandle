package com.anlong.msghandle.event;

import java.util.EventObject;

/**
 * @ClassName: MessageEvent 
 * @Package: com.anlong.imsghandle.event
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 监听事件 
 * @author anlong 
 * @date 2013-4-26 下午7:43:19 
 * @version V1.0
 */
public class MessageEvent extends EventObject {

	private Short bCode;
	private Object message;
	
	public MessageEvent(Short bCode, Object message) {
		super(message);
		this.bCode = bCode;
		this.message = message;
	}

	public Short getbCode() {
		return bCode;
	}

	public void setbCode(Short bCode) {
		this.bCode = bCode;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

}
