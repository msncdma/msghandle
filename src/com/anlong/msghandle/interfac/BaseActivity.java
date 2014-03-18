package com.anlong.msghandle.interfac;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import com.anlong.msghandle.event.MessageEvent;
import com.anlong.msghandle.event.MessageEventListener;

@SuppressLint("NewApi")
public class BaseActivity extends Activity implements MessageEventListener{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	// 注册连接服务器监听
        // MessageEventSource.getSingleton().addLinstener(HandleStaticValue.BCODE1000, this);
    }
    
 

	@Override
	public void handleMessageEvent(MessageEvent event) {
		// TODO Auto-generated method stub
		//IMLog.anlong(" 1000 message event :" + event.getMessage() + " , bCode:" + event.getbCode());
	}
    
}
