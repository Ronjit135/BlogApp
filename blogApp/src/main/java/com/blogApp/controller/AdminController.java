package com.blogApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogApp.common.utility.BlogUtils;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	@GetMapping("/Home")
	public String showAdminHome(HttpSession session) {
		if (!BlogUtils.isAuthorized(session))
			return "redirect:/";
		return "Admin/AdminHome";
	}
}
