package com.wh.service;

import java.util.List;

import com.wh.model.ShipmentType;

public interface IShipmentTypeService {

	public Integer addShipType(ShipmentType s);
	
	public List<ShipmentType> allShipmentType();

	public void deleteByShipmentTypeId(Integer id);
	
	public ShipmentType getShipmentTypeModelById(Integer id);
	
	public Integer updateShipmentType(ShipmentType u);
}
