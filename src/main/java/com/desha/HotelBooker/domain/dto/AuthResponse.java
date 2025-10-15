package com.desha.HotelBooker.domain.dto;

import com.desha.HotelBooker.domain.enums.UserRoleEnum;
import lombok.Data;

@Data
public class AuthResponse {

    private String jwt;

    private Long userId;

    private UserRoleEnum userRole;



}
