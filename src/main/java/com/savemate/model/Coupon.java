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
    
     @Column
    private String imgUrl;
    @Column
    private String type;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String description;

    @Column
    private String discountCode;

    @Column
    private String slug;

    // SEO Fields
    @Column
    private String seoTitle;

    @Column
    private String seoDescription;

    @Column
    private String seoKeywords;
}
