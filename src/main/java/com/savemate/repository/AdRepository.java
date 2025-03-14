package com.savemate.repository;

import com.savemate.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Advertisement, Long> {
}
