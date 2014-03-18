package com.anlong.msghandle.request;

/**
 * @Title: BaseRequest.java
 * @Package com.anlongs.msgserver.entity.request
 * @company ShenZhen anlongs Technology CO.,LTD.   
 * @author anlong 
 * @date 2013-4-17 
 * @version V1.0   
 * @Description:请求接入参数报文头
 */
public class BaseRequest{
	/**消息长度 （字节为单位）*/
	private Integer msgSize;
	/**接口业务编码*/ 
	private Short bCode;
	/**密钥，加密用*/ 
	private Integer key;
	/**用户ID*/
	private Integer uid;
	/**消息来源*/
	private Byte apId;
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
	public Byte getApId() {
		return apId;
	}
	public void setApId(Byte apId) {
		this.apId = apId;
	}
	public Integer getMsgSerial() {
		return msgSerial;
	}
	public void setMsgSerial(Integer msgSerial) {
		this.msgSerial = msgSerial;
	}

	/** 初始化对象*/
	public void init(Integer msgSize,Short bCode,Integer key,Integer uid,Byte apId,Integer msgSerial){
		this.msgSize = msgSize;
		this.bCode = bCode;
		this.key = key;
		this.uid = uid;
		this.apId = apId;
		this.msgSerial = msgSerial;
	}
	
	
	@Override
	public String toString() {
		return "BaseRequest [msgSize=" + msgSize + ", bCode=" + bCode
				+ ", key=" + key + ", uid=" + uid + ", apId=" + apId
				+ ", toString()="
				+ super.toString() + "]";
	}
	
}
