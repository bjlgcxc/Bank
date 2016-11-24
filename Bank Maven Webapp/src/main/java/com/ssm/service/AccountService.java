package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.AccountDao;
import com.ssm.pojo.Account;

@Service
public class AccountService {
	
	@Autowired
	AccountDao accountDao;
	
	public void addAccount(Account account){
		accountDao.insert(account);
	}
	
	public void deleteAccount(int id){
		accountDao.delete(id);
	}
	
	public void updateAccount(Account account){
		accountDao.update(account);
	}

	public Account getAccountById(int id){
		return accountDao.selectById(id);
	}
	
	public long getMaxCardId(){
		return accountDao.selectMaxCardId();
	}
	
}
