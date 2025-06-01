package com.savemate.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savemate.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
	Page<Coupon> findByType(String type, Pageable pageable);
}

