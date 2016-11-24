package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.service.TradeService;

@RequestMapping("/trade")
@Controller
public class TradeCController {

	@Autowired
	TradeService tradeService;
	
	@RequestMapping("queryTrade")
	public String queryTrade(HttpServletRequest request){
		return null;
	}

}
