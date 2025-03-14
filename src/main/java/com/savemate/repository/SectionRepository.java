package com.savemate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savemate.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	 List<Section> findByStatusTrueOrderByOrderIndexAsc();
}
