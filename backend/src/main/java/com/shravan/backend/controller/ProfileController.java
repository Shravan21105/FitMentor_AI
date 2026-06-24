package com.shravan.backend.controller;

import com.shravan.backend.dto.ProfileRequest;
import com.shravan.backend.dto.ProfileResponse;
import com.shravan.backend.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ProfileResponse createProfile(
            @Valid @RequestBody ProfileRequest request
    ) {

        System.out.println("PROFILE API HIT");

        return profileService.createProfile(request);
    }

    @PutMapping
    public ProfileResponse updateProfile(
            @Valid @RequestBody ProfileRequest request
    ) {
        return profileService.updateProfile(request);
    }
    @GetMapping
    public ProfileResponse getProfile() {
        return profileService.getProfile();
    }

}