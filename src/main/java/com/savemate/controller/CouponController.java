package com.savemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savemate.dto.SeoRequest;
import com.savemate.model.Coupon;
import com.savemate.service.CouponService;


@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @PutMapping("/{id}/seo")
    public ResponseEntity<String> updateSeo(@PathVariable Long id, @RequestBody SeoRequest seoRequest) {
        couponService.updateSeo(id, seoRequest.getTitle(), seoRequest.getDescription(), seoRequest.getKeywords());
        return ResponseEntity.ok("SEO updated successfully!");
    }
}

