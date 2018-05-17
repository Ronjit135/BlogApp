package com.blogApp.common.utility;

public interface BlogConstants {
	/**
	 * Common Constants
	 */
	public static final String CURRENT_USER ="currentUser";
	
	/**
	 * User Roles
	 * ST_USER_ROLE
	 */
	public static final Long ROLE_ADMIN = 1L;
	public static final Long ROLE_USER = 2L;
	
	/**
	 * Queries
	 */
	public static final String USER_ROLE_GET_ALL_USER_ROLES = "UserRole.getAllUserRole";
	public static final String QUERY_GET_ALL_USER_ROLES = "SELECT r FROM UserRole r";
	
	public static final String USER_VALIDATE_USER = "User.validateUser";
	public static final String QUERY_VALIDATE_USER = "SELECT u FROM User u WHERE u.userName=? AND u.password=?";
	
}
