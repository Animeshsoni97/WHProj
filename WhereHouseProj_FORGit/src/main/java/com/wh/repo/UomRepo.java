package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.Uom;

public interface UomRepo extends JpaRepository<Uom, Integer>{
   @Query("select uomId,uomModel from Uom order by uomModel")
	List<Object[]> getUomIdAndModel();
	
}//interface
