package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.OrderMethod;

public interface OrderMethodRepo extends JpaRepository<OrderMethod, Integer> {

	//from OrderMethod-->select * from OrderMethod
	@Query("select orderMId, orderMCode from OrderMethod where orderMMode= :mode order by orderMCode")
	public List<Object[]> showIDAndCodeByMode(String mode); //mode can be SALE OR PURCHASE
}
