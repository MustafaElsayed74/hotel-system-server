package com.desha.HotelBooker.service.customer.room;

import com.desha.HotelBooker.domain.dto.RoomResponseDto;

public interface RoomService {
    RoomResponseDto getAvilableRooms(int pageNumber);
}
