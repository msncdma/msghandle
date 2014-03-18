package com.anlong.msghandle.vo;

import java.util.Date;


/**
 * @Title: Application.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:38:24 
 * @version V1.0   
 * @Description: TODO
 */
public class Application {

	/** 应用ID */
	private Integer appId;
	/** 应用名称 */
	private String appName;
	/** 应用类型:1-APP,2-WEB应用（默认）,3-暂无有效应用 */
	private Byte appType;
	/** 1-应用状态:1集成应用，2默认应用，3 可选应用 */
	private Byte appState;
	/** 应用LOGO 应用的LOGO图片地址（80x80） */
	private String appLogo;
	/** 应用简介 */
	private String appProfile;
	/** 应用的WEB访问地址(对应应用的类型:2WEB应用) */
	private String webPath;
	/** 1-鉴权方式 1-无需鉴权;（默认）2-需求鉴权; */
	private Byte authType;
	/** 鉴权参数格式：“uid={1}&pwd={2}” **/
	private String authParam;
	/** 1-优先级 1-10的数字，数字越小排列越靠前 */
	private Byte priority;
	/** 应用最后更新的时间 **/
	private String updateTime;
	/** 应用的客户端存放地址 */
	private String clientPath;
	/** 客户端版本号（如1.0.0.6） */
	private String version;
	/** 客户端更新内容 */
	private String intro;
	/** 客户端上传日期 */
	private String uploadTime;
	/**
	 * 客户端用于判断本机是否已安装该软件的标识对应客户端类型 1:注册表名称 4:APP商店应用ID 5:android包名称
	 */
	private String uniqueKey;

	private String[] fieldArr = { "appId", "appName", "appType", "appState",
			"appLogo", "appProfile", "webPath", "authType", "authParam",
			"priority", "updateTime", "clientPath", "version", "intro",
			"uploadTime", "uniqueKey" };

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Byte getAppType() {
		return appType;
	}

	public void setAppType(Byte appType) {
		this.appType = appType;
	}

	public Byte getAppState() {
		return appState;
	}

	public void setAppState(Byte appState) {
		this.appState = appState;
	}

	public String getAppLogo() {
		return appLogo;
	}

	public void setAppLogo(String appLogo) {
		this.appLogo = appLogo;
	}

	public String getAppProfile() {
		return appProfile;
	}

	public void setAppProfile(String appProfile) {
		this.appProfile = appProfile;
	}

	public String getWebPath() {
		return webPath;
	}

	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}

	public Byte getAuthType() {
		return authType;
	}

	public void setAuthType(Byte authType) {
		this.authType = authType;
	}

	public String getAuthParam() {
		return authParam;
	}

	public void setAuthParam(String authParam) {
		this.authParam = authParam;
	}

	public Byte getPriority() {
		return priority;
	}

	public void setPriority(Byte priority) {
		this.priority = priority;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getClientPath() {
		return clientPath;
	}

	public void setClientPath(String clientPath) {
		this.clientPath = clientPath;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	@Override
	public String toString() {
		return "Application [getAppId()=" + getAppId() + ", getAppName()="
				+ getAppName() + ", getAppType()=" + getAppType()
				+ ", getAppState()=" + getAppState() + ", getAppLogo()="
				+ getAppLogo() + ", getAppProfile()=" + getAppProfile()
				+ ", getWebPath()=" + getWebPath() + ", getAuthType()="
				+ getAuthType() + ", getAuthParam()=" + getAuthParam()
				+ ", getPriority()=" + getPriority() + ", getUpdateTime()="
				+ getUpdateTime() + ", getClientPath()=" + getClientPath()
				+ ", getVersion()=" + getVersion() + ", getIntro()="
				+ getIntro() + ", getUploadTime()=" + getUploadTime()
				+ ", getUniqueKey()=" + getUniqueKey() + ", toString()="
				+ super.toString() + "]";
	}

}
