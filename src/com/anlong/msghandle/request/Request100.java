package com.anlong.msghandle.request;

/**
 * @ClassName: Request101
 * @Description: TODO 图片文件发送请求接入参数对象
 * @author anlong
 * @date 2013-4-2 下午4:48:03
 */

public class Request100 {
	/**
	 * 操作类型 1上传文件 2下载文件 3上传图片 4上传语音
	 */
	private Byte operateType;
	/**
	 * 文件编码
	 */
	private String fileCode;
	/**
	 * 文件格式
	 */
	private String fileType;
	/**
	 * 文件大小
	 */
	private Integer fileSize;
	/**
	 * 文件本地地址
	 */
	private String fileUrl;
	/**
	 * 发送类型
	 */
	private Integer sendType;
	/**
	 * 图片类型3：1-聊天图片,2-个人头像,3-群组头像 
	 * 语音类型4 1.个人语音 2.群组语音
	 */
	private Byte imageType;
	
	

	public Byte getOperateType() {
		return operateType;
	}

	public void setOperateType(Byte operateType) {
		this.operateType = operateType;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getSendType() {
		return sendType;
	}

	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}

	public Byte getImageType() {
		return imageType;
	}

	public void setImageType(Byte imageType) {
		this.imageType = imageType;
	}

	@Override
	public String toString() {
		return "Request100 [getOperateType()=" + getOperateType()
				+ ", getFileCode()=" + getFileCode() + ", getFileType()="
				+ getFileType() + ", getFileSize()=" + getFileSize()
				+ ", getFileUrl()=" + getFileUrl() + ", getSendType()="
				+ getSendType() + ", getImageType()=" + getImageType() + "]";
	}

}
