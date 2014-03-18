package com.anlong.msghandle.request;


/**
 * @Title: Request101.java 
 * @Package com.anlong.msghandle.request
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午5:12:30 
 * @version V1.0   
 * @Description: 登录账户验证请求接入参数对象
 */
public class Request101 extends BaseRequest {
	/**
	 * 用户帐号
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String passWord;

	/**
	 * 登录类型 1－IM客户端在线； 2－WEB网页在线； 3－手机WAP在线； 4－苹果手机IM； 5－安卓手机IM； 6－移动OA；
	 */
	private Byte loginType;
	/**
	 * 在线状态 1在线 2隐身
	 */
	private Byte onlineState;
	/**
	 * 登录状态
	 */
	private Byte loginState;
	/**
	 * 苹果登录标识
	 */
	private String apid;
	/**
	 * 登录IP
	 * */
	private String ipAddress;

	/**
	 * 用户折百MAC地址
	 * */
	private String macAddress;

	/**
	 * 备注信息（手机型号，网络制式，系统版本等）
	 * */
	private String remark;

	/**
	 * 企业编码
	 */
	private String corpCode;
	/**
	 * 客户端版本号
	 */
	private String clientVersion;

	private String[] fieldArr = { "userName", "passWord", 	
			"loginType", "onlineState", "loginState", "apid", "ipAddress", "macAddress", "remark", "corpCode",
	"clientVersion" };

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public Byte getLoginType() {
		return loginType;
	}

	public void setLoginType(Byte loginType) {
		this.loginType = loginType;
	}

	public Byte getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Byte onlineState) {
		this.onlineState = onlineState;
	}

	public Byte getLoginState() {
		return loginState;
	}

	public void setLoginState(Byte loginState) {
		this.loginState = loginState;
	}

	public String getApid() {
		return apid;
	}

	public void setApid(String apid) {
		this.apid = apid;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Request101 [getUserName()=" + getUserName()
				+ ", getPassWord()=" + getPassWord() +  ", getLoginType()=" + getLoginType()
				+ ", getOnlineState()=" + getOnlineState()
				+ ", getLoginState()=" + getLoginState() + ", getApid()="
				+ getApid() + ", getCorpCode()=" + getCorpCode()
				+ ", getClientVersion()=" + getClientVersion()
				+ ", getIpAddress()=" + getIpAddress() + ", getMacAddress()="
				+ getMacAddress() + ", getRemark()=" + getRemark()
				+ ", toString()=" + super.toString() + "]";
	}

}
