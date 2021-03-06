package com.anlong.msghandle.response;


/**
 * @Title: Response3010.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:04:11 
 * @version V1.0   
 * @Description: 文件待接收响应参数对象
 */
public class Response3010 extends BaseResponse {
	/** 发送类型 1个人发送 2群组发送 3机构发送 */
	private byte sendType;
	/** 发送人ID */
	private Integer sendId;
	/** 接收人ID */
	private Integer receiveId;
	/** 发送模式 1-在线发送 2-离线发送 */
	private Byte fileMode;
	/** 文件名称 */
	private String fileName;
	/** 文件编码 */
	private String fileCode;
	/** 文件大小 */
	private String fileSize;
	
	private String[] fieldArr = {"sendType","sendId","receiveId","fileMode","fileName","fileCode","fileSize"};

	public byte getSendType() {
		return sendType;
	}

	public void setSendType(byte sendType) {
		this.sendType = sendType;
	}

	public Integer getSendId() {
		return sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public Integer getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	public Byte getFileMode() {
		return fileMode;
	}

	public void setFileMode(Byte fileMode) {
		this.fileMode = fileMode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	@Override
	public String toString() {
		return "Response3010 [sendType=" + sendType + ", sendId=" + sendId + ", receiveId=" + receiveId + ", fileMode=" + fileMode + ", fileName="
				+ fileName + ", fileCode=" + fileCode + ", fileSize=" + fileSize + "]";
	}

}
