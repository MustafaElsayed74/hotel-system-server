package com.desha.HotelBooker.domain.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoomResponseDto {

    List<RoomDto> rooms = new ArrayList<>();

    private Integer totalPages;

    private Integer pageNumber;


}
