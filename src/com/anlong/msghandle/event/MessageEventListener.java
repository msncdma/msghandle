package com.anlong.msghandle.event;

import java.util.EventListener;

/**
 * @ClassName: MessageEventListener 
 * @Package: com.anlong.imsghandle.event
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 事件监听接口
 * @author anlong 
 * @date 2013-4-26 下午7:43:05 
 * @version V1.0
 */
public interface MessageEventListener extends EventListener {
	/**
	 * @Title: handleMessageEvent 
	 * @Description: 
	 * TODO 服务器推送的消息事件 
	 * Listener Code Format:BCODEXXXX
	 * 
	 * TODO 服务器连接状态事件 
	 * 1-重连中,2-重连超时,3-网络服务器连接超时，请检查网络设置,4-IP地址或端口是无效的,5-连接成功
	 * @author anlong 
	 * @param @param event     
	 * @return void     
	 * @throws
	 */
	public void handleMessageEvent(MessageEvent event);
	
}
