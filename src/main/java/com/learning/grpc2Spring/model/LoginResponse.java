package com.learning.grpc2Spring.model;

public class LoginResponse {
	int responseCode;
	String responseMessage;
	public LoginResponse (int responseCode,String responseMessage ) {
		this.responseMessage = responseMessage;
		this.responseCode=responseCode;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
