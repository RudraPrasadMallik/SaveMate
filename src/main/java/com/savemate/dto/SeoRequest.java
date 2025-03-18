package com.savemate.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeoRequest {
    private String title;
    private String description;
    private String keywords;
}
