package com.savemate.controller;

import com.savemate.model.Advertisement;
import com.savemate.repository.AdRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/ads")
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertisementController {

    @Autowired
    private AdRepository adRepository;

    // ✅ GET API – For frontend users
    @GetMapping("/home")
    public List<Map<String, String>> getAdsForHomePage() {
        List<Advertisement> manualAds = adRepository.findByStatusTrueAndTypeOrderByDisplayOrderAsc("manual");
        List<Advertisement> googleAds = adRepository.findByStatusTrueAndTypeOrderByDisplayOrderAsc("google");

        List<Map<String, String>> finalAds = new ArrayList<>();

        // Add manual ads first
        for (Advertisement ad : manualAds) {
            Map<String, String> map = new HashMap<>();
            map.put("type", "manual");
            map.put("imageUrl", ad.getImageUrl());
            map.put("redirectUrl", ad.getRedirectUrl());
            finalAds.add(map);
        }

        // Fill with Google ads after manual ones
        int remaining = 5 - finalAds.size(); // example: max 5 ad slots
        for (int i = 0; i < remaining && i < googleAds.size(); i++) {
            Advertisement ad = googleAds.get(i);
            Map<String, String> map = new HashMap<>();
            map.put("type", "google");
            map.put("googleScript", ad.getGoogleScript());
            finalAds.add(map);
        }

        return finalAds;
    }

    // ✅ POST API – Admin Panel to create a new ad
    @PostMapping("/create")
    public Advertisement createAd(@RequestBody Advertisement ad) {
        return adRepository.save(ad);
    }

    // ✅ PUT API – Update existing ad
    @PutMapping("/update/{id}")
    public Advertisement updateAd(@PathVariable Long id, @RequestBody Advertisement adDetails) {
        Advertisement ad = adRepository.findById(id).orElseThrow();
        ad.setImageUrl(adDetails.getImageUrl());
        ad.setRedirectUrl(adDetails.getRedirectUrl());
        ad.setStatus(adDetails.isStatus());
        ad.setDisplayOrder(adDetails.getDisplayOrder());
        ad.setType(adDetails.getType());
        ad.setGoogleScript(adDetails.getGoogleScript());
        return adRepository.save(ad);
    }

    // ✅ GET ALL Ads (admin view)
    @GetMapping("/all")
    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }
}
