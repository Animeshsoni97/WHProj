package com.wh.service;

import java.util.List;
import java.util.Map;

import com.wh.model.Uom;

public interface IUomService {

	public Integer saveUom(Uom u);
	public List<Uom> allUom();
	public void deleteByUomId(Integer id);
	public Uom getUomModelById(Integer id);
	public Integer updateUom(Uom u);
	public Map<Integer,String> getUomIdAndModelAsMap();
}
