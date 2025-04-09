package com.savemate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "advertisements")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;      // For manual ad banner
    private String redirectUrl;   // For manual ad click link

    private boolean status;       // true = active

    private Integer displayOrder; // Priority order

    private String type;          // "manual" or "google"

    @Column(columnDefinition = "TEXT")
  //  @Basic(fetch = FetchType.EAGER)
    private String googleScript;  // Full Google Ads code snippet
    
}
