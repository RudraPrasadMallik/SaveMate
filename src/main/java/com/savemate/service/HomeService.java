package com.savemate.service;

import com.savemate.model.Advertisement;
import com.savemate.model.Section;
import com.savemate.repository.AdRepository;
import com.savemate.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private SectionRepository sectionRepository;

    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
}
