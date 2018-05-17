package com.blogApp.common.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.blogApp.data.entity.UserRole;

public class BlogUtils {
	private static HashMap<Long, UserRole> userRoleMap = new HashMap<>();

	private static HashMap<Long, UserRole> getUserRoleMap() {
		return userRoleMap;
	}

	public static void initData(List<UserRole> userRoleList) {
		System.out.println("Starting Init Data at " + new Date());
		for (UserRole userRole : userRoleList) {
			userRoleMap.put(userRole.getRoleId(), userRole);
		}
		System.out.println("Init Data Complete at " + new Date());
		System.out.println("User Roles Map : " + getUserRoleMap().size());
	}

	public static Boolean isAuthorized(HttpSession session) {
		if (session.getAttribute(BlogConstants.CURRENT_USER) != null)
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
}
