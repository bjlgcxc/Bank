package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.TradeDao;
import com.ssm.pojo.Trade;

@Service
public class TradeService {
	
	@Autowired
	TradeDao tradeDao;
	
	public void addTrade(Trade trade){
		tradeDao.insert(trade);
	}
	
	public void deleteTrade(int id){
		tradeDao.delete(id);
	}
	
	public void updateTrade(Trade trade){
		tradeDao.update(trade);
	}
	
	public Trade getTradeById(int id){
		return tradeDao.selectById(id);
	}
	
}
