package com.cg.exception;

public class ErrorInfo {
	private String url;
	private String msg;
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorInfo(String url, String msg) {
		super();
		this.url = url;
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ErrorInfo [url=" + url + ", msg=" + msg + "]";
	}
	

}
