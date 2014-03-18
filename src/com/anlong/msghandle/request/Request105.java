package com.anlong.msghandle.request;

/**
 * @Title: Request105.java 
 * @Package com.anlong.msghandle.request
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:13:41 
 * @version V1.0   
 * @Description: 获取用户信息请求接入参数对象
 */
public class Request105 extends BaseRequest{
	/** 目标ID */
	private Integer userId;

	private String[] fieldArr = {"userId"};
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "EI105 [userId=" + userId + ", toString()="
				+ super.toString() + "]";
	}

}
