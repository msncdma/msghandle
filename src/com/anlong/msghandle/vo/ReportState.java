package com.anlong.msghandle.vo;

/**
 * @Title: ReportState.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:40:58 
 * @version V1.0   
 * @Description: 状态报告实体类,用于参数传递
 */
public class ReportState {
	/**
	 * 发送类型 1－个人；2－机构；3－互动群；4-广播群 5-临时群。
	 */
	private Integer sendType;
	/** 目标ID */
	private Integer targetId;
	/** 流水号 */
	private String serialNum;
	/**
	 * 最后一位代表发送给手机的状态 剩余位代表发送给客户端的状态 客户端每位数字具体含义： "1"表示PC客户端IM接收 "2"表示WAPIM接收
	 * "3"表示WEBIM接收 …… "98"表示已发送 "99"表示不发送 手机每位数字具体含义： "0"表示已发送 "1"表示发送成功
	 * "2"表示发送失败 "9"表示不发送
	 */
	private Short receiveType;
	/** 错误码 */
	private String errorCode;
	
	private String[] fieldArr = {"sendType","targetId","serialNum","receiveType","errorCode"};

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Short getReceiveType() {
		return receiveType;
	}

	public void setReceiveType(Short receiveType) {
		this.receiveType = receiveType;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
