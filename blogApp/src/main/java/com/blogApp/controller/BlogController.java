package com.blogApp.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String redirectTologin() {
		return "redirect:/Login";
	}

	@GetMapping("/Login")
	public String showLogin(HttpSession session, ModelMap map) {
		if (session.getAttribute(BlogConstants.MESSAGE) != null) {
			map.addAttribute(BlogConstants.MESSAGE, true);
			map.addAttribute(BlogConstants.MESSAGE_TEXT, session.getAttribute(BlogConstants.MESSAGE_TEXT));
			session.invalidate();
		}
		return "Login";
	}

	@PostMapping("/Login")
	public String validateLogin(String userName, String password, HttpSession session) {
		User user = service.validateUser(userName, password);
		if (user == null) {
			session.setAttribute(BlogConstants.MESSAGE, true);
			session.setAttribute(BlogConstants.MESSAGE_TEXT, "Invalid Username/Password");
			return "redirect:/";
		} else if (user.getUserRole().equals(BlogConstants.ROLE_ADMIN)) {
			session.setAttribute(BlogConstants.CURRENT_USER, user);
			return "redirect:/Admin/Home";
		} else {
			session.setAttribute(BlogConstants.CURRENT_USER, user);
			return "redirect:/User/Home";
		}
	}

	@GetMapping("/Register")
	public String showRegister(HttpSession session, ModelMap map) {
		if (session.getAttribute(BlogConstants.MESSAGE) != null) {
			map.addAttribute(BlogConstants.MESSAGE, true);
			map.addAttribute(BlogConstants.MESSAGE_TEXT, session.getAttribute(BlogConstants.MESSAGE_TEXT));
			session.invalidate();
		}
		return "Register";
	}

	@PostMapping("/Register")
	public String registerUser(String userName, String firstName, String lastName, String password,
			HttpSession session) {
		User user = service.registerUser(userName, firstName, lastName, password,
				BlogUtils.getUserRoleById(BlogConstants.ROLE_USER));
		if (user == null) {
			session.setAttribute(BlogConstants.MESSAGE, true);
			session.setAttribute(BlogConstants.MESSAGE_TEXT, "Plese Try Again");
		} else {
			session.setAttribute(BlogConstants.MESSAGE, true);
			session.setAttribute(BlogConstants.MESSAGE_TEXT, "Registration Successfull");
		}
		
		return "redirect:/Register";
	}
}
