package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.WhUserType;

public interface WHUserRepo extends JpaRepository<WhUserType, Integer> {

	
	@Query("select count(whUCode) from WhUserType where whUCode= :modal")
	public Integer getcount(String modal);
	
	@Query("select whUId, whUCode from WhUserType where whUType= :type")
	public List<Object[]> getIdAndCodeByType(String type);
	
}//interface
