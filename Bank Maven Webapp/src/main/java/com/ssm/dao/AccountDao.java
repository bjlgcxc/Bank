package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Account;

public interface AccountDao {

	@Insert("insert into account(cardNo,userId,bankId,password,balance) "
			+ "values(#{cardNo},#{userId},#{bankId},#{password},#{balance})")
	public void insert(Account account);
	
	@Delete("delete from account where id=#{id}")
	public void delete(int id);
	
	@Update("update account set cardNo=#{cardNo},userId=#{userId},bankId=#{bankId},password=#{password},"
			+ "balance=#{balance} where id=#{id}")
	public void update(Account account);
	
	@Select("select * from account where id=#{id}")
	public Account selectById(int id);
	
	@Select("select max(cardId) from account")
	public long selectMaxCardId();
}
