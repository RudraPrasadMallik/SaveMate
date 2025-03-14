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

    @PostMapping("/ads")
    public Advertisement createAd(@RequestBody Advertisement ad) {
        return adminService.saveAd(ad);
    }

    @GetMapping("/ads")
    public List<Advertisement> getAllAds()
    {
        return adminService.getAllAds();
    }

    @PutMapping("/ads/{id}")
    public Advertisement updateAd(@PathVariable Long id, @RequestBody Advertisement adDetails) {
        return adminService.updateAd(id, adDetails);
    }

    @DeleteMapping("/ads/{id}")
    public String deleteAd(@PathVariable Long id) {
        return adminService.deleteAd(id);
    }

    // ================== Section APIs ==================

    @PostMapping("/sections")
    public Section createSection(@RequestBody Section section) {
        return adminService.saveSection(section);
    }

    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return adminService.getAllSections();
    }

    @PutMapping("/sections/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section sectionDetails) {
        return adminService.updateSection(id, sectionDetails);
    }

    @DeleteMapping("/sections/{id}")
    public String deleteSection(@PathVariable Long id) {
        return adminService.deleteSection(id);
    }
}