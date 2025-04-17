package com.savemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savemate.model.Advertisement;
import com.savemate.model.Coupon;
import com.savemate.model.Section;
import com.savemate.model.SubmitCoupon;
import com.savemate.model.SubmitMerchant;
import com.savemate.service.AppSeoService;
import com.savemate.service.CouponService;
import com.savemate.service.HomeService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;
    @Autowired
    private CouponService couponService;
    
    @Autowired
    private AppSeoService seoService;
    
   
    // ✅ Fetch all advertisements
    @GetMapping("/ads")
 //   @CrossOrigin(origins = "https://savemateapp.onrender.com")
    public List<Advertisement> getAllAds() {
        return   homeService.getAllAds();
    }

    // ✅ Fetch all sections
    @GetMapping("/sections")
  //  @CrossOrigin(origins = "https://savemateapp.onrender.com")
    public List<Section> getAllSections() {
        return homeService.getAllSections();
    }
    
    
    
    @GetMapping("/coupons")
  //  @CrossOrigin(origins = "https://savemateapp.onrender.com")
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }
    

    
//    Get coupon & Merchant from customers
    @PostMapping("/submitcoupon")
  //  @CrossOrigin(origins = "https://savemateapp.onrender.com")
    public SubmitCoupon submitCoupon(@RequestBody SubmitCoupon sc) {
		return homeService.getCouponCust(sc);
    	
    }
    @PostMapping("/submitmerchant")
  //  @CrossOrigin(origins = "https://savemateapp.onrender.com")
    public SubmitMerchant submitMrechant(@RequestBody SubmitMerchant sm) {
		return homeService.getMerchantCust(sm);
    	
    }
    
    
    

    
}
