package com.ticket.park.jersey.responses;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name="CustomerAdditionResponse")

public class ServiceResponse
{
	private int responseCode;
	private boolean success;
	private String message;

	
	public ServiceResponse()
	{}

	@XmlElement(name="ResponseCode")
	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	@XmlElement(name="Success")
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@XmlElement(name="Message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}
