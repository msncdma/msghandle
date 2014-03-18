package com.anlong.msghandle.vo;

/**
 * @Title: GroupInfo.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:40:08 
 * @version V1.0   
 * @Description: 组群基本信息实体类,用于参数传递
 */
public class GroupInfo {
	/** 群组ID */
	private Integer groupId;
	/** 群组名称 */
	private String groupName;
	/** 群主ID */
	private Integer groupMaster;
	/** 群组类型 */
	private Byte groupType;
	/** 群组公告 */
	private String announcement;
	/** 群组头像 */
	private String headUrl;
	/**是否接受消息*/
	private Byte receiveFlag;
	/**机构编码*/
	private Integer depId;
	
	private String[] fieldArr = {"groupId","groupName","groupMaster","groupType","announcement","headUrl","receiveFlag","depId"};

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupMaster() {
		return groupMaster;
	}

	public void setGroupMaster(Integer groupMaster) {
		this.groupMaster = groupMaster;
	}

	public Byte getGroupType() {
		return groupType;
	}

	public void setGroupType(Byte groupType) {
		this.groupType = groupType;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	} 
	
	public Byte getReceiveFlag() {
		return receiveFlag;
	}

	public void setReceiveFlag(Byte receiveFlag) {
		this.receiveFlag = receiveFlag;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "GroupInfo [getGroupId()=" + getGroupId() + ", getGroupName()="
				+ getGroupName() + ", getGroupMaster()=" + getGroupMaster()
				+ ", getGroupType()=" + getGroupType() + ", getAnnouncement()="
				+ getAnnouncement() + ", getHeadUrl()=" + getHeadUrl()
				+ ", getReceiveFlag()=" + getReceiveFlag() + ", getDepId()="
				+ getDepId() + ", toString()=" + super.toString() + "]";
	}

}
