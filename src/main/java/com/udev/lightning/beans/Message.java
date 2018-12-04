package com.udev.lightning.beans;

public class Message {

	private String transmitter;
	private String messageContent;
	
	public String getFrom() {
		return transmitter;
	}
	public void setFrom(String from) {
		this.transmitter = from;
	}
	public String getMessage() {
		return messageContent;
	}
	public void setMessage(String message) {
		this.messageContent = message;
	}
	@Override
	public String toString() {
		return "Message [from=" + transmitter + ", message=" + messageContent + "]";
	}
	
	
}