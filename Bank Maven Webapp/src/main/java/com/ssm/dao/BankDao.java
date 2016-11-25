package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.ssm.pojo.Bank;

public interface BankDao {
	
	//insert
	@Insert("insert into bank(name,address,region) values(#{name},#{address},#{region})")
	public void insert(Bank bank);
	
	//delete
	@Delete("delete from bank where id=#{id}")
	public void delete(int id);
	
	//update
	@Update("update bank set name=#{name},address=#{address},region=#{region} where id=#{id}")
	public void update(Bank bank); 
	
	//select
	@Select("select * from bank")
	public List<Bank> select();
	
	@Select("select * from bank where id=#{id}")
    public Bank selectById(int id);
	
}
