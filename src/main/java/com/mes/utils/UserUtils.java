package com.mes.utils;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.UserDao;
import com.mes.meta.User;


public class UserUtils {
	
	public List<User> getUsers() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		((ConfigurableApplicationContext) context).close();
		return users;
	}
	
	public boolean check(String userName, String userPassword) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		List<User> users = userDao.getUserList();
		boolean tag = false;
		for (User user : users) {
			if (user.getUserName().equals(userName)  && user.getUserPassword().equals(userPassword)) {
				tag = true;
			}
		}
		((ConfigurableApplicationContext) context).close();
		
		return tag;
	}
}
