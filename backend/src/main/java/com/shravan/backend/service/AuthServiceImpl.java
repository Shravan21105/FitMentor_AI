package com.shravan.backend.service;

import com.shravan.backend.dto.LoginRequest;
import com.shravan.backend.dto.RegisterRequest;
import com.shravan.backend.entity.PlanType;
import com.shravan.backend.entity.Role;
import com.shravan.backend.entity.Subscription;
import com.shravan.backend.entity.User;
import com.shravan.backend.exception.BadRequestException;
import com.shravan.backend.repository.UserRepository;
import com.shravan.backend.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public String register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new BadRequestException("Email Already Exists");
        }

        Subscription subscription = Subscription.builder()
                .planType(PlanType.FREE)
                .startDate(LocalDate.now())
                .active(true)
                .build();

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .subscription(subscription)
                .build();


        userRepository.save(user);

        return "User Registered Successfully";
    }

    @Override
    public String login(LoginRequest request){
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new BadRequestException("Invalid Credentials"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if(!matches){
            throw new BadRequestException("Invalid Credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }

}
