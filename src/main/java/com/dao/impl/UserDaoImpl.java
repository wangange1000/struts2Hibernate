package com.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {

	private HibernateTemplate ht=null;
	private SessionFactory sessionFactory=null;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private HibernateTemplate getHibernateTemplate() {
		if(ht==null) {
			ht=new HibernateTemplate(sessionFactory);
		}
		return ht;
	}
	
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return (User)getHibernateTemplate().get(User.class, id);
	}

	public Integer save(User user) {
		return (Integer)getHibernateTemplate().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByName(String name) {
		return (List<User>)getHibernateTemplate().find("from User u where u.name = ? ",name);

	}
}