package com.anlong.msghandle.vo;


/**
 * @Title: BroadcastMessage.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:39:08 
 * @version V1.0   
 * @Description: 广播消息对象
 */
public class BroadcastMessage {
	/** 消息Id **/
	private Integer msgId;
	/** 发送者ID **/
	private Integer senderId;
	/** 目标ID (1&2&3&4) **/
	private String targetId;
	/** 1客户端接收, 2离线发短信, 3互动发短信, 4广播发短信 **/
	private Byte sendMode;
	/** 信息来源 (应用ID) **/
	private Byte msgSrc;
	/** 信息标题 **/
	private String title;
	/** 信息内容 **/
	private String contents;
	/** 发送时间 **/
	private String sendDate;
	/** 流水号 **/
	private String serialNum;
	/** 发送状态:1-发送成功;2-发送失败 **/
	private Byte sendState;
	/** 错误编码 **/
	private String errorCode;

	private String[] fieldArr = { "msgId", "senderId", "targetId", "sendMode",
			"msgSrc", "title", "contents", "sendDate", "serialNum",
			"sendState", "errorCode" };

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public Byte getSendMode() {
		return sendMode;
	}

	public void setSendMode(Byte sendMode) {
		this.sendMode = sendMode;
	}

	public Byte getMsgSrc() {
		return msgSrc;
	}

	public void setMsgSrc(Byte msgSrc) {
		this.msgSrc = msgSrc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Byte getSendState() {
		return sendState;
	}

	public void setSendState(Byte sendState) {
		this.sendState = sendState;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BroadcastMessage [getMsgId()=" + getMsgId()
				+ ", getSenderId()=" + getSenderId() + ", getTargetId()="
				+ getTargetId() + ", getSendMode()=" + getSendMode()
				+ ", getMsgSrc()=" + getMsgSrc() + ", getTitle()=" + getTitle()
				+ ", getContents()=" + getContents() + ", getSendDate()="
				+ getSendDate() + ", getSerialNum()=" + getSerialNum()
				+ ", getSendState()=" + getSendState() + ", getErrorCode()="
				+ getErrorCode() + ", toString()=" + super.toString() + "]";
	}
}
