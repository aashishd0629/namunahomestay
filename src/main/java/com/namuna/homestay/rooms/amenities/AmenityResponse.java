package com.namuna.homestay.rooms.amenities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmenityResponse {
    private Long id;
    private String title;
    private String status;
    private String icon;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private String createdBy;
    private String updatedBy;
    private String deletedBy;

    public static AmenityResponse fromEntity(Amenity amenity) {
        AmenityResponse response = new AmenityResponse();
        response.setId(amenity.getId());
        response.setTitle(amenity.getTitle());
        response.setStatus(String.valueOf(amenity.getStatus()));
        response.setIcon(amenity.getIcon());
        response.setCreatedAt(amenity.getCreatedAt());
        response.setUpdatedAt(amenity.getUpdatedAt());
        response.setDeletedAt(amenity.getDeletedAt());
        response.setCreatedBy(amenity.getCreatedBy());
        response.setUpdatedBy(amenity.getUpdatedBy());
        response.setDeletedBy(amenity.getDeletedBy());
        return response;
    }
}
