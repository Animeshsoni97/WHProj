package com.wh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.Uom;
import com.wh.repo.UomRepo;
@Service
public class UomService implements IUomService {
	@Autowired
	private UomRepo repo;
/*
 *  @param ana Uom idnetity to be saved
 *  @return id value ot saved Uom model
 */
	@Override
	public Integer saveUom(Uom uomModel) {
		Uom returndUom=	repo.save(uomModel);
		return	returndUom.getUomId();
	}//saveUom
	
	@Override
	public List<Uom> allUom() {
		return repo.findAll();
	}//allUom
	@Override
	public void deleteByUomId(Integer id) {
		repo.deleteById(id);
	}//delete
	
	@Override
	public Uom getUomModelById(Integer id) {
		return repo.getById(id);
	}
	
	@Override
	public Integer updateUom(Uom u) {
		return repo.save(u).getUomId();
	}//update
}//class