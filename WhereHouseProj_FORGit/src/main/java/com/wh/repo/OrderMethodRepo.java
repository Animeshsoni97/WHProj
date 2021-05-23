package com.wh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wh.model.OrderMethod;

public interface OrderMethodRepo extends JpaRepository<OrderMethod, Integer> {

}
