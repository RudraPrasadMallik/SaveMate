package com.savemate.repository;

import com.savemate.model.AppSeo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppSeoRepository extends JpaRepository<AppSeo, Long> {
    Optional<AppSeo> findByPageName(String pageName);
}
