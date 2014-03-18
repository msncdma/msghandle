package com.anlong.msghandle.vo;


/**
 * @Title: OnlineUser.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:40:41 
 * @version V1.0   
 * @Description: 在线用户封装类,用于在线用户内存管理
 */
public class OnlineUser {
	/** 用户ID */
	private Integer userId;
	/** 在线方式 : 
	 * 1－IM客户端在线；
	 * 2－手机WAP在线；
	 * 3－WEB网页在线；
	 * 4－苹果手机IM；
	 * 5－安卓手机IM；
	 * 81－手机短信上行；
	 * 91－移动OA；*/
	private Byte onlineType;
	
	private String[] fieldArr = {"userId","onlineType"};

	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Byte getOnlineType() {
		return onlineType;
	}


	public void setOnlineType(Byte onlineType) {
		this.onlineType = onlineType;
	}


	@Override
	public String toString() {
		return "OnlineUser [userId=" + userId + ", onlineType=" + onlineType + "]";
	}

}
