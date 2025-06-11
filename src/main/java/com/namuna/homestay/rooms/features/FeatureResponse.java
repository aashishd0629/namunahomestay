package com.namuna.homestay.rooms.features;


import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureResponse {
    private Long id;
    private String title;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;


    public static FeatureResponse fromEntity(Feature feature) {
        FeatureResponse response = new FeatureResponse();
        response.setId(feature.getId());
        response.setTitle(feature.getTitle());
        response.setStatus(String.valueOf(feature.getStatus()));
        response.setCreatedAt(feature.getCreatedAt());
        response.setUpdatedAt(feature.getUpdatedAt());
        response.setDeletedAt(feature.getDeletedAt());
        response.setCreatedBy(feature.getCreatedBy());
        response.setUpdatedBy(feature.getUpdatedBy());
        response.setDeletedBy(feature.getDeletedBy());
        return response;
    }
}