package com.savemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.savemate.model.Advertisement;
import com.savemate.model.Coupon;
import com.savemate.model.Deals;
import com.savemate.model.Section;
import com.savemate.model.SubmitCoupon;
import com.savemate.model.SubmitMerchant;
import com.savemate.service.AppSeoService;
import com.savemate.service.CouponService;
import com.savemate.service.DealsService;
import com.savemate.service.HomeService;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;
    @Autowired
    private CouponService couponService;
    
    @Autowired
    private DealsService dealsService;
    
    @Autowired
    private AppSeoService seoService;
    
   
    // ✅ Fetch all advertisements
    @GetMapping("/ads")
    public List<Advertisement> getAllAds() {
        return   homeService.getAllAds();
    }

    // ✅ Fetch all sections
    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return homeService.getAllSections();
    }
    
    
    @GetMapping("/coupons")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }
    
    @GetMapping("/deal")
    public List<Deals> getAllDeals(){
    	return dealsService.getAllDeals();
    }
    
    @GetMapping("/coupons/bySection/{sectionName}")
    public Page<Coupon> getCouponsBySection(
            @PathVariable String sectionName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return couponService.getCouponsBySection(sectionName, PageRequest.of(page, size));
    }

    
//    Get coupon & Merchant from customers
    @PostMapping("/submitcoupon")
    public SubmitCoupon submitCoupon(@RequestBody SubmitCoupon sc) {
		return homeService.getCouponCust(sc);
    	
    }
    @PostMapping("/submitmerchant")
    public SubmitMerchant submitMrechant(@RequestBody SubmitMerchant sm) {
		return homeService.getMerchantCust(sm);
    	
    }
       
}