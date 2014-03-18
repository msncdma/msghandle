package com.anlong.msghandle.event;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import android.util.Log;

/**
 * @ClassName: MessageEventSource 
 * @Package: com.anlong.imsghandle.event
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 定义事件源 
 * @author anlong 
 * @date 2013-4-26 下午7:40:19 
 * @version V1.0
 */
public class MessageEventSource {

	private static MessageEventSource instance ;

	private Map<Short, Vector<MessageEventListener>> msgMap = new HashMap<Short, Vector<MessageEventListener>>();

	public static MessageEventSource getSingleton(){
		if(instance == null){
			instance = new MessageEventSource();
		}
		return instance;
	}

	/**
	 * @Title: addLinstener 
	 * @Description: TODO 添加监听
	 * @author anlong 
	 * @param  bCode
	 * @param  listener     
	 * @return void     
	 * @throws
	 */
	public synchronized void addLinstener(Short bCode, MessageEventListener listener){
		Vector<MessageEventListener> vector = msgMap.get(bCode);
		if(null == vector){
			vector = new Vector<MessageEventListener>();
			msgMap.put(bCode, vector);
		}

		if(!vector.contains(listener)){
			vector.addElement(listener);
		}
	}

	/**
	 * @Title: removeLinstener 
	 * @Description: TODO 移除监听
	 * @author anlong 
	 * @param bCode
	 * @param listener     
	 * @return void     
	 * @throws
	 */
	public synchronized void removeLinstener(Short bCode, MessageEventListener listener){
		if(msgMap!=null){
			Vector<MessageEventListener> vector = msgMap.get(bCode);
			if(vector != null){
				vector.removeElement(listener);
			}
		}
	}

	/**
	 * @Title: removeLinstener 
	 * @Description: TODO 移除监听
	 * @author anlong 
	 * @param listener     
	 * @return void     
	 * @throws
	 */
	public synchronized void removeLinstener(MessageEventListener listener){
		if(msgMap!=null){
			Set<Short> keySet = msgMap.keySet();
			for (Short key : keySet) {
				Vector<MessageEventListener> vector = msgMap.get(key);
				vector.removeElement(listener);
			}
		}
	}

	/**
	 * @Title: removeAllListener 
	 * @Description: TODO 移除所有监听 
	 * @author anlong 
	 * @param      
	 * @return void     
	 * @throws
	 */
	public synchronized void removeAllListener(){
		if(msgMap!=null){
			msgMap.clear();
		}
	}


	/**
	 * @Title: dispatcherEvent 
	 * @Description: TODO 派发事件
	 * @author anlong 
	 * @param @param event     
	 * @return void     
	 * @throws
	 */
	public void notifyMessageEvent(MessageEvent event) throws Exception {
		try {
			if(event!=null&&msgMap!=null){
				Vector<MessageEventListener> vector=msgMap.get(event.getbCode());
				if(vector!=null){
					Enumeration<MessageEventListener> enumeration= vector.elements();
					MessageEventListener listener = null;
					while (enumeration.hasMoreElements()) { 
						listener = enumeration.nextElement();
						listener.handleMessageEvent(event);
					}
				}else{
					Log.e("MessageEventSource", "未找到监听："+event.getbCode()+" ");
				}
			}else{ 
				Log.e("MessageEventSource", "监听失效："+event.getbCode());
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
