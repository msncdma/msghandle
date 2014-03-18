package com.anlong.msghandle.interfac;

import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.request.Request101;
import com.anlong.msghandle.request.Request102;
import com.anlong.msghandle.request.Request103;
import com.anlong.msghandle.request.Request105;
import com.anlong.msghandle.request.Request110;
import com.anlong.msghandle.request.Request203;

/**
 * @ClassName: MsgHandle 
 * @Package: com.anlong.imsghandle
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 企业快快后台网络处理消息请求接口
 * @author anlong 
 * @date 2013-6-1 下午1:38:24 
 * @version V1.0
 */
public interface MsgHandle {
	
	/** 身份验证 */
	public abstract void execute(Request101 request101) throws Exception;

	/** 更改在线状态*/
	public abstract void execute(Request102 request102) throws Exception;
	
	/** 心跳 */
	public abstract void execute(Request103 request103) throws Exception;
	
	/** 更改密码 */
	//public abstract void execute(Request104 request104) throws Exception;
	
	/** 获取用户信息 */
	public abstract void execute(Request105 request105) throws Exception;
	
	/** 获取用户列表 */
	//public abstract void execute(Request106 request106) throws Exception;
	
	/** 获取机构列表 */
	//public abstract void execute(Request107 request107) throws Exception;
	
	/** 获取群组信息 */
	//public abstract void execute(Request108 request108) throws Exception;
	
	/** 获取群列表信息 */
	//public abstract void execute(Request109 request109) throws Exception;
	
	/** 获取在线用户 */
	public abstract void execute(Request110 request110) throws Exception;
	
	/** 创建/更新群组 */
	//public abstract void execute(Request111 request111) throws Exception;
	
	/** 添加/删除群成员 */
	//public abstract void execute(Request112 request112) throws Exception;
	
	/** 退出或屏蔽群组 */
	//public abstract void execute(Request113 request113) throws Exception;
	
	/** 更改用户资料 */
	//public abstract void execute(Request114 request114) throws Exception;
	
	/** 同步常用联系人 */
	//public abstract void execute(Request115 request115) throws Exception;
	
	/** 快速定位 */
	//public abstract void execute(Request116 request116) throws Exception;
	
	/** 获取未读消息 */
	//public abstract void execute(Request201 request201) throws Exception;
	
	/** 获取历史记录 */
	//public abstract void execute(Request202 request202) throws Exception;
	
	/** 发送消息 */
	public abstract void execute(Request203 request203) throws Exception;
	
	/** 回执和状态报告查询 */
	//public abstract void execute(Request204 request204) throws Exception;
	
	/** 广播消息 */
	//public abstract void execute(Request205 request205) throws Exception;

	/** 获取系统参数 */
	//public abstract void execute(Request401 request401) throws Exception;
	
	/** 应用广场参数 */
	//public abstract void execute(Request402 request402) throws Exception;
	
	/** 鉴权接口 */
	//public abstract void execute(Request501 request501) throws Exception;
	
	/** 图片文件发送 */
	public abstract void execute(Request100 request100) throws Exception;
	
	/** 群组文件共享*/
	//public abstract void execute(Request117 request117) throws Exception;
	
	/** app应用信息回执*/
	//public abstract void execute(Request207 request207) throws Exception;
	
}
