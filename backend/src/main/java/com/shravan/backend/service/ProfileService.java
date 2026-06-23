package com.shravan.backend.service;

import com.shravan.backend.dto.ProfileRequest;
import com.shravan.backend.dto.ProfileResponse;

public interface ProfileService {

    ProfileResponse createProfile(ProfileRequest request);

    ProfileResponse getProfile();

    ProfileResponse updateProfile(ProfileRequest request);
}