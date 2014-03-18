package com.anlong.msghandle.vo;


/**
 * @Title: GroupShare.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:40:26 
 * @version V1.0   
 * @Description: 组群共享列表对象
 */
public class GroupShare {
	
	/** 共享ID */
	private Integer shareId;
	/** 文件名 */
	private String fileName;
	/** 有效期 */
	private String finishTime;
	/** 文件大小 */
	private Integer fileSize;
	/** 下载地址 */
	private String downLoadAddr;
	/** 上传用户ID */
	private Integer uploadUser;
	/** 上传时间 */
	private String uploadTime;
	
	private String[] fieldArr = {"shareId", "fileName","finishTime","fileSize","downLoadAddr","uploadUser","uploadTime"};
	
	public Integer getShareId() {
		return shareId;
	}

	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getDownLoadAddr() {
		return downLoadAddr;
	}

	public void setDownLoadAddr(String downLoadAddr) {
		this.downLoadAddr = downLoadAddr;
	}

	public Integer getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(Integer uploadUser) {
		this.uploadUser = uploadUser;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "GroupShare [getShareId()=" + getShareId() + ", getFileName()="
				+ getFileName() + ", getFinishTime()=" + getFinishTime()
				+ ", getFileSize()=" + getFileSize() + ", getDownLoadAddr()="
				+ getDownLoadAddr() + ", getUploadUser()=" + getUploadUser()
				+ ", getUploadTime()=" + getUploadTime() + ", toString()="
				+ super.toString() + "]";
	}

}
