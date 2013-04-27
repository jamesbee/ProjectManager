package com.pm.TCP;

import com.pm.Data.RequestInfo;

public interface OnRequestListener {//监听器，用于监听界面上的查询事件
	public void onRequestListener(RequestInfo info);
}
