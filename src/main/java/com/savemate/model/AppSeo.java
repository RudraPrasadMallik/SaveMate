package com.savemate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_seo")
public class AppSeo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pageName;  // E.g., "home", "about", "contact"

    @Column(nullable = false)
    private String seoTitle;

    @Column(nullable = false)
    private String seoDescription;

    @Column(nullable = false)
    private String seoKeywords;
}
