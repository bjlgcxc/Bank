package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Trade;
import com.ssm.service.TradeService;

@RequestMapping("/trade")
@Controller
public class TradeController {

	@Autowired
	TradeService tradeService;
	
	@RequestMapping("/queryTrade")
	public Trade queryTrade(HttpServletRequest request){
		long cardId = Long.parseLong(request.getParameter("cardId"));
		return tradeService.getTradeByCardId(cardId);
	}

}
