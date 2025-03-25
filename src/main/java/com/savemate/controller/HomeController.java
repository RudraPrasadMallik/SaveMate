package com.savemate.controller;

import com.savemate.model.Advertisement;
import com.savemate.model.Section;
import com.savemate.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;
    
   

    // ✅ Fetch all advertisements
    @GetMapping("/ads")
    public List<Advertisement> getAllAds() {
        return   homeService.getAllAds();
    }

    // ✅ Fetch all sections
    @GetMapping("/sections")
    public List<Section> getAllSections() {
        return homeService.getAllSections();
    }
    
//    public Map<String, Object> getHomePage() {
//        Map<String, Object> response = new HashMap<>();
//        response.put("ads", homeService.getAllAds());
//        response.put("sections", homeService.getAllSections());
//        return response;
//    }
    
}
