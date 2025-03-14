package com.savemate.service;

import com.savemate.model.Advertisement;
import com.savemate.model.Section;
import com.savemate.repository.AdRepository;
import com.savemate.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private SectionRepository sectionRepository;

    // ================== Advertisement Methods ==================

    public Advertisement saveAd(Advertisement ad) {
        return adRepository.save(ad);
    }

    public List<Advertisement> getAllAds() {
        return adRepository.findAll();
    }

    public Advertisement updateAd(Long id, Advertisement newAdDetails) {
        return adRepository.findById(id).map(ad -> {
            ad.setImageUrl(newAdDetails.getImageUrl());
            ad.setRedirectUrl(newAdDetails.getRedirectUrl());
            return adRepository.save(ad);
        }).orElseThrow(() -> new RuntimeException("Advertisement not found with ID: " + id));
    }

    public String deleteAd(Long id) {
        if (adRepository.existsById(id)) {
            adRepository.deleteById(id);
            return "Advertisement deleted successfully!";
        }
        throw new RuntimeException("Advertisement not found with ID: " + id);
    }

    // ================== Section Methods ==================

    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    // ✅ Get only active sections (For homepage)
    public List<Section> getActiveSections() {
        return sectionRepository.findByStatusTrueOrderByOrderIndexAsc();
    }

    public Section updateSection(Long id, Section newSectionDetails) {
        return sectionRepository.findById(id).map(section -> {
            section.setTitle(newSectionDetails.getTitle());
            section.setDescription(newSectionDetails.getDescription());
            section.setOrderIndex(newSectionDetails.getOrderIndex()); // ✅ Update orderIndex
            section.setStatus(newSectionDetails.isStatus()); // ✅ Update status
            return sectionRepository.save(section);
        }).orElseThrow(() -> new RuntimeException("Section not found with ID: " + id));
    }

    public String deleteSection(Long id) {
        if (sectionRepository.existsById(id)) {
            sectionRepository.deleteById(id);
            return "Section deleted successfully!";
        }
        throw new RuntimeException("Section not found with ID: " + id);
    }
}