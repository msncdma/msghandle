package com.anlong.msghandle.interfac;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.anlong.msghandle.R;
import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.event.MessageEvent;
import com.anlong.msghandle.event.MessageEventListener;
import com.anlong.msghandle.event.MessageEventSource;
import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.request.Request101;
import com.anlong.msghandle.service.InitServerManager;
import com.anlong.msghandle.socket.InitFileSocketServer;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.vo.UserInfo;

@SuppressLint("NewApi")
public class MessageHandleActivity extends BaseActivity implements MessageEventListener{
	private Button sendMsg = null;
	private Button sendMsg2 = null;
	private Button sendMsg3 = null;
	private Button sendMsg4 = null;
	private MsgHandle handle = null;
	private InitServerManager initServerManager = null;
	 private final String IMAGE_TYPE = "image/*"; 
	 private final int IMAGE_CODE = 0;  
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_handle);
        sendMsg = (Button)findViewById(R.id.sendMsg);
        sendMsg2 = (Button)findViewById(R.id.sendMsg2);
        sendMsg3 = (Button)findViewById(R.id.sendMsg3);
        sendMsg4 = (Button)findViewById(R.id.sendMsg4);
        
        
        // 登陆服务器
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        
        IMLog.anlong("正在等待开启连接...");
        // 测试图片发送
        InitFileSocketServer.getInstance();
        
        IMLog.anlong("连接完毕!");
        
        // 注册更新群组监听
        MessageEventSource.getSingleton().addLinstener(HandleStaticValue.BCODE1010, this);
        MessageEventSource.getSingleton().addLinstener(HandleStaticValue.BCODE1070, this);
        MessageEventSource.getSingleton().addLinstener(HandleStaticValue.BCODE1002, this);
        
        // 点击获取机构信息
        sendMsg3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					
					handle = new AbstractMsgHandle();
					
					// 初始化网络   , 开启接收消息线程
					//initServerManager = new InitServerManagerImpl();
					//initServerManager.initMessageNet();
					//initServerManager.initReceiveMessageThread();
					
				/*	handle.execute(loadRequestObject3());*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
        
        
        // 点击按钮登录 初始化连接
        sendMsg.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 初始化网络   , 开启接收消息线程
				//initServerManager = new InitServerManagerImpl();
				//initServerManager.initMessageNet();
			}
		}); 
        
        // 点击发送消息按钮
        sendMsg2.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		try {
        			handle = new AbstractMsgHandle();
        			
        			// 测试发送消息2
        			handle.execute(loadRequestObject2());
        		} catch (Exception e) {
        			e.printStackTrace();
        		}
        	}
        });
        
        
        // 点击测试发送图片文件
        sendMsg4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					// 选择图片
					/*Intent getAlbum = new Intent(Intent.ACTION_GET_CONTENT);  
	                getAlbum.setType(IMAGE_TYPE);  
	                startActivityForResult(getAlbum, IMAGE_CODE);*/  
					
					/*new Thread(new Runnable(){
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							MsgHandle handle1 = new AbstractMsgHandle();
							handle = new AbstractMsgHandle();
							//String path = "/storage/sdcard0/CamDict/public/data/char/10390.png";
							String path = "/storage/sdcard0/企业快快 设计方案 0416/方案1/会话.png";
							try {
								handle1.execute(loadRequest100(path));
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}).start();*/
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
       
    }
    
    
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量  
            return;  
        }  
        Bitmap bm = null;  
        ContentResolver resolver = getContentResolver();          
        if (requestCode == IMAGE_CODE) {  
            try {  
            	//获得图片的uri   
                Uri originalUri = data.getData();        
                
                //显得到bitmap图片  
                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);        
               
                //这里开始的第二部分，获取图片的路径：   
                String[] proj = {MediaStore.Images.Media.DATA};          
                Cursor cursor = managedQuery(originalUri, proj, null, null, null);   
                //按我个人理解 这个是获得用户选择的图片的索引值   
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);             
                cursor.moveToFirst();  
                //最后根据索引值获取图片路径  
                String path = cursor.getString(column_index);  
                 
                
                MsgHandle handle1 = new AbstractMsgHandle();
                try {
                	//String path = "/storage/sdcard0/CamDict/public/data/char/10390.png";
					handle1.execute(loadRequest100(path));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }catch (IOException e) {  
  
                Log.e("Lostinai",e.toString());   
  
            }  
  
        }  
	}



	@Override
	public void handleMessageEvent(MessageEvent event) {
		IMLog.anlong(" MessageHandleActivity message event dep :" + event.getMessage() + " , bCode:" + event.getbCode());

		/*if ( event.getbCode() == 1070) {
			Response1070 r1070 = (Response1070)event.getMessage() ;
			IMLog.anlong(" 1120 message event dep :" + r1070.getDepList().size() + " , bCode:" + event.getbCode());
			IMLog.anlong(" 1120 message event user:" + r1070.getUserList().size() + " , bCode:" + event.getbCode());
		}*/ 
		if ( event.getbCode() == 1010 ) {
			IMLog.anlong(" 1010 message event dep :" + event.getMessage() + " , bCode:" + event.getbCode());
		}
	}
   
 
    public Request100 loadRequest100(String path){
    	Request100 request100 = new Request100();
    	request100.setOperateType(HandleStaticValue.FILE_UPLOAD_IMAGE_TYPE);
    	request100.setFileCode(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
    	request100.setFileSize(0);
    	IMLog.anlong("path: "+path);
    	IMLog.anlong("file type:"+path.substring(path.lastIndexOf(".")+1, path.length()));
    	request100.setFileType(path.substring(path.lastIndexOf(".")+1, path.length()));
    	request100.setFileUrl(path);
    	return request100;
    }
    
    // 线程
    class AsyncTry extends AsyncTask<String, Integer, Double>{

    	@Override
		protected void onPreExecute() {
			// TODO 任务执行之前调用
			super.onPreExecute();
		}
    	
		@Override
		protected Double doInBackground(String... params) {
			// TODO 调用Socket获取写入流和读取流
			return null;
		}
    	
		@Override
		protected void onPostExecute(Double result) {
			// TODO 返回处理结果
			super.onPostExecute(result);
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO 显示执行任务的进度
			super.onProgressUpdate(values);
		}
		
		@Override
		protected void onCancelled() {
			// TODO 取消线程操作调用
			super.onCancelled();
		}
    }
    
   /* public Request107 loadRequestObject3(){
    	// 机构请求接口
    	Request107 request107 = new Request107();
    	request107.setMsgSize(0);
    	request107.setBCode((short) 107);
    	request107.setKey(19810191);
    	request107.setUid(123457);
    	request107.setApId((byte) 0);
    	
    	request107.setDepId(0);
    	request107.setUpdateTime("");
    	
    	return request107;
    }*/

    public Request101 loadRequestObject2(){
    	// 删除/添加群成员请求接口
    	Request101 request101 = new Request101();
    	request101.setMsgSize(0);
    	request101.setBCode((short) 101);
    	request101.setKey(19810191);
    	request101.setUid(123457);
    	request101.setApId((byte) 4);
		
    	// 用户帐号
    	request101.setUserName("anlong");
    	// 用户密码
    	request101.setPassWord("123456");
    	// 登录IP  
//    	request101.setIpaddress("192.168.2.117");
    	// 登录类型   1－IM客户端在线； 2－WEB网页在线； 3－手机WAP在线； 4－苹果手机IM； 5－安卓手机IM； 6－移动OA；
    	request101.setLoginType((byte) 5);
    	// 在线状态   1在线  2隐身
    	request101.setOnlineState((byte) 1);
    	// 登录状态
    	request101.setLoginState((byte) 0);
    	// 苹果登录标识
    	request101.setApid("");
    	// 企业编码
    	request101.setCorpCode("10000");
		
		return request101;
    }
    
    /*public Request112 loadRequestObject(){
    	// 删除/添加群成员请求接口
		Request112 request112 = new Request112();
		request112.setMsgSize(0);
		request112.setBCode((short) 112);
		request112.setKey(19810191);
		request112.setUid(123456);
		request112.setApId((byte) 0);
		
		//request112.setOperateType((byte) 1);// 1—添加成员 2—删除成员
		
		*//***
		// 测试基础类型集合
		List<Integer> userIdList = new ArrayList<Integer>();
		userIdList.add(11);
		userIdList.add(21);
		userIdList.add(31);
		userIdList.add(41);
		userIdList.add(51);
		request112.setUserIdList(userIdList);
		**//*
		
		// 测试对象类型集合
		List<UserInfo> userList = new ArrayList<UserInfo>();
		
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUserId(100060);
		userInfo1.setDepId(10018);
		userInfo1.setUserType((byte) 1); 
		userInfo1.setOnlineState((byte) 1);  
		userInfo1.setUserName("丁金奂");
		userInfo1.setName("anlong");
		userInfo1.setHeadUrl("http://www.baidu.com/head.jpg");
		userInfo1.setSignaturel("o(︶︿︶)o 唉");
		userInfo1.setSex((byte) 1);
		
		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUserId(100061);
		userInfo2.setDepId(10019);
		userInfo2.setUserType((byte) 1); 
		userInfo2.setOnlineState((byte) 1);  
		userInfo2.setUserName("苏东坡");
		userInfo2.setName("anlong");
		userInfo2.setHeadUrl("http://www.baidu.com/head.jpg");
		userInfo2.setSignaturel("大江东去...");
		userInfo2.setSex((byte) 1);
		
		userList.add(userInfo1);
		userList.add(userInfo2);
		//request112.setUserIdList(userList);
		
		return request112;
    }*/
	

    
}
