package com.anlong.msghandle.response;

/**
 * @Title: BaseResponse.java
 * @Package com.anlong.msgserver.entity.request
 * @company ShenZhen anlong Technology CO.,LTD.   
 * @author anlong   
 * @date 2013-4-17 
 * @version V1.0   
 * @Description:请求响应参数父类对象
 */
public class BaseResponse {
	/**消息长度 （字节为单位）*/
	private Integer msgSize;
	/**接口业务编码*/ 
	private Short bCode;
	/**密钥，加密用*/ 
	private Integer key;
	/**用户ID*/
	private Integer uid;
	/**应答代码*/
	private Short rtCode;
	/**错误信息*/
	private String rtMsg;
	/**消息流水号*/
	private Integer msgSerial;
	
	public Integer getMsgSize() {
		return msgSize;
	}
	public void setMsgSize(Integer msgSize) {
		this.msgSize = msgSize;
	}
	public Short getBCode() {
		return bCode;
	}
	public void setBCode(Short bCode) {
		this.bCode = bCode;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Short getRtCode() {
		return rtCode;
	}
	public void setRtCode(Short rtCode) {
		this.rtCode = rtCode;
	}
	public String getRtMsg() {
		return rtMsg;
	}
	public void setRtMsg(String rtMsg) {
		this.rtMsg = rtMsg;
	}
	public Integer getMsgSerial() {
		return msgSerial;
	}
	public void setMsgSerial(Integer msgSerial) {
		this.msgSerial = msgSerial;
	}
	
	/** 初始化参数*/
	public void init(Integer msgSize,Short bCode,Integer key,Integer uid,Short rtCode,String rtMsg,Integer msgSerial){
		this.msgSize = msgSize;
		this.bCode = bCode;
		this.key = key;
		this.uid = uid;
		this.rtCode = rtCode;
		this.rtMsg = rtMsg;
		this.msgSerial = msgSerial;
	}
	
	
}
