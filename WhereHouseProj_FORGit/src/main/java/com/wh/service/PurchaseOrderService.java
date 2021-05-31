package com.wh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.PurchaseOrder;
import com.wh.repo.PurchaseOrderRepo;
@Service
public class PurchaseOrderService implements IPurchaseOrderService {
	@Autowired
	private PurchaseOrderRepo repo;
/*
 *  @param ana PurchaseOrder idnetity to be saved
 *  @return id value ot saved PurchaseOrder model
 */
	@Override
	public Integer savePurchaseOrder(PurchaseOrder PurchaseOrderModel) {
		PurchaseOrder returndPurchaseOrder=	repo.save(PurchaseOrderModel);
		return	returndPurchaseOrder.getPoId();
	}//savePurchaseOrder
	
	@Override
	public List<PurchaseOrder> allPurchaseOrder() {
		return repo.findAll();
	}//allPurchaseOrder
	
	@Override
	public void deleteByPurchaseOrderId(Integer id) {
		repo.deleteById(id);
	}//delete
	
	@Override
	public PurchaseOrder getPurchaseOrderModelById(Integer id) {
		return repo.getById(id);
	}
	
	@Override
	public Integer updatePurchaseOrder(PurchaseOrder u) {
return	repo.save(u).getPoId();
	}//update
	
	
}//class