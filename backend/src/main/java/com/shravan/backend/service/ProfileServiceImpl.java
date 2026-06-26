package com.shravan.backend.service;

import com.shravan.backend.dto.ProfileRequest;
import com.shravan.backend.dto.ProfileResponse;
import com.shravan.backend.entity.Profile;
import com.shravan.backend.entity.User;
import com.shravan.backend.exception.BadRequestException;
import com.shravan.backend.exception.ProfileNotFoundException;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.repository.ProfileRepository;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final CurrentUserService currentUserService;


    @Override
    public ProfileResponse createProfile(ProfileRequest request) {

        User user =
                currentUserService.getCurrentUser();

        if (profileRepository.findByUser(user).isPresent()) {
            throw new BadRequestException(
                    "Profile already exists. Use update API."
            );
        }

        Profile profile = Profile.builder()
                .age(request.getAge())
                .gender(request.getGender())
                .height(request.getHeight())
                .currentWeight(request.getCurrentWeight())
                .startingWeight(request.getCurrentWeight())
                .targetWeight(request.getTargetWeight())
                .activityLevel(request.getActivityLevel())
                .fitnessGoal(request.getFitnessGoal())
                .workoutType(request.getWorkoutType())
                .user(user)
                .build();

        profileRepository.save(profile);

        return mapToResponse(profile);
    }

    @Override
    public ProfileResponse getProfile() {

        User user =
                currentUserService.getCurrentUser();

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() ->
                        new ProfileNotFoundException("Profile not found"));

        return mapToResponse(profile);
    }

    @Override
    public ProfileResponse updateProfile(ProfileRequest request) {

        User user =
                currentUserService.getCurrentUser();

        Profile profile = profileRepository.findByUser(user)
                .orElseThrow(() ->
                        new ProfileNotFoundException("Profile not found"));

        profile.setAge(request.getAge());
        profile.setGender(request.getGender());
        profile.setHeight(request.getHeight());
        profile.setCurrentWeight(request.getCurrentWeight());
        profile.setStartingWeight(request.getStartingWeight());
        profile.setTargetWeight(request.getTargetWeight());
        profile.setActivityLevel(request.getActivityLevel());
        profile.setFitnessGoal(request.getFitnessGoal());
        profile.setWorkoutType(request.getWorkoutType());

        profileRepository.save(profile);

        return mapToResponse(profile);
    }

    private ProfileResponse mapToResponse(Profile profile) {

        return ProfileResponse.builder()
                .id(profile.getId())
                .age(profile.getAge())
                .gender(profile.getGender())
                .height(profile.getHeight())
                .currentWeight(profile.getCurrentWeight())
                .startingWeight(profile.getStartingWeight())
                .targetWeight(profile.getTargetWeight())
                .activityLevel(profile.getActivityLevel())
                .fitnessGoal(profile.getFitnessGoal())
                .workoutType(profile.getWorkoutType())
                .build();
    }
}