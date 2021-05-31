package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.PurchaseDetail;

public interface PurchaseDetailRepo  extends JpaRepository<PurchaseDetail, Integer>{

	@Query(" from PurchaseDetail where  purchaseOrder.poId= :po")
	public List<PurchaseDetail> findAllPurchasweOrder(Integer po);
}
