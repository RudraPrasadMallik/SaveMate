package com.savemate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.savemate.model.Advertisement;

public interface AdRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findByStatusTrueOrderByDisplayOrderAsc();
    List<Advertisement> findByStatusTrueAndTypeOrderByDisplayOrderAsc(String type);
}
