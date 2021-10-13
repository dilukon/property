package com.prop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prop.model.PropItem;

@Service
public interface PropItemSerive {

	List<PropItem> findAll();
	

	

}
