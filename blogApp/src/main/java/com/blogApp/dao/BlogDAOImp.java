package com.blogApp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogApp.common.utility.BlogConstants;
import com.blogApp.data.entity.User;
import com.blogApp.data.entity.UserRole;

@Repository
public class BlogDAOImp implements BlogDAOIfc {

	@Autowired
	SessionFactory sessionFactory;

	private Session session;

	private Session openSession() {
		return sessionFactory.openSession();
	}

	private void closeSession() {
		if (session != null)
			session.close();
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		List<UserRole> userRoleList = new ArrayList<>();
		try {
			userRoleList = (List<UserRole>) openSession()
					.createNamedQuery(BlogConstants.USER_ROLE_GET_ALL_USER_ROLES, UserRole.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return userRoleList;
	}

	@Override
	public User validateUser(String userName, String password) {
		User user = null;
		try {
			user = openSession().createNamedQuery(BlogConstants.USER_VALIDATE_USER, User.class)
					.setParameter(0, userName).setParameter(1, password).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No User found for Username : " + userName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return user;
	}
}
