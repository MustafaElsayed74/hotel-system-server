package com.desha.HotelBooker.controller.auth;

import com.desha.HotelBooker.domain.dto.SignUpRequest;
import com.desha.HotelBooker.domain.dto.UserDto;
import com.desha.HotelBooker.service.auth.AuthService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signInUser(@RequestBody SignUpRequest  request){
        try {
            UserDto createdUser = authService.createUser(request);
            return ResponseEntity.ok(createdUser);
        }
        catch (EntityExistsException  ex){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
    }
}
