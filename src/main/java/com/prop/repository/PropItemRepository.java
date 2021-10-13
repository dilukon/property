package com.prop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prop.model.PropItem;

@Repository
public interface PropItemRepository extends JpaRepository<PropItem, Long>{
	

}
