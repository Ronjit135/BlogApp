package com.blogApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogApp.dao.BlogDAOIfc;
import com.blogApp.data.entity.User;
import com.blogApp.data.entity.UserRole;

@Service
public class BlogServiceImp implements BlogServiceIfc {

	@Autowired
	BlogDAOIfc dao;

	@Override
	public List<UserRole> getAllUserRoles() {
		return dao.getAllUserRoles();
	}

	@Override
	public User validateUser(String userName, String password) {
		return dao.validateUser(userName, password);
	}

	@Override
	public User registerUser(String userName, String firstName, String lastName, String password, UserRole userRole) {
		return dao.registerUser(userName, firstName, lastName, password, userRole);
	}
}
