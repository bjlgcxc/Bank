package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ssm.service.BankService;

@RequestMapping("/bank")
@Controller
public class BankController {

	@Autowired
	BankService bankService;
	
	@RequestMapping("/queryBank")
	public String queryBank(HttpServletRequest request){
		return null;
	}
	
}
