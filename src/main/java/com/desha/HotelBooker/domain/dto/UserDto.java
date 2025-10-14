package com.desha.HotelBooker.domain.dto;

import com.desha.HotelBooker.domain.enums.UserRoleEnum;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private UserRoleEnum userRole;


}
