package com.wh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.OrderMethod;
import com.wh.repo.OrderMethodRepo;
@Service
public class OrderMethodService implements IOrderMethodService {
	@Autowired
	private OrderMethodRepo repo;
/*
 *  @param ana OrderMethod idnetity to be saved
 *  @return id value ot saved OrderMethod model
 */
	@Override
	public Integer saveOrderMethod(OrderMethod OrderMethodModel) {
		OrderMethod returndOrderMethod=	repo.save(OrderMethodModel);
		return	returndOrderMethod.getOrderMId();
	}//saveOrderMethod
	
	@Override
	public List<OrderMethod> allOrderMethod() {
		return repo.findAll();
	}//allOrderMethod
	
	@Override
	public void deleteByOrderMethodId(Integer id) {
		repo.deleteById(id);
	}//delete
	
	@Override
	public OrderMethod getOrderMethodModelById(Integer id) {
		return repo.getById(id);
	}
	
	@Override
	public Integer updateOrderMethod(OrderMethod u) {
		return null;
	}//update
}//class