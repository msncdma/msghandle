package com.anlong.msghandle.request;


/**
 * @Title: Request110.java 
 * @Package com.anlong.msghandle.request
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:14:00 
 * @version V1.0   
 * @Description: 获取在线用户请求接入参数对象
 */
public class Request110 extends BaseRequest {
	/** 机构ID */
	private Integer depId;

	private String[] fieldArr = {"depId"};
	
	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	@Override
	public String toString() {
		return "Request110 [depId=" + depId + ", toString()="
				+ super.toString() + "]";
	}
}
