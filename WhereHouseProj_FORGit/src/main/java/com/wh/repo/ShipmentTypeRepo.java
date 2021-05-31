package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.ShipmentType;

public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer>{

	@Query("select shipTId,shipTCode from ShipmentType where enableShipT = :enable order by shipTCode")
	public List<Object[]> getshipIdAndShipCodeByEnable(String enable);
}
