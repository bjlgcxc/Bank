package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.RegionDao;
import com.ssm.pojo.Region;

@Service
public class RegionService {
	
	@Autowired
	RegionDao regionDao;
	
	public void addRegion(Region region){
		regionDao.insert(region);
	}
	
	public void deleteRegion(int id){
		regionDao.delete(id);
	}
	
	public void updateRegion(Region region){
		regionDao.update(region);
	}

	public Region getRegionById(int id){
		return regionDao.selectById(id);
	}
	
}
