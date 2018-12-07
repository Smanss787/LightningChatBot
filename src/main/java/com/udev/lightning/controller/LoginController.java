package com.udev.lightning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.udev.lightning.beans.User;

@Controller
public class LoginController {

	@GetMapping(value="/login")

	public String getLoginForm() {
		return "login";
	}

	@PostMapping(value="/login")
	public String login(@ModelAttribute(name="user") User user, Model model) { 		
		System.out.println(user.getLogin()+" p "+user.getPassword() );
		String username = user.getLogin();
		String password = user.getPassword();
		
		if("utilisateur".equals(username) && "admin".equals(password) || "utilisateur2".equals(username) && "admin".equals(password)) {

			model.addAttribute("user", user);
			return "home";
		}
		model.addAttribute("invalidCredentials", true);
		return "login";
	}
}