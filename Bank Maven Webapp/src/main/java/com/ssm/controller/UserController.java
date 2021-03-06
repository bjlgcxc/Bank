package com.ssm.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	@ResponseBody
	@RequestMapping("/addUser")
	public JSONObject addUser(HttpServletRequest request,User user){
		userService.addUser(user);
		
		JSONObject json = new JSONObject();
		json.put("ok", true);
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/queryUser")
	public User queryUser(HttpServletRequest request) throws UnsupportedEncodingException{
		String name = request.getParameter("name");
		String IDNo = request.getParameter("IDNo");
		User user = userService.getUserByID(name,IDNo);
		return user;
	}
	
}
