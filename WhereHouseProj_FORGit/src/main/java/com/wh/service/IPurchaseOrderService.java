package com.wh.service;

import java.util.List;

import com.wh.model.PurchaseOrder;

public interface IPurchaseOrderService {

	public Integer savePurchaseOrder(PurchaseOrder u);

	public List<PurchaseOrder> allPurchaseOrder();

	public void deleteByPurchaseOrderId(Integer id);
	
	public PurchaseOrder getPurchaseOrderModelById(Integer id);
	
	public Integer updatePurchaseOrder(PurchaseOrder u);

}
