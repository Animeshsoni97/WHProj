package com.wh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wh.model.PurchaseDetail;
import com.wh.repo.PurchaseDetailRepo;
@Service
public class PurchaseDetailServiceImpl implements IPurchaseDetailService {
	@Autowired
	private PurchaseDetailRepo repo;

	@Override
	public Integer savePurchaseDetail(PurchaseDetail purchaseDetail) {
		return repo.save(purchaseDetail).getPurchaseOrder().getPoId();
		//	return repo.save(purchaseDetail).getId();
	}
	@Override
	public List<PurchaseDetail> getAllPurchaseDetails(Integer id) {
		List<PurchaseDetail> pd=repo.findAllPurchasweOrder(id);
		int i=1;
		for(PurchaseDetail p:pd) {
			p.setSlNo(i++);
		} 
	return pd;
	}//method 

}//class