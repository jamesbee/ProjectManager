package com.pm.Data;

public class ResponseInfo {
	private TYPE res_id;
	private String in_out;//in为进，out为出
	private String data;
	
	public ResponseInfo(){
		res_id = TYPE.DEFAULT;
		in_out = null;
		data = null;
	}
	//不提供参数为Json字符串的构造器
	
	public TYPE getRes_id() {
		return res_id;
	}
	public void setRes_id(TYPE res_id) {
		this.res_id = res_id;
	}
	public String getIn_out() {
		return in_out;
	}
	public void setIn_out(String in_out) {
		this.in_out = in_out;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
