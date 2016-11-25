package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Account;

public interface AccountDao {
	
	//insert
	@Insert("insert into account(cardNo,userId,bankId,password,balance) "
			+ "values(#{cardNo},#{userId},#{bankId},#{password},#{balance})")
	public void insert(Account account);
	
	//delete
	@Delete("delete from account where userId=#{userId} and cardId=#{cardId}")
	public void delete(int userId,long cardId);
	
	//update
	@Update("update account set balance=balance+#{change} where cardId=#{cardId}")
	public void update(long cardId,float change);
	
	//select
	@Select("select * from account where id=#{id}")
	public Account selectById(int id);
	
	@Select("select balance from account where cardId=#{cardId}")
	public float selectBalance();
	
	@Select("select max(cardId) from account")
	public long selectMaxCardId();
	
}
