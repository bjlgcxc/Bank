package com.ssm.dao;

import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Region;

public interface RegionDao {

	@Insert("insert into region(code,name) values(#{code},#{name})")
	public void insert(Region region);
	
	@Delete("delete from region where id=#{id}")
	public void delete(int id);
	
	@Update("update region set code=#{code},name=#{name}")
	public void update(Region region); 
	
	@Select("select * from region where id=#{id}")
    public Region selectById(int id);
	
}
