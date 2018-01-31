package com.struts.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;


public class LoginServiceAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	UserDao userDao=(UserDao)ctx.getBean("userDao");
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception{
		List<User> userList=userDao.findByName(username);
		for(User user:userList) {
			if(user.getPassword().equals(password)) {
				return "success";
			}else {
				return "error";
			}
		}
        return "error";
	}
}
