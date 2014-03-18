package com.anlong.msghandle.response;

import java.util.List;

import com.anlong.msghandle.vo.OnlineUser;

 /**
 * @Title: Response1100.java 
 * @Package com.anlong.msghandle.response
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午4:59:29 
 * @version V1.0   
 * @Description: 在线用户列表
 */
class Response1100 extends BaseResponse {
	
	/** 机构ID */
	private Integer depId;
	
	/** 在线用户ID集合 */
	private List<OnlineUser> onlineList;

	private String[] fieldArr = {"depId","onlineList"};
	
	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public List<OnlineUser> getOnlineList() {
		return onlineList;
	}

	public void setOnlineList(List<OnlineUser> onlineList) {
		this.onlineList = onlineList;
	}

	@Override
	public String toString() {
		return "Response1100 [getDepId()=" + getDepId() + ", getOnlineList()="
				+ getOnlineList() + ", toString()=" + super.toString() + "]";
	}

}
