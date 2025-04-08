package com.savemate.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     @Column(unique = true)
    private String imgUrl;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String discountCode;

    @Column(nullable = false, unique = true)
    private String slug;

    // SEO Fields
    @Column
    private String seoTitle;

    @Column
    private String seoDescription;

    @Column
    private String seoKeywords;
}
