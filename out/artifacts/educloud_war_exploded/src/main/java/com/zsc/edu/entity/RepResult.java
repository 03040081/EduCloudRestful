package com.zsc.edu.entity;

public class RepResult<T> {
	
	public String msg;
	public T result;
	
	public RepResult(String msg, T result) {
		this.msg = msg;
		this.result = result;
	}

	public RepResult() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
}
