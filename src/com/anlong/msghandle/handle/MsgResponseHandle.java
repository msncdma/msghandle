package com.anlong.msghandle.handle;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.event.MessageEvent;
import com.anlong.msghandle.event.MessageEventSource;
import com.anlong.msghandle.util.ByteAndInt;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.ReflectionUtil;
import com.anlong.msghandle.util.Utils;

/**
 * @ClassName: ResponseHandle 
 * @Package: com.anlong.imsghandle.common
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO  响应消息处理 
 * @author anlong 
 * @date 2013-4-25 下午5:29:44 
 * @version V1.0
 */
public class MsgResponseHandle {
	private DataInputStream dataInputStream = null;
	private InputStream inputStream = null;
    private final static String TAG="MsgHandle";
	/**
	 * @Title: decode 
	 * @Description: TODO 解码器 
	 * @author anlong 
	 * @throws
	 */
	@SuppressWarnings("static-access")
	public void decode( InputStream stream ) throws Exception {
		try {
			// 输入IO流
			inputStream = stream;
			if( inputStream == null ) {
				IMLog.anlong("IO流中没有数据响应!");
				throw	new IOException();
			}

			// 消息体字节大小,不包括表示大小的4个字节
			int limit = 0;

			// 消息字节大小,包括表示大小的4个字节
			int msgSize = 0;

			// 消息字节数组
			byte[] data = null;

			// 保证IO流中可读字节数大于 4个字节
			byte[] dataSize = new byte[HandleStaticValue.PROTOCOL_SIZE];

			if (inputStream.read(dataSize) == HandleStaticValue.PROTOCOL_SIZE){
				msgSize = ByteAndInt.byteArray2Int(dataSize);
				IMLog.anlong("响应报文字节大小:" + msgSize);

				// 标识从该处读取剩余字节数
				limit = msgSize - HandleStaticValue.PROTOCOL_SIZE;
				IMLog.anlong("响应报文体字节数:" + limit + "=" + Utils.getFileSizeString((long)limit));

				// TODO 大于10M丢弃
				if (limit > 10000000) {
					IMLog.anlong("丢弃一个大小为 " + limit + "的数据包!");
					
					 throw  new IOException();
				}

				// 定义消息字节数组大小
				data = new byte[limit];
			} 

			// 循环读取消息字节
			int len = 0;
			while(len < limit){
				len += inputStream.read(data,len,(limit - len));
				IMLog.anlong("读取字节数:"+len);
			}

			if (data == null)
				throw new IOException();

			IMLog.anlong("读取流完成，byte[]的长度："+data.length);
			dataInputStream = new DataInputStream(new ByteArrayInputStream(data));

			if(dataInputStream != null ){
				// 业务编码
				short bCode = dataInputStream.readShort();
				// 密钥
				int key = dataInputStream.readInt();
				// 用户ID
				int uid = dataInputStream.readInt();
				// 返回编码
				short rtCode = dataInputStream.readShort();
				// 错误编码
				String rtMsg = dataInputStream.readUTF();
				// 消息流水号
				int msgSerial = dataInputStream.readInt();

				// 消息头打印
				IMLog.anlong("limit size:"+limit+" bCode:"+bCode+" key:"+key+" uid:"+uid+" rtCode:"+rtCode +" rtMsg:"+rtMsg+" msgSerial:"+msgSerial);

				if (bCode == 0) {
					IMLog.anlong("业务编码错误!");
					throw new IOException();
				}

				// 获取对象
				String requestPath = HandleStaticValue.RESPONSE_PACKEAGE +".Response"+bCode;
				Class requestClass = Class.forName(requestPath);

				// 解析消息体
				Object obj = ReadValue(requestClass,dataInputStream);

				// 反射设置消息头
				ReflectionUtil.invokeMethod(obj, "init", msgSize,bCode,key,uid,rtCode,rtMsg,msgSerial);

				// 分发事件
				try {
					if (bCode != 0 && obj != null){
						MessageEvent event = new MessageEvent(bCode,obj);
						new MessageEventSource().getSingleton().notifyMessageEvent(event);
					}
				} catch (Exception e) {
					IMLog.anlong("监听队列没有找到 " + bCode + "!");
					IMLog.anlong("已丢弃一个没有注册监听的数据包:" + bCode + "!");
					throw e;
				}
				
			} else {
				IMLog.anlong("没有数据响应!");
				throw new Exception();
			}
		  
		} catch (Exception e) {
			throw e;
		}
	}
 
	
	/**
	 * 利用反射解析IO数据，返回数据对象
	 * */
	@SuppressWarnings("unchecked")
	private Object ReadValue(Class<Object> clz,DataInputStream dataInputStream){
	 
			// 创建对象实例
			Object obj = null;
			try {
				obj = clz.newInstance();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 反射对象名称List集合
			Field arrField = null;
			try {
				arrField = obj.getClass().getDeclaredField("fieldArr");
			} catch (NoSuchFieldException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			arrField.setAccessible(true);
			String[] fieldList = null;
			try {
				fieldList = (String[]) arrField.get(obj);
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 属性类型
			String fieldType = null;
			// 首字母大写名称
			String fieldNameUpper = null;

			for ( String fieldName : fieldList ) {
				Field field = null;
				try {
					field = obj.getClass().getDeclaredField(fieldName);
				} catch (NoSuchFieldException e1) {
					 Log.e(TAG, "无法找到映射解析类------------->"+fieldName);
					continue;
				}
				fieldType = field.getType().getSimpleName();
				fieldNameUpper = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);

				if ( fieldType.equals("Byte") ){   
					/*byte val = dataInputStream.readByte();
					IMLog.anlong(fieldNameUpper + ": " + val);
					ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, val);*/

					try {
						ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, dataInputStream.readByte());
					} catch (Exception e) {
						 Log.e(TAG, "映射解析--Byte--错误->set"+fieldNameUpper);
					    continue;
					}
				} else if ( fieldType.equals("Short") ){
					//					short val = dataInputStream.readShort();
					//					IMLog.anlong(fieldNameUpper + ": " + val);
					//					ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, val);

					try {
						ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, dataInputStream.readShort());
					} catch (Exception e) {
						 Log.e(TAG, "映射解析--Short--错误->set"+fieldNameUpper);
					   continue;
					}
				} else if ( fieldType.equals("Integer") ){
					//					int val = dataInputStream.readInt();
					//					IMLog.anlong(fieldNameUpper + ": " + val);
					//					ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, val);

					try {
						ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, dataInputStream.readInt());
					} catch (Exception e) {
						 Log.e(TAG, "映射解析--Integer--错误->set"+fieldNameUpper);
						   continue;
					}
				} else if ( fieldType.equals("String") ){
					String value = null;
					try {
						value = dataInputStream.readUTF();
					} catch (IOException e1) {
						 Log.e(TAG, "映射解析--readUTF--错误->set"+fieldNameUpper);
						   continue;
					}  
					IMLog.anlong(fieldNameUpper + ": " + value);
					if(value.equals("蔡健")){
						Log.e("debug", "-------------出现警告解析");
					}
					try {
						ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper,value);
					} catch (Exception e) {
						 Log.e(TAG, "映射解析--String--错误->set"+fieldNameUpper);
						   continue;
					}

				} else if (fieldType.equals("List") ){  // 集合数据类型
					// 数组长度
					short arrSize = 0;
					try {
						arrSize = dataInputStream.readShort();
					} catch (IOException e) {
						 Log.e(TAG, "映射解析集合数据类型--List--错误->");
						   continue;
					}
					Type fc = field.getGenericType(); 
					List<Object> list= new ArrayList<Object>();

					// 这里判断是泛型集合
					if(fc instanceof ParameterizedType){
						ParameterizedType pt = (ParameterizedType) fc;
						// 得到泛型里的class类型对象。
						Class<Object> genericClazz = (Class<Object>)pt.getActualTypeArguments()[0]; 

						// 向集合添加数据
						for (int i = 0; i < arrSize; i++) {
							
							try {
								// 基本数据类型 
								if ( genericClazz.getSimpleName().equals("Byte") ){    
									list.add(dataInputStream.readByte());

								} else if ( genericClazz.getSimpleName().equals("Short") ){
									list.add(dataInputStream.readShort());

								} else if ( genericClazz.getSimpleName().equals("Integer") ){
									list.add(dataInputStream.readInt());

								} else if ( genericClazz.getSimpleName().equals("String") ){
									String str = dataInputStream.readUTF();
									list.add(str);
								} else {  // 自定义数据类型
									// 获取对象大小
									int byteCount = dataInputStream.readShort();
									IMLog.anlong("[响应]对象大小:" + byteCount);

									byte[] objdata = new byte[byteCount];
									dataInputStream.readFully(objdata, 0, byteCount);
									DataInputStream dataInputStream1 = new DataInputStream(new ByteArrayInputStream(objdata));

									// 递归获取对象信息
									list.add(ReadValue(genericClazz,dataInputStream1));
								}
							} catch (IOException e) {
								 Log.e(TAG, "映射解析集合数据类型--List--错误->");
							   continue;
							}
							
						}

						// 反射设置list集合
						Method method2 = null;
						try {
							method2 = clz.getMethod("set"+fieldNameUpper, List.class);
						} catch (NoSuchMethodException e1) {
							 Log.e(TAG, "映射解析反射设置list集合--List--错误->  set"+fieldNameUpper);
							   continue;
						}
						try {
							method2.invoke(obj,list);
						} catch (Exception e) {
							e.printStackTrace();
							 continue;
						} 
					}    
				}else{  // 自定义数据类型
					String requestPath = HandleStaticValue.RESPONSE_VO+"."+fieldType;
					Class requestClass = null;
					try {
						requestClass = Class.forName(requestPath);
					} catch (ClassNotFoundException e) {
					  Log.e(TAG, "映射解析自定义数据类型----错误->"+requestPath);
					  e.printStackTrace();
						 continue;
					}
					try {
						ReflectionUtil.invokeMethod(obj, "set"+fieldNameUpper, ReadValue(requestClass,dataInputStream));
					} catch (Exception e) {
						  Log.e(TAG, "映射解析自定义数据类型错误===注意字符类型->"+requestPath);
						e.printStackTrace();
						 continue;
					}
				}
			}

			return obj;
	  
	}

}
