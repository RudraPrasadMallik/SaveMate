package com.savemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savemate.model.Coupon;
import com.savemate.repository.CouponRepository;

@RestController
@RequestMapping("/sitemap")
public class SitemapController {

    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("/sitemap.xml")
    public String generateSitemap() {
        List<Coupon> coupons = couponRepository.findAll();
        StringBuilder sitemap = new StringBuilder();

        sitemap.append("<urlset xmlns='http://www.sitemaps.org/schemas/sitemap/0.9'>");
        for (Coupon coupon : coupons) {
            sitemap.append("<url><loc>https://savemate.com/coupons/")
                   .append(coupon.getSlug())
                   .append("</loc></url>");
        }
        sitemap.append("</urlset>");

        return sitemap.toString();
    }
}
