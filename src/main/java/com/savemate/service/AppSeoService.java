package com.savemate.service;

import com.savemate.model.AppSeo;
import com.savemate.repository.AppSeoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppSeoService {

    private final AppSeoRepository seoRepository;

    public AppSeoService(AppSeoRepository seoRepository) {
        this.seoRepository = seoRepository;
    }

    public AppSeo getSeoByPage(String pageName) {
        return seoRepository.findByPageName(pageName)
                .orElse(new AppSeo(null, pageName, "Default Title", "Default Description", "default, keywords"));
    }

    public AppSeo updateSeo(String pageName, String title, String description, String keywords) {
        Optional<AppSeo> existingSeo = seoRepository.findByPageName(pageName);

        if (existingSeo.isPresent()) {
            AppSeo seo = existingSeo.get();
            seo.setSeoTitle(title);
            seo.setSeoDescription(description);
            seo.setSeoKeywords(keywords);
            return seoRepository.save(seo);
        } else {
            return seoRepository.save(new AppSeo(null, pageName, title, description, keywords));
        }
    }
}
