package com.anlong.msghandle.response;


/**
 * @Title: Response1030.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:58:38 
 * @version V1.0   
 * @Description: 心跳
 */
public class Response1030 extends BaseResponse {
	/** 在线人数 */
	private Integer onlineNum;
	/** 服务器当前时间 */
	private String dateTime;

	private String[] fieldArr = {"onlineNum","dateTime"};
	
	public Integer getOnlineNum() {
		return onlineNum;
	}

	public void setOnlineNum(Integer onlineNum) {
		this.onlineNum = onlineNum;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Response1030 [onlineNum=" + onlineNum + ", dateTime=" + dateTime + "]";
	}
}
