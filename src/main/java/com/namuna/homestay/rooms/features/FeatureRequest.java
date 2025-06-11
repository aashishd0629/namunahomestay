package com.namuna.homestay.rooms.features;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FeatureRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Status is required")
    private String status; // Expected values: ACTIVE or INACTIVE

    private String createdBy;
    private String updatedBy;
}