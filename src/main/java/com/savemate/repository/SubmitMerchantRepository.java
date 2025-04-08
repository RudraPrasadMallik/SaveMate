package com.savemate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.savemate.model.SubmitMerchant;

@Repository
public interface SubmitMerchantRepository extends JpaRepository<SubmitMerchant, Long> {

}
