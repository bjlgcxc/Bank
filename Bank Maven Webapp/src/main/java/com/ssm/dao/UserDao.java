package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.User;

public interface UserDao {
	
	@Insert("insert into user(IDNo,name,telephone,gender) values(#{IDNo},#{name},#{telephone},#{gender})")
	public void insert(User user);
	
	@Delete("delete from user where id=#{id}")
	public void delete(int id);
	
	@Update("update user set IDNo=#{IDNo},name=#{name},telephone=#{telephone},gender=#{gender} where id=#{id}")
	public void update(User user); 
	
	@Select("select * from user where id=#{id}")
    public User selectById(int id);
	
	@Select("select * from user where IDNo=#{IDNo}")
	public User selectByIDNo(String IDNo);
	
}