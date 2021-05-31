package com.wh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.WhUserType;
import com.wh.repo.WHUserRepo;
import com.wh.utills.MyColl;
@Service
public class WHUserTypeService implements IWHUserService {
	@Autowired
	private WHUserRepo repo;
/*
 *  @param ana WHUserType idnetity to be saved
 *  @return id value ot saved WHUserType model
 */
	@Override
	public Integer saveWHUserType(WhUserType WHUserTypeModel) {
		WhUserType returndWHUserType=	repo.save(WHUserTypeModel);
		return	returndWHUserType.getWhUId();
	}
	@Override
	public List<WhUserType> allWHUserType() {
		return repo.findAll();
	}//allWHUserType
	
	@Override
	public void deleteByWHUserTypeId(Integer id) {
		repo.deleteById(id);
	}//delete
	
	@Override
	public WhUserType getWHUserTypeById(Integer id) {
		return repo.getById(id);
	}
	
	@Override
	public Integer updateWHUserType(WhUserType u) {
        return	saveWHUserType(u);
	}//update
	@Override
	public boolean isCodeDuplicate(String modal) {
		Integer count=repo.getcount(modal);
		if(count==0)
		return false;
		else
			return true;
	}
	/*
	 * getUser Id and Code as List<Objecy[]> from repo
	 * @param type(vendor/customer)
	 * @return Map<Integer,String> containing all user type id and Code
	 */
	@Override
	public Map<Integer, String> getwhUserIdAndCodeByType(String type) {
		return 	MyColl.listToMap(repo.getIdAndCodeByType(type));
	}
	
	
}//class