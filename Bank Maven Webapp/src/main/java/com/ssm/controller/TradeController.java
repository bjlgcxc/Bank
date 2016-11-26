package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.ssm.pojo.Trade;
import com.ssm.service.AccountService;
import com.ssm.service.TradeService;

@RequestMapping("/trade")
@Controller
public class TradeController {

	@Autowired
	TradeService tradeService;
	@Autowired
	AccountService accountService;
	
	/*
	 * 查询交易记录
	 * @Para：cardId,password
	 */
	@RequestMapping("/queryTrade")
	public JSONObject queryTrade(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		long cardId = Long.parseLong(request.getParameter("cardId"));
		String password = request.getParameter("pwssword");
		if(accountService.accountCheck(cardId, password)==null){
			json.put("ok", false);
			json.put("msg", "密码错误");
		}
		else{
			List<Trade> list = tradeService.getTradeByCardId(cardId);
			json.put("ok", true);
			json.put("trade", list);		
		}
		
		return json;
	}

}
