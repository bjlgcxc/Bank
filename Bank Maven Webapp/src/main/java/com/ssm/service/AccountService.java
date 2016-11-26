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
	
	public void deleteAccount(long cardId,int userId){
		accountDao.delete(userId, cardId);
	}
	
	public void updateBalance(long cardId,float change){
		accountDao.update(cardId, change);
	}

	public Account accountCheck(long cardId,String password){
		return accountDao.selectByCard(cardId, password);
	}
	
	public float getBalance(long cardId){
		return accountDao.selectBalance();
	}
	
	public long getMaxCardId(){
		return accountDao.selectMaxCardId();
	}
	
}
