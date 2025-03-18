package com.savemate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savemate.model.Coupon;
import com.savemate.repository.CouponRepository;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon updateSeo(Long id, String title, String description, String keywords) {
        return couponRepository.findById(id).map(coupon -> {
            coupon.setSeoTitle(title);
            coupon.setSeoDescription(description);
            coupon.setSeoKeywords(keywords);
            return couponRepository.save(coupon);
        }).orElseThrow(() -> new RuntimeException("Coupon not found!"));
    }
}
