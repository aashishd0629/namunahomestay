package com.namuna.homestay.rooms.amenities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenityService {

    private final AmenityRepository amenityRepository;

    @Autowired
    public AmenityService(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    public AmenityResponse createAmenity(AmenityRequest request) {
        Amenity amenity = new Amenity();
        amenity.setTitle(request.getTitle());
        amenity.setStatus(Amenity.Status.valueOf(String.valueOf(request.getStatus())));
        amenity.setIcon(request.getIcon());
        amenity.setCreatedAt(LocalDateTime.now());
        amenity.setCreatedBy("system"); // Replace with actual user info in real apps

        Amenity saved = amenityRepository.save(amenity);
        return AmenityResponse.fromEntity(saved);
    }

    public List<AmenityResponse> getAllAmenities() {
        return amenityRepository.findAll()
                .stream()
                .filter(a -> a.getDeletedAt() == null) // exclude soft deleted
                .map(AmenityResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public AmenityResponse getAmenityById(Long id) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found with ID: " + id));
        if (amenity.getDeletedAt() != null) {
            throw new RuntimeException("Amenity with ID: " + id + " is deleted");
        }
        return AmenityResponse.fromEntity(amenity);
    }

    public AmenityResponse updateAmenity(Long id, AmenityRequest request) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found with ID: " + id));
        if (amenity.getDeletedAt() != null) {
            throw new RuntimeException("Amenity with ID: " + id + " is deleted");
        }

        amenity.setTitle(request.getTitle());
        amenity.setStatus(Amenity.Status.valueOf(String.valueOf(request.getStatus())));
        amenity.setIcon(request.getIcon());
        amenity.setUpdatedAt(LocalDateTime.now());
        amenity.setUpdatedBy("system"); // Replace with actual user info

        Amenity updated = amenityRepository.save(amenity);
        return AmenityResponse.fromEntity(updated);
    }

    public void deleteAmenity(Long id) {
        Amenity amenity = amenityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenity not found with ID: " + id));

        amenity.setDeletedAt(LocalDateTime.now());
        amenity.setDeletedBy("system"); // Replace with actual user info

        amenityRepository.save(amenity);
    }
}
