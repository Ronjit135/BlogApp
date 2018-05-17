package com.blogApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogApp.common.utility.BlogConstants;
import com.blogApp.common.utility.BlogUtils;

@Controller
@RequestMapping("/User")
public class UserController {
	@GetMapping("/Home")
	public String showUserHome(HttpSession session) {
		if (!BlogUtils.isAuthorized(session))
			return "redirect:/";
		return "User/UserHome";
	}
}
