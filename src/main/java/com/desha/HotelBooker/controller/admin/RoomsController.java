package com.desha.HotelBooker.controller.admin;

import com.desha.HotelBooker.domain.dto.RoomDto;
import com.desha.HotelBooker.service.admin.rooms.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class RoomsController {

    private final RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<?> createRoom(@RequestBody RoomDto roomDto) {
        boolean success = roomService.createRoom(roomDto);
        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/rooms/{pageNumber}")
    public ResponseEntity<?>  getAllRooms(@PathVariable int pageNumber){
        return ResponseEntity.ok(roomService.getAllRooms(pageNumber));
    };
}
