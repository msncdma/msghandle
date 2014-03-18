package com.anlong.msghandle.vo;


/**
 * @Title: UserMessage.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:42:05 
 * @version V1.0   
 * @Description: 互动消息实体类,用于参数传递
 */
public class UserMessage {
	/** 消息Id */
	private Integer msgId;
	/** 发送者ID */
	private Integer senderId;
	/** 目标ID 对应用户ID或者群组ID */
	private Integer targetId;
	/** 1个人 2机构 3互动 */
	private Byte sendType;
	/** 1互动 2文件 3移动OA */
	private Byte msgType;
	/** 1客户端接收 2离线发短信 3发短信 */
	private Byte sendMode;
	/** 信息来源 */
	private Byte msgSrc;
	/** 信息标题 */
	private String title;
	/** 信息内容 */
	private String contents;
	/** 字体#颜色#字号 */
	private String style;
	/** 图片表示 0未上传完成 1上传完成 */
	private Byte picFlag;
	/** 发送时间 */
	private String sendDate;
	/** 流水号 */
	private String serialNum;
	/** 发送状态 */
	private Byte sendState;
	/** 接收状态 */
	private Integer receiveState;
	/** 错误编码 */
	private String errorCode;
	/** 业务编号，OA协同用 */
	private String bizCode;
	/** 连接地址 */
	private String linkAddr;

	private String[] fieldArr = { "msgId", "senderId", "targetId", "sendType",
			"msgType", "sendMode", "msgSrc", "title", "contents", "style",
			"picFlag", "sendDate", "serialNum", "sendState", "receiveState",
			"errorCode", "bizCode", "linkAddr" };

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

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public Byte getSendType() {
		return sendType;
	}

	public void setSendType(Byte sendType) {
		this.sendType = sendType;
	}

	public Byte getMsgType() {
		return msgType;
	}

	public void setMsgType(Byte msgType) {
		this.msgType = msgType;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Byte getPicFlag() {
		return picFlag;
	}

	public void setPicFlag(Byte picFlag) {
		this.picFlag = picFlag;
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

	public Integer getReceiveState() {
		return receiveState;
	}

	public void setReceiveState(Integer receiveState) {
		this.receiveState = receiveState;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getLinkAddr() {
		return linkAddr;
	}

	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
	}

	@Override
	public String toString() {
		return "UserMessage [msgId=" + msgId + ", senderId=" + senderId
				+ ", targetId=" + targetId + ", sendType=" + sendType
				+ ", msgType=" + msgType + ", sendMode=" + sendMode
				+ ", msgSrc=" + msgSrc + ", title=" + title + ", contents="
				+ contents + ", style=" + style + ", picFlag=" + picFlag
				+ ", sendDate=" + sendDate + ", serialNum=" + serialNum
				+ ", sendState=" + sendState + ", receiveState=" + receiveState
				+ ", errorCode=" + errorCode + ", bizCode=" + bizCode
				+ ", linkAddr=" + linkAddr + "]";
	}

}
