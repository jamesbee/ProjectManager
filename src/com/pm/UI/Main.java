package com.pm.UI;

import java.util.ArrayList;

import com.pm.Data.RequestInfo;
import com.pm.Data.ResponseInfo;
import com.pm.Data.TYPE;
import com.pm.TCP.OnReceiveListener;
import com.pm.TCP.OnRequestListener;

public class Main implements OnRequestListener{
	
	OnReceiveListener frame = null;
	
	public void begin(){
		frame = MainFrame.getMainFrame();
		
		ArrayList<ResponseInfo> infos = new ArrayList<ResponseInfo>();

		for(int i = TYPE.DEFAULT.ordinal();i <= (TYPE.CAR_OTHEN_OVER_NIGHTS.ordinal());i++){
			ResponseInfo info = new ResponseInfo();
			info.setRes_id(TYPE.values()[i]);
			info.setIn_out("in");
			info.setData(Integer.toString(i));
			infos.add(info);
		}
		
		for(ResponseInfo info:infos){
			System.out.println(info.getRes_id());
			System.out.println(info.getIn_out());
			System.out.println(info.getData());
			System.out.println("-----------");
			frame.onReceiveMsg(info);
		}
	}
	
	public static void main(String args[]) {
		new Main().begin();		
	}

	@Override
	public void onRequestListener(RequestInfo info) {
		// TODO Auto-generated method stub
		
	}
}
