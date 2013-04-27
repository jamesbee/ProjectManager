package com.pm.TCP;

import com.pm.Data.ResponseInfo;

public interface OnReceiveListener {//监听器，监听收到服务器回应事件
	public void onReceiveMsg(ResponseInfo info);
}
