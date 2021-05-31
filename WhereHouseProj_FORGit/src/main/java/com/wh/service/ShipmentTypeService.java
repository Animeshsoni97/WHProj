package com.wh.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.ShipmentType;
import com.wh.repo.ShipmentTypeRepo;
import com.wh.utills.MyColl;
@Service
public class ShipmentTypeService implements IShipmentTypeService{
	@Autowired
	private ShipmentTypeRepo repo;
	@Override
	public Integer addShipType(ShipmentType shipT) {
		return repo.save(shipT).getShipTId();
	}//addShipmentType

	@Override
	public List<ShipmentType> allShipmentType() {
		return repo.findAll();
	}//allShipmentType

	@Override
	public void deleteByShipmentTypeId(Integer id) {
		repo.deleteById(id);
	}//delete

	@Override
	public ShipmentType getShipmentTypeModelById(Integer id) {
		return repo.getById(id);
	}

	@Override
	public Integer updateShipmentType(ShipmentType u) {
		return	repo.save(u).getShipTId();
	}//update
	
	
	@Override
	public Map<Integer, String> getShipIdAndCodeForEnable() {
	List<Object[]> ob=repo.getshipIdAndShipCodeByEnable("Yes");
	return MyColl.listToMap(ob);	
	}
}//class
