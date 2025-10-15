package com.desha.HotelBooker.service.auth;

import com.desha.HotelBooker.domain.dto.SignUpRequest;
import com.desha.HotelBooker.domain.dto.UserDto;
import com.desha.HotelBooker.domain.entity.User;

public interface AuthService {
    void createAdminAccount();
    UserDto createUser(SignUpRequest request);

}
