package com.savemate.controller;

import com.savemate.model.AppSeo;
import com.savemate.service.AppSeoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seo")

public class AppSeoController {

    private final AppSeoService seoService;

    public AppSeoController(AppSeoService seoService) {
        this.seoService = seoService;
    }

    @GetMapping("/{pageName}")
    public ResponseEntity<AppSeo> getSeo(@PathVariable String pageName) {
        return ResponseEntity.ok(seoService.getSeoByPage(pageName));
    }

    @PutMapping("/{pageName}")
    public ResponseEntity<String> updateSeo(@PathVariable String pageName, @RequestBody AppSeo seoRequest) {
        seoService.updateSeo(
            pageName,
            seoRequest.getSeoTitle(),
            seoRequest.getSeoDescription(),
            seoRequest.getSeoKeywords()
        );
        return ResponseEntity.ok("SEO updated successfully!");
    }
}
