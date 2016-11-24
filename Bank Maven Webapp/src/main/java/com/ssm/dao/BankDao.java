package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Bank;

public interface BankDao {
	
	@Insert("insert into bank(name,address,region) values(#{name},#{address},#{region})")
	public void insert(Bank bank);
	
	@Delete("delete from bank where id=#{id}")
	public void delete(int id);
	
	@Update("update bank set name=#{name},address=#{address},region=#{region} where id=#{id}")
	public void update(Bank bank); 
	
	@Select("select * from bank where id=#{id}")
    public Bank selectById(int id);
	
}
