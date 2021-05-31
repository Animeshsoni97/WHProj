package com.wh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wh.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

}