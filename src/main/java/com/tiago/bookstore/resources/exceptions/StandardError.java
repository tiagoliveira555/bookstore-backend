package com.tiago.bookstore.resources.exceptions;

public class StandardError {

	private Long timestamp;
	private Integer status;
	private String error;
	
	public StandardError() {
	}

	public StandardError(Long timestamp, Integer status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String geterror() {
		return error;
	}

	public void seterror(String error) {
		this.error = error;
	}
}
