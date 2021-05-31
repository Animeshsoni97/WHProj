package com.wh.service;

import java.util.List;
import java.util.Map;

import com.wh.model.OrderMethod;

public interface IOrderMethodService {

	public Integer saveOrderMethod(OrderMethod u);

	public List<OrderMethod> allOrderMethod();

	public void deleteByOrderMethodId(Integer id);
	
	public OrderMethod getOrderMethodModelById(Integer id);
	
	public Integer updateOrderMethod(OrderMethod u);

    public Map<Integer,String> getIdAndCodeByPassingMode(String mode); 
}
