package com.ssm.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.Account;
import com.ssm.pojo.Trade;
import com.ssm.pojo.User;
import com.ssm.service.AccountService;
import com.ssm.service.BankService;
import com.ssm.service.TradeService;
import com.ssm.service.UserService;

/**
 * AccountController
 * 
 * @author caixiaocong
 *
 */
@RequestMapping("/account")
@Controller
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;
	@Autowired
	BankService bankService;
	@Autowired
	TradeService tradeService;	
	
	/*
	 * 开户
	 * @Para：name,IDNo,bankName,password
	 */
	@RequestMapping("/openAccount")
	public JSONObject openAccount(HttpServletRequest request){	
		//get userId
		String name = request.getParameter("name");
		String IDNo = request.getParameter("IDNo");
		User user = userService.getUserByID(name, IDNo);
		int userId;
		if(user!=null){
			userId = user.getId();
		}
		else{
			user = new User();
			user.setName(name);
			user.setIDNo(IDNo);
			userService.addUser(user);
			
			userId = userService.getUserByID(name, IDNo).getId();
		}	
		//get bankId
		int bankId = bankService.selectBankByName(name).getId();
		//get password
		String password = request.getParameter("password");
		
		Account account = new Account();
		account.setUserId(userId);
		account.setBankId(bankId);
		account.setPassword(password);
		account.setCardId(accountService.getMaxCardId() + 1);
		account.setBalance(0);
		accountService.addAccount(account);
		
		JSONObject json = new JSONObject();
		json.put("ok", true);
		return json;
	}
	
	
	/*
	 * 销户
	 * @para：cardId,password,name,IDNo
	 */
	@RequestMapping("/closeAccount")
	public JSONObject closeAccount(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		//验证用户是否存在
		String name = request.getParameter("name");
		String IDNo = request.getParameter("IDNo");
		User user = userService.getUserByID(name,IDNo);
		int userId = 0;
		if(user==null){
			json.put("ok", false);
			json.put("msg","用户不存在");
		}
		else{
			userId = user.getId();
		}
		//验证用户信息与银行卡是否对应
		long cardId = Long.parseLong(request.getParameter("cardId"));
		String password = request.getParameter("password");
		Account account = accountService.accountCheck(cardId, password);
		if(account.getUserId()!=userId){
			json.put("ok", false);
			json.put("meg", "用户信息错误");
		}
		else{
			accountService.deleteAccount(cardId,userId);
			json.put("ok", true);
		}
		
		return json;
	}
	
	
	/*
	 * 存款/取款
	 * @Para：cardId,password,amount
	 */
	@RequestMapping("/changeBalance")
	public JSONObject saveMoney(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		long cardId = Long.parseLong(request.getParameter("cardId"));
		String password = request.getParameter("password");
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		if(accountService.accountCheck(cardId, password)==null){
			json.put("ok", false);
			json.put("msg", "密码错误");
		}
		else{
			accountService.updateBalance(cardId, amount);
			Trade trade = new Trade(cardId,0,amount,new Date(),0);
			tradeService.addTrade(trade);
			json.put("ok", true);
		}
		
		return json;
	}
	
	/*
	 * 转账
	 * @Para：from,to,password,amount
	 */
	@RequestMapping("/transfer")
	public JSONObject transfer(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		long from = Long.parseLong(request.getParameter("from"));
		long to = Long.parseLong(request.getParameter("to"));
		String password = request.getParameter("password");
		float amount = Float.parseFloat(request.getParameter("amount"));
		if(accountService.accountCheck(from, password)==null){
			json.put("ok", false);
			json.put("msg", "密码错误");
		}
		else{
			accountService.updateBalance(from, -amount);
			Trade trade = new Trade(from,1,-amount,new Date(), 0.1f);
			tradeService.addTrade(trade);
			accountService.updateBalance(to, amount);
			trade = new Trade(from,1,amount,new Date(),0);
			tradeService.addTrade(trade);
			json.put("ok", true);
		}
		
		return json;
	}
	
	/*
	 * 查询余额
	 */
	@RequestMapping("/queryBalance")
	public JSONObject queryBalance(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		long cardId = Long.parseLong(request.getParameter("cardId"));
		String password = request.getParameter("password");
		if(accountService.accountCheck(cardId, password)==null){
			json.put("ok", false);
			json.put("msg", "密码错误");
		}
		else{
			float balance = accountService.getBalance(cardId);
			json.put("ok", true);
			json.put("balance", balance);
		}
		
		return json;
	}

}
