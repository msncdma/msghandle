package com.anlong.msghandle.vo;


/**
 * @Title: UserInfo.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:41:33 
 * @version V1.0   
 * @Description: 用户信息
 */
public class UserInfo {
	private Integer userId;
	private Integer depId;	
	private Byte userType;	
	private Byte onlineState;	
	private String userName;	
	private String name;	
	private String headUrl;	
	private String signaturel;	
	private Byte sex;	
	private String birthday;	
	private String mobile;	
	private String telephone;	
	private String qq;	
	private String email;	
	private String msn;	
	private Integer smsBalance;	
	private Integer mmsBalance;	
	private String position;	
	private String job;	
	

	private String[] fieldArr = { "userId", "depId", "userType", "onlineState",
			"userName", "name", "headUrl", "signaturel", "sex", "birthday","mobile",
			"telephone", "qq", "email","msn","smsBalance","mmsBalance","position","job"};


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getDepId() {
		return depId;
	}


	public void setDepId(Integer depId) {
		this.depId = depId;
	}


	public Byte getUserType() {
		return userType;
	}


	public void setUserType(Byte userType) {
		this.userType = userType;
	}


	public Byte getOnlineState() {
		return onlineState;
	}


	public void setOnlineState(Byte onlineState) {
		this.onlineState = onlineState;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHeadUrl() {
		return headUrl;
	}


	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}


	public String getSignaturel() {
		return signaturel;
	}


	public void setSignaturel(String signaturel) {
		this.signaturel = signaturel;
	}


	public Byte getSex() {
		return sex;
	}


	public void setSex(Byte sex) {
		this.sex = sex;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMsn() {
		return msn;
	}


	public void setMsn(String msn) {
		this.msn = msn;
	}


	public Integer getSmsBalance() {
		return smsBalance;
	}


	public void setSmsBalance(Integer smsBalance) {
		this.smsBalance = smsBalance;
	}


	public Integer getMmsBalance() {
		return mmsBalance;
	}


	public void setMmsBalance(Integer mmsBalance) {
		this.mmsBalance = mmsBalance;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}
	
}
