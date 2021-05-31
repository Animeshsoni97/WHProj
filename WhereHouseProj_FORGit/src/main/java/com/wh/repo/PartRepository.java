package com.wh.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wh.model.Part;

public interface PartRepository extends JpaRepository<Part, Integer> {

	@Query("select count(partCode) from Part where partCode= :a")
	public Integer getDuplicateCode(String a);

	@Query("select id,partCode from Part")
	public List<Object[]> getAllPartIDAndCode();
}
