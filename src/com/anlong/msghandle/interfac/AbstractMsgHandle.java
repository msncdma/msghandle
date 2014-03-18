package com.anlong.msghandle.interfac;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.anlong.msghandle.common.HandleStaticValue;
import com.anlong.msghandle.impl.AppParamImpl;
import com.anlong.msghandle.impl.AppSystemMessageReportImpl;
import com.anlong.msghandle.impl.AuthenticationImpl;
import com.anlong.msghandle.impl.BroadcastImpl;
import com.anlong.msghandle.impl.CommonContactImpl;
import com.anlong.msghandle.impl.DepInfoListImpl;
import com.anlong.msghandle.impl.EditGroupImpl;
import com.anlong.msghandle.impl.EditGroupUserImpl;
import com.anlong.msghandle.impl.EditUserInfoImpl;
import com.anlong.msghandle.impl.ExitPreventGroupImpl;
import com.anlong.msghandle.impl.GetGroupInfoImpl;
import com.anlong.msghandle.impl.GetHistoryMessageImpl;
import com.anlong.msghandle.impl.GetUserInfoImpl105;
import com.anlong.msghandle.impl.GroupInfoListImpl;
import com.anlong.msghandle.impl.GroupShareImpl;
import com.anlong.msghandle.impl.HeartImpl103;
import com.anlong.msghandle.impl.LocationImpl;
import com.anlong.msghandle.impl.LoginImpl101;
import com.anlong.msghandle.impl.MessageStateReportImpl;
import com.anlong.msghandle.impl.OnlineStateImpl102;
import com.anlong.msghandle.impl.OnlineUserListImpl110;
import com.anlong.msghandle.impl.SendImageFile;
import com.anlong.msghandle.impl.SendMessageImpl203;
import com.anlong.msghandle.impl.SystemParaImpl;
import com.anlong.msghandle.impl.UnreadMessageImpl;
import com.anlong.msghandle.impl.UpdatePasswordImpl;
import com.anlong.msghandle.impl.UserInfoListImpl;
import com.anlong.msghandle.request.Request100;
import com.anlong.msghandle.request.Request101;
import com.anlong.msghandle.request.Request102;
import com.anlong.msghandle.request.Request103;
import com.anlong.msghandle.request.Request105;
import com.anlong.msghandle.request.Request110;
import com.anlong.msghandle.request.Request203;
import com.anlong.msghandle.util.IMLog;
import com.anlong.msghandle.util.Utils;

/**
 * 请先调用setContext();方法,
 * @ClassName: AbstractMsgHandle 
 * @Package: com.anlong.imsghandle
 * @company ShenZhen anlong Technology CO.,LTD.  
 * @Description: TODO 消息请求实现类 
 * @author anlong 
 * @date 2013-6-1 下午1:39:51 
 * @version V1.0
 */
public class AbstractMsgHandle implements MsgHandle {
	
	public AbstractMsgHandle() {
		// TODO Auto-generated constructor stub
	}
	
	public AbstractMsgHandle(Context context) {
		if (Utils.isNull(context)) {
			IMLog.e("发送请求时,未收到请求上下文!");
			return;
		}
		//判定本地网络是否已连上wifi
		if(!Utils.isNetworkConnected(context)){
			// TODO 通知页面更新提示
			Utils.notifyMessage(3,HandleStaticValue.BCODE1000);
			return;
		} else {
			// TODO 通知页面更新提示
			Utils.notifyMessage(5,HandleStaticValue.BCODE1000);
		}
		  
		// 获取IP及端口号
		SharedPreferences settings =context.getSharedPreferences(HandleStaticValue.SHAREDPREFERENCES_im_sharedfile_ipinfo,Context.MODE_WORLD_READABLE);
		HandleStaticValue.SERVER_IP = settings.getString(HandleStaticValue.SHAREDPREFERENCES_KEY_SERVER_IP, "121.15.130.218");
		HandleStaticValue.SERVER_PORT = Integer.parseInt(settings.getString(HandleStaticValue.SHAREDPREFERENCES_KEY_SERVER_PORT, "8680")); 
	     Log.e("MainActivity", "   请求id=="+HandleStaticValue.SERVER_IP+"     请求端口："+HandleStaticValue.SERVER_PORT);
	}	
	
	 
	@Override
	public void execute(Request101 request101) throws Exception {
		new LoginImpl101().execute(request101);
	}

	@Override
	public void execute(Request102 request102) throws Exception {
		OnlineStateImpl102.getInstance().execute(request102);
	}
	
	@Override
	public void execute(Request103 request103) throws Exception {
		HeartImpl103.getInstance().execute(request103);
	}

	/*@Override
	public void execute(Request104 request104) throws Exception {
		new UpdatePasswordImpl().execute(request104);
	}*/

	@Override
	public void execute(Request105 request105) throws Exception {
		GetUserInfoImpl105.getInstance().execute(request105);
	}

	/*@Override
	public void execute(Request106 request106) throws Exception {
		UserInfoListImpl.getInstance().execute(request106);
	}*/
	
	/*@Override
	public void execute(Request107 request107) throws Exception {
		DepInfoListImpl.getInstance().execute(request107);
	}*/

	/*@Override
	public void execute(Request108 request108) throws Exception {
		new GetGroupInfoImpl().execute(request108);
	}*/

	/*@Override
	public void execute(Request109 request109) throws Exception {
		GroupInfoListImpl.getInstance().execute(request109);
	}*/

	@Override
	public void execute(Request110 request110) throws Exception {
		OnlineUserListImpl110.getInstance().execute(request110);
	}

	/*@Override
	public void execute(Request111 request111) throws Exception {
		new EditGroupImpl().execute(request111);
	}*/

	/*@Override
	public void execute(Request112 request112) throws Exception {
		new EditGroupUserImpl().execute(request112);
	}*/

	/*@Override
	public void execute(Request113 request113) throws Exception {
		new ExitPreventGroupImpl().execute(request113);
	}*/

	/*@Override
	public void execute(Request114 request114) throws Exception {
		new EditUserInfoImpl().execute(request114);
	}*/

	/*@Override
	public void execute(Request202 request202) throws Exception {
		new GetHistoryMessageImpl().execute(request202);
	}*/

	@Override
	public void execute(Request203 request203) throws Exception {
		SendMessageImpl203.getInstance().execute(request203);		
	}

	/*@Override
	public void execute(Request204 request204) throws Exception {
		MessageStateReportImpl.getInstance().execute(request204);
	}*/

	/*@Override
	public void execute(Request401 request401) throws Exception {
		new SystemParaImpl().execute(request401);
	}*/

	/*@Override
	public void execute(Request201 request201) throws Exception {
		new UnreadMessageImpl().execute(request201);
	}*/

	public void execute(Request100 request100) throws Exception {
		new SendImageFile().execute(request100);
	}

	/*@Override
	public void execute(Request115 request115) throws Exception {
		new CommonContactImpl().execute(request115);
	}*/

	/*@Override
	public void execute(Request116 request116) throws Exception {
		new LocationImpl().execute(request116);
	}*/

	/*@Override
	public void execute(Request205 request205) throws Exception {
		new BroadcastImpl().execute(request205);
	}*/

	/*@Override
	public void execute(Request402 request402) throws Exception {
		new AppParamImpl().execute(request402);
	}*/

	/*@Override
	public void execute(Request501 request501) throws Exception {
		new AuthenticationImpl().execute(request501);
	}*/

	/*@Override
	public void execute(Request117 request117) throws Exception {
		new GroupShareImpl().execute(request117); 
	}*/
	
	/*@Override
	public void execute(Request207 request207) throws Exception {
		new AppSystemMessageReportImpl().execute(request207); 
	}*/
}
