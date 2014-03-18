package com.anlong.msghandle.request;

import com.anlong.msghandle.vo.UserMessage;

/**
 * @Title: Request203.java 
 * @Package com.anlong.msghandle.request
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:15:18 
 * @version V1.0   
 * @Description: 发送消息请求接入参数对象
 */
public class Request203 extends BaseRequest{

	private UserMessage userMessage;

	private String[] fieldArr = {"userMessage"};
	
	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

	@Override
	public String toString() {
		return "EI203 [UserMessage=" + userMessage + ", toString()="
				+ super.toString() + "]";
	}
	
}
