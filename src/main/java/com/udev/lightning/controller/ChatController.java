package com.udev.lightning.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.udev.lightning.beans.Message;

@Controller
public class ChatController {

	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public Message getMessages(Message message) {
		System.out.println(message);
		return message;
	}
	
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
}