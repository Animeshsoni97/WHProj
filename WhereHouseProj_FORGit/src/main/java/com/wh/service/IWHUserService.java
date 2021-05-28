package com.wh.service;

import java.util.List;

import com.wh.model.WhUserType;

public interface IWHUserService {

	public Integer saveWHUserType(WhUserType u);

	public List<WhUserType> allWHUserType();

	public void deleteByWHUserTypeId(Integer id);
	
	public Integer updateWHUserType(WhUserType u);

    public	WhUserType getWHUserTypeById(Integer id);

	public boolean isCodeDuplicate(String modal);
}
