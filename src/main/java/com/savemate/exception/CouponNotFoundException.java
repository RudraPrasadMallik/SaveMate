package com.savemate.exception;

public class CouponNotFoundException extends RuntimeException {
    public CouponNotFoundException(String message) {
        super("Coupon is not available");
    }
}
