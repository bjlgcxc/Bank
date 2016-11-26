package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.ssm.pojo.Trade;

public interface TradeDao {
	
	//insert
	@Insert("insert into trade(cardId,type,amount,time,charge) "
			+ "values(#{cardId},#{type},#{amount},#{time},#{charge})")
	public void insert(Trade trade);
	
	//delete
	@Delete("delete from trade where id=#{id}")
	public void delete(int id);
	
	//update
	@Update("update trade set cardId=#{cardId},type=#{type}"
			+ ",amount=#{amount},time=#{time},charge=#{charge}")
	public void update(Trade trade); 
	
	//select
	@Select("select * from trade where id=#{id}")
    public Trade selectById(int id);
	
	@Select("select * from trade where cardId=#{cardId}")
	public List<Trade> selectByCardId(long cardId);
	
}
