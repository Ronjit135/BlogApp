package com.blogApp.dao;

import java.util.List;

import com.blogApp.data.entity.User;
import com.blogApp.data.entity.UserRole;

public interface BlogDAOIfc {
	public List<UserRole> getAllUserRoles();

	public User validateUser(String userName, String password);
}
