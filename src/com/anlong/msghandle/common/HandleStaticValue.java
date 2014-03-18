package com.anlong.msghandle.common;

/**
 * @ClassName: HandleStaticValue 
 * @Package: com.anlong.imsghandle.common
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 全局静态变量管理类
 * @author anlong 
 * @date 2013-6-1 下午1:47:37 
 * @version V1.0
 */
public class HandleStaticValue {
	// 网络IP及端口号
	public static String SERVER_IP = "";
	public static int SERVER_PORT = 0;
	
	/** 保存消息中心IP的key  */
	public static final String SHAREDPREFERENCES_KEY_SERVER_IP="SHAREDPREFERENCES_KEY_SERVER_IP";
	/** 保存端口的key */
	public static final String SHAREDPREFERENCES_KEY_SERVER_PORT="SHAREDPREFERENCES_KEY_SERVER_PORT";
	/** 保存消息中心IP的配置文件  */
	public static final String SHAREDPREFERENCES_im_sharedfile_ipinfo="im_sharedfile_ipinfo";
	
	// 协议字符串编码
	public static final String CHARSET_NAME = "UTF-8";
	// 协议长度占用字节数
	public static final int PROTOCOL_SIZE = 4;
	// 协议响应参数包路径
	public static final String RESPONSE_PACKEAGE = "com.anlong.imsghandle.response";
	// 协议请求自定义对象路径
	public static final String RESPONSE_VO = "com.anlong.imsghandle.vo";
	// 系统打印
	public static final String PRINT_FLAG = "IMsgHandle[anlong]";
	// 上传图片
	public static final byte FILE_UPLOAD_IMAGE_TYPE = 3;
	// 服务器连接超时20'
	public static final int SERVER_CONNECTION_TIMEOUT = 20000;
	// 消息响应超时30'
	public static final int MESSAGE_RESPONSE_TIMEOUT = 30000;
	/**Socket连接超时5秒*/ 
	public static final int SOCKET_TIMEOUT = 10000;
	
	
	 // 各接口响应代码
	 /** 身份验证*/
	 public static final Short BCODE1010 = 1010;
	 public static final Short BCODE1020 = 1020;
	 /** 心跳*/
	 public static final Short BCODE1030 = 1030;
	 /** 更改密码*/
	 public static final Short BCODE1040 = 1040;
	 /** 获取用户信息*/
	 public static final Short BCODE1050 = 1050;
	 /** 获取用户列表*/
	 public static final Short BCODE1060 = 1060;
	 /** 获取机构列表*/
	 public static final Short BCODE1070 = 1070;
	 /** 获取群组信息*/
	 public static final Short BCODE1080 = 1080;
	 /** 获取群列表信息*/
	 public static final Short BCODE1090 = 1090;
	 /** 获取在线用户*/
	 public static final Short BCODE1100 = 1100;
	 /** 创建/更新群组*/
	 public static final Short BCODE1110 = 1110;
	 /** 添加/删除群成员*/
	 public static final Short BCODE1120 = 1120;
	 /** 退出或屏蔽群组*/
	 public static final Short BCODE1130 = 1130;
	 /** 更改用户资料信息*/
	 public static final Short BCODE1140 = 1140; 
	 /** 同步常用联系人*/
	 public static final Short BCODE1150 = 1150; 
	 /** 快速定位*/
	 public static final Short BCODE1160 = 1160; 
	 /** 群文件共享*/
	 public static final Short BCODE1170 = 1170; 
	 
	 /** 获取未读消息*/
	 public static final Short BCODE2010 = 2010; 
	 /** 获取历史记录*/
	 public static final Short BCODE2020 = 2020; 
	 /** 发送消息*/
	 public static final Short BCODE2030 = 2030; 
	 /** 回执和状态报告查询*/
	 public static final Short BCODE2040 = 2040; 
	 /** 广播消息*/
	 public static final Short BCODE2050 = 2050; 
	 /** 获取系统参数*/
	 public static final Short BCODE4010 = 4010; 
	 /** 应用广场参数*/
	 public static final Short BCODE4020 = 4020; 
	 /** 文件待接收*/
	 public static final Short BCODE3010 = 3010; 
	 /** 文件确认接收*/
	 public static final Short BCODE3020 = 3020; 
	 /** 鉴权接口*/
	 public static final Short BCODE5010 = 5010; 
	 
	 /** 获取app消息接口*/
	 public static final Short BCODE2060 = 2060; 
	 
	 /** 应用发送消息响应*/
	 public static final Short BCODE2070 = 2070;
	 
	 // 各接口请求代码
	 /** 身份验证*/
	 public static final Short BCODE101 = 101;
	 /** 更改在线状态*/
	 public static final Short BCODE102 = 102;
	 /** 心跳*/
	 public static final Short BCODE103 = 103;
	 /** 更改密码*/
	 public static final Short BCODE104 = 104;
	 /** 获取用户信息*/
	 public static final Short BCODE105 = 105;
	 /** 获取用户列表*/
	 public static final Short BCODE106 = 106;
	 /** 获取机构列表*/
	 public static final Short BCODE107 = 107;
	 /** 获取群组信息*/
	 public static final Short BCODE108 = 108;
	 /** 获取群列表信息*/
	 public static final Short BCODE109 = 109;
	 /** 获取在线用户*/
	 public static final Short BCODE110 = 110;
	 /** 创建/更新群组*/
	 public static final Short BCODE111 = 111;
	 /** 添加/删除群成员*/
	 public static final Short BCODE112 = 112;
	 /** 退出或屏蔽群组*/
	 public static final Short BCODE113 = 113;
	 /** 更改用户资料信息*/
	 public static final Short BCODE114 = 114; 
	 /** 同步常用联系人*/
	 public static final Short BCODE115 = 115; 
	 /** 快速定位*/
	 public static final Short BCODE116 = 116; 
	 /** 群文件共享*/
	 public static final Short BCODE117 = 117; 
	 
	 /** 获取未读消息*/
	 public static final Short BCODE201 = 201; 
	 /** 获取历史记录*/
	 public static final Short BCODE202 = 202; 
	 /** 发送消息*/
	 public static final Short BCODE203 = 203; 
	 /** 回执和状态报告查询*/
	 public static final Short BCODE204 = 204; 
	 /** 广播消息*/
	 public static final Short BCODE205 = 205; 
	 /** 更改用户资料信息*/
	 public static final Short BCODE401 = 401; 
	 /** 应用广场参数*/
	 public static final Short BCODE402 = 402; 
	 /** 文件待接收*/
	 public static final Short BCODE301 = 301; 
	 /** 文件确认接收*/
	 public static final Short BCODE302 = 302; 
	 /** 鉴权接口*/
	 public static final Short BCODE501 = 501; 
	 
	 /** 应用消息回执接口*/
	 public static final Short BCODE207 = 207; 
	 
	 // 系统代码 (1000-1009)
	 /** Socket连接异常*/
	 public static final short BCODE1000 = 1000;
	 /** Socket连接成功*/
	 public static final short BCODE1001 = 1001;
	 /** 图片文件发送是否成功*/
	 public static final short BCODE1002 = 1002;
	 /** 消息响应超时*/
	 public static final short BCODE1003 = 1003;
	 

	 
	 /** 用户登录方式 安卓手机 */
	 public static final Byte LOGINTYPE_ANDROID = 5;
}
