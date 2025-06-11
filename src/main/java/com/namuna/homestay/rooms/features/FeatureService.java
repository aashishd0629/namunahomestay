package com.namuna.homestay.rooms.features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    private final FeatureRepository featureRepository;

    @Autowired
    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public FeatureResponse createFeature(FeatureRequest request) {
        Feature feature = new Feature();
        feature.setTitle(request.getTitle());
        feature.setStatus(Feature.Status.valueOf(request.getStatus()));
        feature.setCreatedAt(LocalDateTime.now());
        feature.setCreatedBy("system"); // Replace with actual user info in real apps

        Feature saved = featureRepository.save(feature);
        return FeatureResponse.fromEntity(saved);
    }

    public List<FeatureResponse> getAllFeatures() {
        return featureRepository.findAll()
                .stream()
                .map(FeatureResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public FeatureResponse getFeatureById(Long id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found with ID: " + id));
        return FeatureResponse.fromEntity(feature);
    }

    public FeatureResponse updateFeature(Long id, FeatureRequest request) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found with ID: " + id));

        feature.setTitle(request.getTitle());
        feature.setStatus(Feature.Status.valueOf(request.getStatus()));
        feature.setUpdatedAt(LocalDateTime.now());
        feature.setUpdatedBy("system"); // Replace with actual user info

        Feature updated = featureRepository.save(feature);
        return FeatureResponse.fromEntity(updated);
    }

    public void deleteFeature(Long id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found with ID: " + id));

        feature.setDeletedAt(LocalDateTime.now());
        feature.setDeletedBy("system"); // Replace with actual user info

        featureRepository.save(feature);
    }
}
