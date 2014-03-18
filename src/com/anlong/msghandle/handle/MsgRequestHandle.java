package com.anlong.msghandle.handle;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.request.BaseRequest;
import com.anlong.msghandle.socket.InitMsgSocketServer;
import com.anlong.msghandle.util.ByteAndInt;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.ReflectionUtil;

/**
 * @ClassName: RequestHandle 
 * @Package: com.anlong.imsghandle.common
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO  请求消息处理 
 * @author anlong 
 * @date 2013-4-25 下午5:30:25 
 * @version V1.0
 */
public class MsgRequestHandle{
	private ByteArrayOutputStream byteOutputStream = null;
	private DataOutputStream  dataOutputStream = null;
	private static MsgRequestHandle instance = null;

	public MsgRequestHandle(){}
	
	public static MsgRequestHandle getInstance(){
		if ( instance == null )
			instance = new MsgRequestHandle();
		return instance;
	}
	
	
	/**
	 * @Title: encode 
	 * @Description: TODO 编码器
	 * @author anlong 
	 * @param request
	 * @param Exception     
	 * @throws
	 */
	public void encode(Object request) throws Exception {
		if(request instanceof BaseRequest){
			// TODO 获取输出流
			OutputStream outputStream = InitMsgSocketServer.getOutputStream(); 
			if (outputStream == null)
				return ;
			
			// 获取请求对象
			BaseRequest baseRequest=(BaseRequest)request;
			
			baseRequest.setMsgSerial(0);
			
			// 测试打印
			IMLog.anlong(baseRequest.toString());
			
			byteOutputStream = new ByteArrayOutputStream();
			dataOutputStream = new DataOutputStream(byteOutputStream);
			
			// TODO 装载消息头
			this.writeHead(baseRequest,dataOutputStream);		
			
			// TODO 封装协议体
			this.wirteData(request,dataOutputStream);
			
			byte[] buf = byteOutputStream.toByteArray();//获取内存缓冲区中的数据
			
			IMLog.anlong("[请求]报文体长度："+buf.length);
			
			byte[] buff = toHH( buf.length );
			for ( int i = 0 ; i < 4 ; i++ ){
				buf[i] = buff[i];
			}
			
			dataOutputStream.close();					
			byteOutputStream.close();

			// TODO 发送字节流消息
			outputStream.write(buf);
			outputStream.flush();
			IMLog.anlong("请求报文已成功发送!");
		} else {
			IMLog.anlong("请求对象封装错误");
		}
     			
	}
	
	/**
	* @Title: setRequestDataHead 
	* @Description: TODO 封装请求数据头
	* @author anlong 
	* @param @param dataOutputStream
	* @param @param baseMessage
	* @param @return
	* @param @throws IOException    设定文件 
	* @return DataOutputStream    返回类型 
	* @throws
	*/
	public void writeHead(BaseRequest baseRequest, DataOutputStream dataOutputStream) throws IOException {
		// 写入包头协议总大小 ,字节4
		dataOutputStream.writeInt(baseRequest.getMsgSize());	
		// 写入包头业务编码 ,字节4 
		dataOutputStream.writeShort(baseRequest.getBCode()); 		
		// 写入包头密钥 ,字节4 
		dataOutputStream.writeInt(baseRequest.getKey());	
		// 写入包头用户ID,字节4
		dataOutputStream.writeInt(baseRequest.getUid());	
		// 消息来源
		dataOutputStream.writeByte(baseRequest.getApId());
		// 消息流水号
		dataOutputStream.writeInt(baseRequest.getMsgSerial());
	}
	
	/**
	* @Title: WriteValue 
	* @Description: TODO  写入IO数据流
	* @author anlong 
	* @param @param obj    设定文件 
	* @return void    返回类型 
	* @throws
	*/
	@SuppressWarnings({ "unchecked" })
	private void wirteData(Object obj, DataOutputStream dataOutputStream){
		try {
			// 获取类属性数组
			Object instance = obj.getClass().newInstance();
			Field arrField = obj.getClass().getDeclaredField("fieldArr");
			arrField.setAccessible(true);
	    	String[] fieldList = (String[]) arrField.get(instance);
			
			// 属性类型
			String fieldType = null;
			// 首字母大写名称
			String fieldNameUpper = null;
			// 反射返回值
			Object result = null;
			
			for ( String fieldName : fieldList ) {
				Field field= obj.getClass().getDeclaredField(fieldName); 
				fieldType = field.getType().getSimpleName();
				
				fieldNameUpper = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
				result = ReflectionUtil.invokeMethod(obj, "get"+fieldNameUpper);
				
				if( fieldType.equals("Byte") ){   
					if ( result != null )
						dataOutputStream.writeByte((Byte)result);
					else 
						dataOutputStream.writeByte((byte) 0);
					
				} else if ( fieldType.equals("Short") ){
					if ( result != null ) 
						dataOutputStream.writeShort((Short)result);
					else 
						dataOutputStream.writeShort((short) 0);
					
				} else if ( fieldType.equals("Integer") ){
					if ( result != null )
						dataOutputStream.writeInt((Integer) result);
					else 
						dataOutputStream.writeInt(0);
						
				} else if ( fieldType.equals("String") ){
					if ( result != null ) { 
						String strResult = (String)result;
						byte[] byteArr = strResult.getBytes(HandleStaticValue.CHARSET_NAME);
						dataOutputStream.writeShort((short) byteArr.length);
						dataOutputStream.write(byteArr);
					} else {
						dataOutputStream.writeShort((short) 0);
					}
					
				} else if (fieldType.equals("List")){
					Type fc =  field.getGenericType(); 
					// 这里判断是泛型集合
					if( fc instanceof ParameterizedType ){
						ParameterizedType pt = (ParameterizedType) fc;
						 // 得到泛型里的class类型对象。
						Class<Object> genericClazz = (Class<Object>)pt.getActualTypeArguments()[0]; 
						
						List<Object> list = (List<Object>) result;
						if (list != null) {
							// 写入集合大小
							dataOutputStream.writeShort((short) list.size());
							
							for(int i=0;i<list.size();i++){
								// 基本数据类型
								if( genericClazz.getSimpleName().equals("Byte") ){     
									dataOutputStream.writeByte((Byte) list.get(i));
									
								}else if( genericClazz.getSimpleName().equals("Short") ){
									dataOutputStream.writeShort((Short) list.get(i));
									
								}else if( genericClazz.getSimpleName().equals("Integer") ){
									dataOutputStream.writeInt((Integer) list.get(i));
									
								}else if( genericClazz.getSimpleName().equals("String") ){
									String str = (String) list.get(i);
									byte[] strByteArr = str.getBytes(HandleStaticValue.CHARSET_NAME);
									
									dataOutputStream.writeShort((short) strByteArr.length);
									dataOutputStream.write(strByteArr);
								}else{
									
									// 写入自定义对象
									ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
									DataOutputStream dataOutputStream2 =  new DataOutputStream(byteArrayOutputStream2);
									
									// 计算对象的长度
									dataOutputStream2.writeShort((short) 0);
									wirteData(list.get(i), dataOutputStream2);
									
									// 替换对象长度
									byte[] buf1 =  byteArrayOutputStream2.toByteArray();
									// 对象的长度应该
									//IMLog.anlong("集合内的对象长度：" + (buf1.length - 2));
									byte[] buff = ByteAndInt.short2ByteArray((short) ( buf1.length - 2 ));
									for(int j=0;j<2;j++){
										buf1[j] = buff[j];
									}
									
									dataOutputStream.write(buf1, 0, buf1.length);
									
									dataOutputStream2.close();
									byteArrayOutputStream2.close();
								}
							}
						} else {
							dataOutputStream.writeShort((short) 0);
						}
					} 
				}else{  //自定义数据类型
					wirteData(result, dataOutputStream);
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} 
	}
	
    public static byte[] toHH(int n) {
		  byte[] b = new byte[4];
		  b[3] = (byte) (n & 0xff);
		  b[2] = (byte) (n >> 8 & 0xff);
		  b[1] = (byte) (n >> 16 & 0xff);
		  b[0] = (byte) (n >> 24 & 0xff);
		  return b;
    }
    
	/*@Override
	public void handleMessageEvent(MessageEvent event) {
		// TODO 如果连接超时则终止请求连接实例的定时器
		if (event != null && event.getbCode() == HandleStaticValue.BCODE1000){
			IMLog.anlong("连接异常,超时终止：" + event.getbCode());
			socket = null;
			isConn = true;
		}
	}
	
	static class getSocketTimer extends TimerTask {
		@Override
		public void run() {
			socket = InitServerManagerImpl.getInstance().getSocketIntance();
			IMLog.anlong("[Request]Socket Instance："+socket);
		} 
	}*/
    
}
