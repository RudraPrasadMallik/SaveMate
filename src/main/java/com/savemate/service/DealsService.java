package com.savemate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savemate.model.Deals;
import com.savemate.repository.DealsRepository;

@Service
public class DealsService {
	@Autowired
	private DealsRepository dealsRepository;
	
	public List<Deals> getAllDeals(){
		return dealsRepository.findAll();
	}
	
 
	
	
	

}
