package com.savemate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.savemate.model.Section;
import com.savemate.service.AdminService;

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
}