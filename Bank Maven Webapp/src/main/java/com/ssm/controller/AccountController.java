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
	 */
	@RequestMapping("/openAccount")
	public JSONObject openAccount(HttpServletRequest request){	
		//userId
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
		//bankId
		int bankId = bankService.selectBankByName(name).getId();
		//password
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
	 */
	@RequestMapping("/closeAccount")
	public JSONObject closeAccount(HttpServletRequest request){
		long cardId = Long.parseLong(request.getParameter("cardId"));
		String password = request.getParameter("password");
		
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		accountService.deleteAccount(cardId,userId);
		
		JSONObject json = new JSONObject();
		json.put("ok", true);
		return json;
	}
	
	/*
	 * 存款/取款
	 */
	@RequestMapping("/changeBalance")
	public JSONObject saveMoney(HttpServletRequest request){
		long cardId = Long.parseLong(request.getParameter("cardId"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		accountService.updateBalance(cardId, amount);
		Trade trade = new Trade(cardId,0,amount,new Date(),0);
		tradeService.addTrade(trade);
		
		JSONObject json = new JSONObject();
		json.put("ok", true);
		return json;
	}
	
	/*
	 * 转账
	 */
	@RequestMapping("/transfer")
	public JSONObject transfer(HttpServletRequest request){
		long from = Long.parseLong(request.getParameter("from"));
		long to = Long.parseLong(request.getParameter("to"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		//change balance and record trade
		accountService.updateBalance(from, -amount);
		Trade trade = new Trade(from,1,-amount,new Date(), 0.1f);
		tradeService.addTrade(trade);
		accountService.updateBalance(to, amount);
		trade = new Trade(from,1,amount,new Date(),0);
		tradeService.addTrade(trade);
		
		JSONObject json = new JSONObject();
		json.put("ok", true);
		return json;
	}
	
	/*
	 * 查询余额
	 */
	@RequestMapping("/queryBalance")
	public JSONObject queryBalance(HttpServletRequest request){
		long cardId = Long.parseLong(request.getParameter("cardId"));
		float balance = accountService.getBalance(cardId);
		
		JSONObject json = new JSONObject();
		json.put("balance", balance);
		return json;
	}

}
