package com.savemate.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SubmitCoupons")
public class SubmitCoupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long Id;
	
	private String MerchantName;
	
	private String CouponCode;
	
	private Date  ExpiaryDate;
	
	private String TermsConditions;
	
	private String Title;
	
	private String Description;

}
