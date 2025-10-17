package com.desha.HotelBooker.domain.dto;

import com.desha.HotelBooker.domain.enums.RoomType;
import lombok.Data;

@Data
public class RoomDto {

    private Long id;

    private String name;

    private RoomType type;

    private Long price;

    private boolean isAvailable;

}
