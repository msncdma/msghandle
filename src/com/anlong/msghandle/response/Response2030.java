package com.anlong.msghandle.response;



/**
 * @Title: Response2030.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:00:02 
 * @version V1.0   
 * @Description: 发送消息
 */
public class Response2030 extends BaseResponse {
	/** 流水号 */
	private String serialNum;
	
	private String[] fieldArr = {"serialNum"};
	
	public String getSerialNum() {
		return serialNum;
	}


	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	public String toString() {
		return "Response2030 [serialNum=" + serialNum + "]";
	}

}
