package com.savemate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SubmitMerchants")
public class SubmitMerchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long Id;
	
	private String MerchantName;
	
	private String MerchantUrl;
	
	private String Email;
	
	private String Mobile;

}
