package com.anlong.msghandle.request;

/**
 * @Title: Request102.java 
 * @Package com.anlong.msghandle.request
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:12:54 
 * @version V1.0   
 * @Description: 更改状态请求接入参数对象
 */
public class Request102 extends BaseRequest {
	/**
	 * 在线状态 0退出 1 在线 2忙碌 3离开 4隐身
	 */
	private Byte onlineState;
	/**
	 * 在线方式 1－IM客户端在线； 2－WEB网页在线； 3－手机WAP在线； 4－苹果手机IM； 5－安卓手机IM； 6－移动OA；
	 */
	private Byte loginType;
	
	private String[] fieldArr = {"onlineState","loginType"};

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
		return "EI102 [onlineState=" + onlineState + ", loginType=" + loginType + ", toString()="
				+ super.toString() + "]";
	}

}
