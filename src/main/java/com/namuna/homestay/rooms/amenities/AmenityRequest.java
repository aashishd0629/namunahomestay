package com.namuna.homestay.rooms.amenities;

import com.namuna.homestay.rooms.amenities.Amenity.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AmenityRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Status is required")
    private Status status;

    private String icon;
    private String createdBy;
    private String updatedBy;
}
