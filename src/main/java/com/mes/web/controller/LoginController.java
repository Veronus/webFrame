package com.mes.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mes.utils.UserUtils;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword, ModelMap map, HttpServletRequest request,
			HttpServletResponse response) {
		UserUtils userUtils = new UserUtils();
		map.addAttribute("userName", userName);
		map.addAttribute("userPassword", userPassword);
		System.out.println(userName + userPassword);
		if (userUtils.check(userName, userPassword)) {
			System.out.println("login");
			return "main";
		} else {
			System.out.println("some error");
			return "error";
		}

		/*Cookie userNameCookie = new Cookie("userName", userName);
		Cookie passWordCookie = new Cookie("password", userPassword);

		userNameCookie.setMaxAge(10 * 60);
		passWordCookie.setMaxAge(10 * 60);

		response.addCookie(userNameCookie);
		response.addCookie(passWordCookie);

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userName")) {
					userName = cookie.getValue();
					map.addAttribute("userName", userName);
				}
				if (cookie.getName().equals("password")) {
					userPassword = cookie.getValue();
				}
			}
			System.out.println("cookie");
			if (userUtils.check(userName, userPassword)) {
				System.out.println("login");
				return "edit";
			}
		} */

		
	}
}
