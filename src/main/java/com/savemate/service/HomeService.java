package com.savemate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savemate.model.Advertisement;
import com.savemate.model.Section;
import com.savemate.model.SubmitCoupon;
import com.savemate.model.SubmitMerchant;
import com.savemate.repository.AdRepository;
import com.savemate.repository.SectionRepository;
import com.savemate.repository.SubmitCouponRepository;
import com.savemate.repository.SubmitMerchantRepository;

@Service
public class HomeService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private SectionRepository sectionRepository;
    
    @Autowired
    private SubmitCouponRepository submitcouponrepo;
    
    @Autowired
    private SubmitMerchantRepository submitmerchantrepo;

    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
    
//    Submit coupon & Merchants
    
    public SubmitCoupon getCouponCust(SubmitCoupon sc) {
		return submitcouponrepo.save(sc);
    }
    
    public SubmitMerchant getMerchantCust(SubmitMerchant sm) {
    	return submitmerchantrepo.save(sm);
    }
    
    
}