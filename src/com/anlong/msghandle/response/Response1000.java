package com.anlong.msghandle.response;


/** 
 * @ClassName: Response1010 
 * @Package: 
 * @company ShenZhen anlongs Technology CO.,LTD.  
 * @Description: TODO 发送图片文件图片响应类
 * @author anlong 
 * @date 2013-4-24 下午3:52:46 
 * @version V1.0
 */
public class Response1000 {
	/**类型*/ 
	private Integer SendType;
	/**流水号*/ 
	private String fileCode;
	/**文件大小*/ 
	private Integer fileSize;
	/**
	 * 图片类型：1-聊天图片,2-个人头像,3-群组头像
	 */
	private Byte imageType;
	/**应答代码*/
	private Short rtCode;
	/**错误信息*/
	private String rtMsg;
	
	
	private String[] fieldArr = {"SendType","fileCode","fileSize","imageType","rtCode","rtMsg"};

	public Integer getSendType() {
		return SendType;
	}

	public void setSendType(Integer sendType) {
		SendType = sendType;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
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

	public Byte getImageType() {
		return imageType;
	}

	public void setImageType(Byte imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "Response1000 [getSendType()=" + getSendType()
				+ ", getFileCode()=" + getFileCode() + ", getFileSize()="
				+ getFileSize() + ", getRtCode()=" + getRtCode()
				+ ", getRtMsg()=" + getRtMsg() + ", getImageType()="
				+ getImageType() + "]";
	}

}
