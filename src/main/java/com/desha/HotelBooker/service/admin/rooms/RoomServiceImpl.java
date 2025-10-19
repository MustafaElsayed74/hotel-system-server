package com.desha.HotelBooker.service.admin.rooms;

import com.desha.HotelBooker.domain.dto.RoomDto;
import com.desha.HotelBooker.domain.dto.RoomResponseDto;
import com.desha.HotelBooker.domain.entity.Room;
import com.desha.HotelBooker.repository.RoomRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public boolean createRoom(RoomDto roomDto) {
        try {
            Room room = new Room();

            room.setName(roomDto.getName());
            room.setType(roomDto.getType());
            room.setPrice(roomDto.getPrice());
            room.setAvailable(true);

            roomRepository.save(room);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public RoomResponseDto getAllRooms(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,6);

        Page<Room> roomPage = roomRepository.findAll(pageable);

        RoomResponseDto roomResponseDto = new RoomResponseDto();

        roomResponseDto.setPageNumber(roomPage.getPageable().getPageNumber());
        roomResponseDto.setTotalPages(roomPage.getTotalPages());
        roomResponseDto.setRooms(roomPage.map(Room::getRoomDto).stream().toList());
        return roomResponseDto;
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if(room.isPresent()){
            return room.get().getRoomDto();
        }else{
            throw new EntityNotFoundException("Room not found.");
        }
    }
}
