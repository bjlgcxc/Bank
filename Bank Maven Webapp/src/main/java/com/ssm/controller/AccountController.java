package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.service.AccountService;

@RequestMapping("/account")
@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	//开户
	@RequestMapping("/openAccount")
	public String openAccount(HttpServletRequest request){
		long newCardId = accountService.getMaxCardId() + 1;
		return null;
	}
	
	//销户
	@RequestMapping("/closeAccount")
	public String closeAccount(HttpServletRequest request){
		return null;
	}
	
	//存款
	@RequestMapping("/saveMoney")
	public String saveMoney(HttpServletRequest request){
		return null;
	}
	
	//取款
	@RequestMapping("/drawMoney")
	public String drawMoney(HttpServletRequest request){
		return null;
	}
	
	//转账
	@RequestMapping("/transfer")
	public String transfer(HttpServletRequest request){
		return null;
	}
	
	//查询余额
	@RequestMapping("/queryBalance")
	public String queryBalance(HttpServletRequest request){
		return null;
	}

}
