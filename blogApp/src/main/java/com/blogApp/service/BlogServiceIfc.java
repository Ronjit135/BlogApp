package com.blogApp.service;

import java.util.List;

import com.blogApp.data.entity.User;
import com.blogApp.data.entity.UserRole;

public interface BlogServiceIfc {
	public List<UserRole> getAllUserRoles();

	public User validateUser(String userName, String password);
}
