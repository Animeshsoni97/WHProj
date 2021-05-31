package com.wh.service;

import java.util.List;

import com.wh.model.PurchaseDetail;

public interface IPurchaseDetailService {
    public Integer savePurchaseDetail(PurchaseDetail PurchaseDetail);
    
	List<PurchaseDetail> getAllPurchaseDetails(Integer id);
    
//    public void deletePurchaseDetail(Integer id);
    
   
}
	