package com.blogApp.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogApp.common.utility.BlogConstants;
import com.blogApp.common.utility.BlogUtils;
import com.blogApp.data.entity.User;
import com.blogApp.service.BlogServiceIfc;

@Controller
public class BlogController {

	@Autowired
	BlogServiceIfc service;

	@PostConstruct
	public void initData() {
		BlogUtils.initData(service.getAllUserRoles());
	}

	@GetMapping("/")
	public String showLogin() {
		return "Login";
	}

	@PostMapping("/Login")
	public String validateLogin(String userName, String password, HttpSession session) {
		User user = service.validateUser(userName, password);
		if (user == null) {
			return "redirect:/";
		} else if (user.getUserRole().equals(BlogConstants.ROLE_ADMIN)) {
			session.setAttribute(BlogConstants.CURRENT_USER, user);
			return "redirect:/Admin/Home";
		} else {
			session.setAttribute(BlogConstants.CURRENT_USER, user);
			return "redirect:/User/Home";
		}
	}
}
