package com.shravan.backend.controller;

import com.shravan.backend.dto.AuthResponse;
import com.shravan.backend.dto.LoginRequest;
import com.shravan.backend.dto.RegisterRequest;
import com.shravan.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ){
        String token = authService.login(request);

        return new AuthResponse(token);
    }
}
