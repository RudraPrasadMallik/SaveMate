package com.savemate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savemate.model.Coupon;
import com.savemate.model.Deals;
import com.savemate.model.Section;
import com.savemate.repository.DealsRepository;

@Service
public class DealsService {
	@Autowired
	private DealsRepository dealsRepository;
	
	public List<Deals> getAllDeals(){
		return dealsRepository.findAll();
	}
	
	public void deleteService(Long id) {
    	if(!dealsRepository.existsById(id) ) {
    		throw new RuntimeException("coupon not found !");
    	}
    	dealsRepository.deleteById(id);
    			
    }
    
	 public Deals createDeals(Deals deals) {
		    return dealsRepository.save(deals);
		}
	
	 public Deals updateDeals(Long id, Deals newDealsDetails) {
		    return dealsRepository.findById(id).map(deals -> {
		        deals.setTitle(newDealsDetails.getTitle());
		        deals.setImageUrl(newDealsDetails.getImageUrl());
		        deals.setLogoImgUrl(newDealsDetails.getLogoImgUrl());
		        return dealsRepository.save(deals);
		    }).orElseThrow(() -> new RuntimeException("Deals not found with ID: " + id));
		}

	
	
	

}
