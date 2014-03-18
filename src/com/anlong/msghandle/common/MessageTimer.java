package com.anlong.msghandle.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;

/**
 * @ClassName: MessageTimer 
 * @Package: com.anlong.imsghandle.common
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 消息请求响应计时器
 * @author anlong 
 * @date 2013-6-1 下午2:18:09 
 * @version V1.0
 */
public class MessageTimer extends HandleTimer implements Runnable {
	
	// 请求时间集合
	private static Map<String,Long> timeMap = new HashMap<String, Long>();
	// 请求KEY集合
	private static List<String> keyList = new ArrayList<String>();
	
	public MessageTimer(){}
	
	@Override
	public void run() {
		while (true) {
			// TODO 获取当前时间
			long endTime = System.currentTimeMillis();
			runTimerResult(endTime);
			try { 
				//TODO  线程睡眠1秒  防止线程占用CPU，2013年7月5日　陈思初修改
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void startTimer(String key, String bCode){
		// TODO 开始计算时间
		long startTime = System.currentTimeMillis();
		keyList.add(key);
		timeMap.put(key, startTime);
		IMLog.anlong("添加一个" + bCode+ "的消息响应计时器,流水号：" + key +", 一共"+ keyList.size() +" 个消息等待响应.");
	}
	
	@Override
	public void cancelTimer(String key){
		IMLog.anlong("已删除一个计时器,流水号：" + key);
		timeMap.remove(key);
		keyList.remove(key);
	}
	
	
	/**
	 * The difference between the two time
	 * @author anlong 
	 * @throws
	 */
	private void runTimerResult(long endTime){
		if(keyList == null || keyList.size() == 0)
			return ;
		if(timeMap == null || timeMap.size() == 0)
			return;
		
		for (int i = 1; i < keyList.size(); i++) {
			String key = keyList.get(i);
			if(Utils.isNull(key))
				continue;
			
			long startTime = timeMap.get(key);
			if(Utils.isNull(startTime)){
				continue;
			}

			if((endTime - startTime)>HandleStaticValue.MESSAGE_RESPONSE_TIMEOUT){
				cancelTimer(key);
				Utils.notifyMessage(key, HandleStaticValue.BCODE1003);
			}
		}
	}

}
