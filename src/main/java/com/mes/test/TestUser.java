package com.mes.test;

import java.io.IOException;
import java.util.List;

import javax.imageio.IIOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mes.dao.UserDao;
import com.mes.meta.User;


@Controller
public class TestUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		UserDao userDao = context.getBean("userDao", UserDao.class);
		//userDao.creatTable();
		//userDao.insertUser("zuoan","Veronus");
		List<User> users = userDao.getUserList();
		for (User user : users) {
			System.out.println(user.getUserName()+user.getUserPassword());
		}
		((ConfigurableApplicationContext) context).close();

	}
	
	@RequestMapping(value="/users/getHtml")
	public String getHtml(ModelMap map) throws IOException{
		map.addAttribute("this", "this is test");
		return "user";
	}
	
	@RequestMapping(value="/users/getJson")
	public String geJson(ModelMap map) throws IOException{
		map.addAttribute("this", "this is test");
		return "user";
	}

}
