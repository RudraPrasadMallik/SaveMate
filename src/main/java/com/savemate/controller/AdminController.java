package com.savemate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savemate.model.Advertisement;
import com.savemate.model.Coupon;
import com.savemate.model.Deals;
import com.savemate.model.Section;
import com.savemate.service.AdminService;
import com.savemate.service.CouponService;
import com.savemate.service.DealsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@GetMapping("/debug")
	public String debugAuth() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    System.out.println("Authenticated User: " + authentication.getName());
	    System.out.println("Roles: " + authentication.getAuthorities());

	    return "Check logs for authentication details!";
	}

    @Autowired
    private AdminService adminService;
    @Autowired
    private CouponService couponService;
    
    private DealsService dealsService;
    

    // ================== Advertisement APIs ====================

    @PostMapping("/createads")
    public Advertisement createAd(@RequestBody Advertisement ad) {
        return adminService.saveAd(ad);
    }

    @GetMapping("/ads")
    public List<Advertisement> getAllAds()
    {
        return adminService.getAllAds();
    }

    @PutMapping("/updateads/{id}")
    public Advertisement updateAd(@PathVariable Long id, @RequestBody Advertisement adDetails) {
        return adminService.updateAd(id, adDetails);
    }

    @DeleteMapping("/deleteads/{id}")
    public String deleteAd(@PathVariable Long id) {
        return adminService.deleteAd(id);
    }

    // ================== Section APIs ==================

    @PostMapping("/createsections")
    public Section createSection(@RequestBody Section section) {
        System.out.println("Received Section Request: " + section);
        Section savedSection = adminService.saveSection(section);
        System.out.println("Saved Section: " + savedSection);
        return savedSection;
    }


    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return adminService.getAllSections();
    }

    @PutMapping("/updatesections/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section sectionDetails) {
        return adminService.updateSection(id, sectionDetails);
    }

    @DeleteMapping("/deletesections/{id}")
    public String deleteSection(@PathVariable Long id) {
        return adminService.deleteSection(id);
    }
    
    
 // ================== Coupons APIs ==================
    
    @PostMapping("/createcoupons")
    public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
        try {
            Coupon savedCoupon = adminService.saveCoupon(coupon);
            return ResponseEntity.ok(savedCoupon);
       }
        //catch (DataIntegrityViolationException ex) {
//            Map<String, String> error = new HashMap<>();
//            error.put("message", "Coupon with this title or slug already exists.");
//            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
//        } 
        catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Something went wrong while saving the coupon.");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @DeleteMapping("/deleteCoupon/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Long id){
    	try {
    		couponService.deleteCoupon(id);
    		return ResponseEntity.ok("Coupon has been deleted sucessfully");
    	}
    	 catch (RuntimeException e) {
             return ResponseEntity.status(404).body(e.getMessage());
         }
    }
    
    @GetMapping("/getcoupons")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        List<Coupon> coupons = couponService.getAllCoupons();
        return ResponseEntity.ok(coupons);
    }
    
    //====================== Deals Api ==========================
    
    @GetMapping("/getdeals")
    public ResponseEntity<List<Deals>> getAllDeals(){
    	List<Deals> deals = dealsService.getAllDeals();
    	return ResponseEntity.ok(deals);
    }
    
//    @PostMapping("/createcoupons")
//    public ResponseEntity<?> createDeals(@RequestBody Deals deals) {
//        try {
//         //   Deals savedCoupon = dealsService.saveCoupon(deals);
//            return ResponseEntity.ok(savedCoupon);
//       }
//        catch (Exception e) {
//            Map<String, String> error = new HashMap<>();
//            error.put("message", "Something went wrong while saving the deals.");
//            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    
}