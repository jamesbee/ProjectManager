package com.pm.Data;
import com.jamstudio.util.JSonUtil;

public class RequestInfo {
	private int req_id;
	private String param1;
	private String param2;
	private String param3;
	
	public RequestInfo(){
		req_id = TYPE.DEFAULT.ordinal();
		param1 = null;
		param2 = null;
		param3 = null;
	}
	
	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String toJsonString(){
		return JSonUtil.objectToJson(this);
	}
}
