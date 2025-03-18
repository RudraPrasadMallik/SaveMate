package com.savemate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seo")
public class SeoController {
	
	 @GetMapping("/{page}")
	    public Map<String, String> getSeoMetadata(@PathVariable String page) {
	        Map<String, String> seoData = new HashMap<>();

	        switch (page) {
	            case "home":
	                seoData.put("title", "SaveMate - Best Deals & Coupons");
	                seoData.put("description", "Get the best deals and discounts with SaveMate.");
	                seoData.put("keywords", "coupons, discounts, promo codes, deals");
	                break;
	                
	            case "coupons":
	                seoData.put("title", "Find Best Coupon Codes | SaveMate");
	                seoData.put("description", "Browse the latest coupon codes and offers to save big.");
	                seoData.put("keywords", "discounts, coupon codes, vouchers, deals");
	                break;

	            default:
	                seoData.put("title", "SaveMate - Save More!");
	                seoData.put("description", "Find and claim amazing discount codes.");
	                seoData.put("keywords", "save money, promo codes, cashback");
	                break;
	        }

	        return seoData;
	    }

}
