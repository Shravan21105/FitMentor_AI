package com.shravan.backend.service;

import com.shravan.backend.entity.User;
import com.shravan.backend.exception.UserNotFoundException;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserService {

    private final UserRepository userRepository;

    public User getCurrentUser() {

        String email =
                SecurityUtils.getCurrentUserEmail();

        return userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found"
                        ));
    }
}