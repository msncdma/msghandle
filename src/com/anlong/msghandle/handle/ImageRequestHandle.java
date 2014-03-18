package com.anlong.msghandle.handle;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.socket.InitFileSocketServer;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;

/**
 * @ClassName: RequestImageFile 
 * @Package: com.anlong.imsghandle.file
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 发送图片文件请求编码类
 * @author anlong 
 * @date 2013-5-23 下午6:55:05 
 * @version V1.0
 */
public class ImageRequestHandle {
	private ByteArrayOutputStream byteOutputStream = null;
	private DataOutputStream  dataOutputStream = null;
	
	public void ImageEncode(Object request){
		OutputStream outputStream = null;
		try {
			if (request == null)
				return;
			
			if(request instanceof Request100){
				// TODO 获取输出流
				outputStream = InitFileSocketServer.getOutputStream();
				if (outputStream == null)
					return;
				// TODO 获取请求对象
				Request100 request100 = (Request100)request;
				
				// TODO 定义字节流和数据流
				byteOutputStream = new ByteArrayOutputStream();
				dataOutputStream = new DataOutputStream(byteOutputStream);
				
				// TODO 将图片文件流化并计算文件大小
				byte[] imageBuf = HandleImageDataSteam(request100);
					
				// TODO 写入图片文件至数据流
				writeContent(request100, dataOutputStream);
				
				// TODO 将图片字节数据写入输出流
				if (imageBuf == null)
					byteOutputStream.write(0);
				else 
					byteOutputStream.write(imageBuf);
							
				// TODO 获取内存缓冲区中的数据
				byte[] buf = byteOutputStream.toByteArray();
				IMLog.anlong("图片大小:"+buf);
				// TODO 发送图片文件
				outputStream.write(buf);
				outputStream.flush();
				IMLog.anlong("图片已发送!");
			}// end instance of
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*// TODO 关闭流
			if(dataOutputStream != null){
				try {
					dataOutputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(byteOutputStream != null){
				try {
					byteOutputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}*/
		}
	}
	
	/**
	 * @Title: HandleImageDataSteam 
	 * @Description: TODO 将图片文件转化为字节数组
	 * @author anlong 
	 * @param @param request100
	 * @param @return     
	 * @return byte[]     
	 * @throws
	 */
	private byte[] HandleImageDataSteam(Request100 request100){
		try {
			if (Utils.isNull(request100.getFileUrl()))
				return null;
			// TODO 将图片文件转化为字节数组
			byte[] imageSteam = readFromSD(request100);
			
			if (imageSteam == null)
				return null;
			// TODO 设置图片字节大小
			IMLog.anlong("图片文件字节大小: " + imageSteam.length);
			request100.setFileSize(imageSteam.length);
			
			return imageSteam;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Title: readFromSD 
	 * @Description: TODO 从SD卡中读取图片文件，并且以字节流返回
	 * @author anlong 
	 * @param @param dir
	 * @param @param fileName
	 * @param @return     
	 * @return byte[]     
	 * @throws
	 */
	 private byte[] readFromSD(Request100 request100){
		InputStream inputStream = null;
		try {
			File file = new File(request100.getFileUrl());
			if (!file.exists())
				return null;
			// TODO 读取SD卡中的图片文件
			inputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] data = new byte[inputStream.available()];
		    inputStream.read(data);
		    return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if( inputStream != null ){
				     inputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	 }


	
	/**
	 * @Title: writeContent 
	 * @Description: TODO 写入图片文件数据至数据流
	 * @author anlong 
	 * @param @param request100
	 * @param @param dataOutputStream     
	 * @return void     
	 * @throws
	 */
	private void writeContent(Request100 request100, DataOutputStream dataOutputStream){
		try {
			dataOutputStream.writeByte(Utils.isNotNull(request100.getOperateType())?request100.getOperateType():0);
			wirteString(request100.getFileCode(), dataOutputStream);
			wirteString(request100.getFileType(), dataOutputStream);
			dataOutputStream.writeInt(Utils.isNotNull(request100.getFileSize())?request100.getFileSize():0);
			dataOutputStream.writeByte(Utils.isNotNull(request100.getImageType())?request100.getImageType():0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: wirteString 
	 * @Description: TODO 读出字符串数据字节流
	 * @author anlong 
	 * @param @param str
	 * @param @param dataOutputStream
	 * @param @throws IOException     
	 * @return void     
	 * @throws
	 */
	private void wirteString(String str, DataOutputStream dataOutputStream) throws IOException{
		if(Utils.isNotNull(str)){
			byte[] byteArr = str.getBytes(HandleStaticValue.CHARSET_NAME);
			dataOutputStream.writeShort((short) byteArr.length);
			dataOutputStream.write(byteArr);
		}else{
			dataOutputStream.writeShort((short) 0);
		}
	}
	
}
