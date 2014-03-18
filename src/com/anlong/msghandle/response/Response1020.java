package com.anlong.msghandle.response;


/**
 * @Title: Response1020.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:58:09 
 * @version V1.0   
 * @Description: 更改状态
 */
public class Response1020 extends BaseResponse {
	/** 用户ID */
	private Integer userId;
	/** 状态 0退出 1 在线 2忙碌 3离开 4隐身 */
	private Byte onlineState;
	/** 登录类型 1-PC 2-WebIM */
	private Byte loginType;
	
	private String[] fieldArr = {"userId","onlineState","loginType"};

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Byte getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Byte onlineState) {
		this.onlineState = onlineState;
	}

	public Byte getLoginType() {
		return loginType;
	}

	public void setLoginType(Byte loginType) {
		this.loginType = loginType;
	}

	@Override
	public String toString() {
		return "Response1020 [userId=" + userId + ", onlineState=" + onlineState + ", loginType=" + loginType + "]";
	}

}
