package com.pm.UI;

import javax.swing.JFrame;

import com.pm.Data.ResponseInfo;
import com.pm.TCP.OnReceiveListener;
import com.pm.TCP.OnRequestListener;
import com.pm.jsonUtil.JSonUtil;

@SuppressWarnings("serial")
public class MainFrame extends JFrame implements OnReceiveListener{
	private static MainFrame frame = null;
	
	private MainFrame(){
		this.setSize(700,500);
		this.setLocation(300,100);
		this.setTitle("软件项目管理");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static MainFrame getMainFrame(){
		if(frame == null){
			frame = new MainFrame();
		}
		return frame;
	}
	
	//添加用户查询接口
	public void addOnRequestListener(OnRequestListener lisen){
		
	}

	@Override
	public void onReceiveMsg(ResponseInfo response) {
		// TODO Auto-generated method stub
		this.setTitle(JSonUtil.objectToJson(response));
	}
}
