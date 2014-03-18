package com.anlong.msghandle.common;

import java.io.Serializable;


/**
 * @Title: BaseMessage.java 
 * @Package com.anlong.msghandle.common
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:28:19 
 * @version V1.0   
 * @Description: 所有请求对象和响应对象的父类，相当于包头
 */
public class BaseMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	/**消息长度 （字节为单位）*/
	private Integer msgSize;
	/**接口业务编码*/ 
	private Integer bCode;
	/**密钥，加密用*/ 
	private Integer key;
	/**用户ID*/
	private Integer uid;
	/**应答代码*/
	private Short rtCode;
	/**错误信息*/
	private String rtMsg;
	
	public Integer getMsgSize() {
		return msgSize;
	}
	public void setMsgSize(Integer msgSize) {
		this.msgSize = msgSize;
	}
	public Integer getBCode() {
		return bCode;
	}
	public void setBCode(Integer bCode) {
		this.bCode = bCode;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
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
	
	/** 初始化参数*/
	public void init(Integer msgSize,Integer bCode,Integer key,Integer uid,Short rtCode,String rtMsg){
		this.msgSize = msgSize;
		this.bCode = bCode;
		this.key = key;
		this.uid = uid;
		this.rtCode = rtCode;
		this.rtMsg = rtMsg;
	}
	
	@Override
	public String toString() {
		return "BaseMessage [bCode=" + bCode + ", key=" + key + ", msgSize="
				+ msgSize + ", rtCode=" + rtCode + ", rtMsg=" + rtMsg
				+ ", uid=" + uid + "]";
	}
}
