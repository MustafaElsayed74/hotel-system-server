package com.desha.HotelBooker.service.admin.rooms;


import com.desha.HotelBooker.domain.dto.RoomDto;
import com.desha.HotelBooker.domain.dto.RoomResponseDto;

public interface RoomService {

    boolean createRoom(RoomDto roomDto);

    RoomResponseDto getAllRooms(int pageNumber);

    RoomDto getRoomById(Long id);

    boolean updateRoom(Long id , RoomDto roomDto);
}
