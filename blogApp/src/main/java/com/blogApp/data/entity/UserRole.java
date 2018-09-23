package com.blogApp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.blogApp.common.utility.BlogConstants;

@Entity
@Table(name = "st_user_role")
@NamedQueries(value = {
		@NamedQuery(name = BlogConstants.USER_ROLE_GET_ALL_USER_ROLES, query = BlogConstants.QUERY_GET_ALL_USER_ROLES) })
public class UserRole {
	private Long roleId;
	private String roleDesc;

	public UserRole() {
		super();
	}

	public UserRole(String roleDesc) {
		super();
		this.roleDesc = roleDesc;
	}

	public UserRole(Long roleId, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleDesc = roleDesc;
	}

	@Id
	@Column(name = "user_role_id")
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "user_role_desc", length = 30, unique = true)
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}