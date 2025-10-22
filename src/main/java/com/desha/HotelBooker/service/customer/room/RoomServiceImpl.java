package com.desha.HotelBooker.service.customer.room;

import com.desha.HotelBooker.domain.dto.RoomResponseDto;
import com.desha.HotelBooker.domain.entity.Room;
import com.desha.HotelBooker.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomResponseDto getAvilableRooms(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 6);

        Page<Room> roomPage = roomRepository.findByIsAvailable(true, pageable);

        RoomResponseDto roomResponseDto = new RoomResponseDto();

        roomResponseDto.setPageNumber(roomPage.getPageable().getPageNumber());
        roomResponseDto.setTotalPages(roomPage.getTotalPages());
        roomResponseDto.setRooms(roomPage.map(Room::getRoomDto).stream().toList());
        return roomResponseDto;
    }


}
