package br.com.learnmotion.models.dtos;

import java.io.Serializable;

import br.com.learnmotion.common.enums.Status;

public class ResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Object result;

	private Status status;

	private String msg;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
