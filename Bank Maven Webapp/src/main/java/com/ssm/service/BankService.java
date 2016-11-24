package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.BankDao;
import com.ssm.pojo.Bank;

@Service
public class BankService {
	
	@Autowired
	BankDao bankDao;
	
	public void addBank(Bank bank){
		bankDao.insert(bank);
	}
	
	public void deleteBank(int id){
		bankDao.delete(id);
	}
	
	public void updateBank(Bank bank){
		bankDao.update(bank);
	}

	public Bank selectBankById(int id){
		return bankDao.selectById(id);
	}
	
}
