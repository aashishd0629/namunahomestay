package com.namuna.homestay.rooms.amenities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
@RequiredArgsConstructor
public class AmenityController {

    private final AmenityService amenityService;

    // Create new amenity
    @PostMapping
    public ResponseEntity<AmenityResponse> createAmenity(@RequestBody AmenityRequest request) {
        AmenityResponse response = amenityService.createAmenity(request);
        return ResponseEntity.ok(response);
    }

    // Get amenity by id
    @GetMapping("/{id}")
    public ResponseEntity<AmenityResponse> getAmenityById(@PathVariable Long id) {
        AmenityResponse response = amenityService.getAmenityById(id);
        return ResponseEntity.ok(response);
    }

    // Get all amenities
    @GetMapping
    public ResponseEntity<List<AmenityResponse>> getAllAmenities() {
        List<AmenityResponse> amenities = amenityService.getAllAmenities();
        return ResponseEntity.ok(amenities);
    }

    // Update amenity by id
    @PutMapping("/{id}")
    public ResponseEntity<AmenityResponse> updateAmenity(@PathVariable Long id, @RequestBody AmenityRequest request) {
        AmenityResponse response = amenityService.updateAmenity(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete amenity by id (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
        return ResponseEntity.noContent().build();
    }
}
