package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Trade;

public interface TradeDao {

	@Insert("insert into trade(accountId,type,amount,time,charge) "
			+ "values(#{accountId},#{type},#{amount},#{time},#{charge})")
	public void insert(Trade trade);
	
	@Delete("delete from trade where id=#{id}")
	public void delete(int id);
	
	@Update("update trade set accountId=#{accountId},type=#{type}"
			+ ",amount=#{amount},time=#{time},charge=#{charge}")
	public void update(Trade trade); 
	
	@Select("select * from trade where id=#{id}")
    public Trade selectById(int id);
	
}
