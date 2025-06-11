package com.namuna.homestay.rooms.features;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    // Create new feature
    @PostMapping
    public ResponseEntity<FeatureResponse> createFeature(@RequestBody FeatureRequest request) {
        FeatureResponse response = featureService.createFeature(request);
        return ResponseEntity.ok(response);
    }

    // Get feature by id
    @GetMapping("/{id}")
    public ResponseEntity<FeatureResponse> getFeatureById(@PathVariable Long id) {
        FeatureResponse response = featureService.getFeatureById(id);
        return ResponseEntity.ok(response);
    }

    // Get all features
    @GetMapping
    public ResponseEntity<List<FeatureResponse>> getAllFeatures() {
        List<FeatureResponse> features = featureService.getAllFeatures();
        return ResponseEntity.ok(features);
    }

    // Update feature by id
    @PutMapping("/{id}")
    public ResponseEntity<FeatureResponse> updateFeature(@PathVariable Long id, @RequestBody FeatureRequest request) {
        FeatureResponse response = featureService.updateFeature(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete feature by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}