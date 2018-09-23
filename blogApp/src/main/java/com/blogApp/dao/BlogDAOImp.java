package com.blogApp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blogApp.common.utility.BlogConstants;
import com.blogApp.data.entity.User;
import com.blogApp.data.entity.UserRole;

@Repository
public class BlogDAOImp implements BlogDAOIfc {

	@Autowired
	SessionFactory sessionFactory;

	private static final Logger log = Logger.getLogger(BlogDAOImp.class);
	private Session session;
	private Transaction transaction;

	private Session getSession() {
		openSession();
		beginTransaction();
		return session;
	}

	private void openSession() {
		if (session == null)
			session = sessionFactory.openSession();
	}

	private void beginTransaction() {
		if (session != null)
			transaction = session.beginTransaction();
	}

	private void commit() {
		if (session != null && transaction != null)
			transaction.commit();
	}

	private void rollback() {
		if (session != null && transaction != null)
			transaction.rollback();
	}

	private void closeSession() {
		if (session != null)
			session.close();
		session = null;
		transaction = null;
	}

	private Long getNextId(String query) {
		Long id = null;
		try {
			id = getSession().createNamedQuery(query, Long.class).setMaxResults(1).getSingleResult();
			commit();
			id++;
		} catch (NoResultException e) {
			rollback();
			id = 1L;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return id;
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		List<UserRole> userRoleList = new ArrayList<>();
		try {
			userRoleList = (List<UserRole>) getSession()
					.createNamedQuery(BlogConstants.USER_ROLE_GET_ALL_USER_ROLES, UserRole.class).getResultList();
			commit();
		} catch (Exception e) {
			rollback();
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
			user = getSession().createNamedQuery(BlogConstants.USER_VALIDATE_USER, User.class).setParameter(0, userName)
					.setParameter(1, password).getSingleResult();
			commit();
			log.info("User " + userName + " successfully logged in  at " + new Date());
		} catch (NoResultException e) {
			rollback();
			log.info("No User found for Username : " + userName + " at " + new Date());
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		} finally {
			closeSession();
		}
		return user;
	}

	@Override
	public User registerUser(String userName, String firstName, String lastName, String password, UserRole userRole) {
		User user = new User(userName, password, firstName, lastName, userRole);
		try {
			Long userId = getNextId(BlogConstants.USER_GET_NEXT_ID);
			user.setUserId(userId);
			getSession().save(user);
			commit();
			log.info("User " + user.getUserName() + " is registered with ID " + userId + " at " + new Date());
		} catch (ConstraintViolationException e) {
			rollback();
			e.printStackTrace();
			log.info("User " + user.getUserName() + " already exists at " + new Date());
			return null;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			return null;
		} finally {
			closeSession();
		}
		return user;
	}
}
