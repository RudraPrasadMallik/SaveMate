package com.savemate.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.savemate.model.Deals;

@Repository
public interface DealsRepository extends JpaRepository<Deals,Long> {

}
