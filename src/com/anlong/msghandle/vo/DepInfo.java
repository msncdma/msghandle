package com.anlong.msghandle.vo;

/**
 * @Title: DepInfo.java 
 * @Package com.anlong.msghandle.vo
 * @company ShenZhen AnLong Technology CO.,LTD.   
 * @author lixl   
 * @date 2014-3-12 下午3:39:40 
 * @version V1.0   
 * @Description: 机构信息实体类,用于参数传递
 */
public class DepInfo {
	/** 机构ID */
	private Integer depId;
	/** 机构名称 */
	private String depName;
	/** 上级机构 */
	private Integer parentId;
	/** 短信余额 */
	private Integer smsBalance;
	/** 彩信余额 */
	private Integer mmsBalance;
	/** 1 增加 2 删除 3更新 */
	private Byte operateType;
	
	private String[] fieldArr = {"depId","depName","parentId","smsBalance","mmsBalance","operateType"};

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public Byte getOperateType() {
		return operateType;
	}

	public void setOperateType(Byte operateType) {
		this.operateType = operateType;
	}

	@Override
	public String toString() {
		return "DepInfo [depId=" + depId + ", depName=" + depName + ", parentId=" + parentId + ", smsBalance=" + smsBalance + ", mmsBalance="
				+ mmsBalance + ", operateType=" + operateType + "]";
	}

}
