package com.wh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wh.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {

}
