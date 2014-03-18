package com.anlong.msghandle.response;

import com.anlong.msghandle.vo.UserInfo;


/**
 * @Title: Response1050.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:59:00 
 * @version V1.0   
 * @Description: 用户信息
 */
public class Response1050 extends BaseResponse {
	/** 自定义用户对象 */
	private UserInfo userInfo;

	private String[] fieldArr = {"userInfo"};
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Response1050 [userInfo=" + userInfo + "]";
	}

}
