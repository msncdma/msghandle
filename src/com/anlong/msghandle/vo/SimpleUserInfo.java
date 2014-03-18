package com.anlong.msghandle.vo;

/**
 * @Title: SimpleUserInfo.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:41:16 
 * @version V1.0   
 * @Description: 简略用户信息封装实体类,用于参数传递
 */
public class SimpleUserInfo {
	/** 用户ID */
	private Integer userId;
	/** 用户名称 */
	private String userName;
	/** 所属机构ID */
	private Integer depId;
	/** 所属机构ID */
	private Byte sex;
	/** 在线状态 0不在线 1在线 2隐身 3忙碌 */
	private Byte onlineState;
	/** 头像地址 */
	private String headImg;
	/**手机号码*/
	private String mobile;
	/**个性签名*/
	private String signature;
	/** 1 增加 2 删除 3更新 */
	private Byte operateType;
	
	private String[] fieldArr = {"userId","userName","depId","sex","onlineState","headImg","mobile","signature","operateType"};

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Byte getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Byte onlineState) {
		this.onlineState = onlineState;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Byte getOperateType() {
		return operateType;
	}

	public void setOperateType(Byte operateType) {
		this.operateType = operateType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	@Override
	public String toString() {
		return "SimpleUserInfo [userId=" + userId + ", userName=" + userName + ", depId=" + depId + ", sex=" + sex + ", onlineState=" + onlineState
				+ ", headImg=" + headImg + ", operateType=" + operateType + "]";
	}

}
