package com.anlong.msghandle.vo;

/**
 * @Title: AppMessage.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:38:34 
 * @version V1.0   
 * @Description: TODO
 */
public class AppMessage {
	/**消息Id**/
	private Integer msgId;
	/**发送者ID**/
	private String senderId;
	/**目标ID  (1&2&3&4)**/
	private String targetId;	

	/**消息发送模式1客户端接收 2离线发短信 3互动发短信 4广播发短信**/
	private Byte sendMode;
	/**消息发送模式1客户端接收 2离线发短信 3互动发短信 4广播发短信**/
	private Byte msgSrc;
	/**信息标题**/
	private String title;
	/**信息内容**/
	private String contents;
	/**字体#颜色#字号**/
	private String style;
	/**发送时间**/
	private String sendDate;
	/**消息流水号(每条消息的唯一标识，针对同一消息的多次操作。 如OA中推送同一协同多人处理的状态消息)**/
	private String msgSerial;
	/**请求流水号(每次请求生成唯一标识)**/
	private String reqSerial;
	/**发送状态与msgSrc对应，每个应用对应一套独立的状态例 OA应用消息：0-无状态1-待办2-已办催**/
	private Byte msgState;
	/**接地址**/
	private String linkAddr;
	/**短信消息(独立发短信的内容，该内容为空时发送contents)**/
	private String mobileMsg;

	private String[] fieldArr = { "msgId", "senderId", "targetId", "sendMode",
			"msgSrc", "title", "contents", "style", "sendDate","msgSerial",
			"reqSerial", "msgState", "linkAddr", "mobileMsg" };

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getMsgSerial() {
		return msgSerial;
	}

	public void setMsgSerial(String msgSerial) {
		this.msgSerial = msgSerial;
	}

	public String getReqSerial() {
		return reqSerial;
	}

	public void setReqSerial(String reqSerial) {
		this.reqSerial = reqSerial;
	}

	public Byte getMsgState() {
		return msgState;
	}

	public void setMsgState(Byte msgState) {
		this.msgState = msgState;
	}

	public String getLinkAddr() {
		return linkAddr;
	}

	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
	}

	public String getMobileMsg() {
		return mobileMsg;
	}

	public void setMobileMsg(String mobileMsg) {
		this.mobileMsg = mobileMsg;
	}



	@Override
	public String toString() {
		return "AppMessage [getMsgId()=" + getMsgId() + ", getSenderId()="
				+ getSenderId() + ", getTargetId()=" + getTargetId()
				+ ", getSendMode()=" + getSendMode() + ", getMsgSrc()="
				+ getMsgSrc() + ", getTitle()=" + getTitle()
				+ ", getContents()=" + getContents() + ", getStyle()=" + getStyle()
				+ ", getSendDate()=" + getSendDate() + ", getMsgSerial()="
				+ getMsgSerial() + ", getReqSerial()=" + getReqSerial()
				+ ", getMsgState()=" + getMsgState() + ", getLinkAddr()="
				+ getLinkAddr() + ", getMobileMsg()=" + getMobileMsg()
				+ ", toString()="
				+ super.toString() + "]";
	}

}
