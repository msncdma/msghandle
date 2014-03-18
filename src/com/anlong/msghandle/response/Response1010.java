package com.anlong.msghandle.response;

import com.anlong.msghandle.vo.UserInfo;


/**
 * @Title: Response1010.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:56:59 
 * @version V1.0   
 * @Description: 用户登录验证
 */
public class Response1010 extends BaseResponse {
	// 密钥
	private Integer token;
	// 返回服务器时间
	private String dateTime;
	// 用户基础类型
	private UserInfo userInfo;

	private String[] fieldArr = { "token", "dateTime", "userInfo" };

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Response1010 [getToken()=" + getToken() + ", getDateTime()="
				+ getDateTime() + ", getUserInfo()=" + getUserInfo()
				+ ", toString()=" + super.toString() + "]";
	}

}
