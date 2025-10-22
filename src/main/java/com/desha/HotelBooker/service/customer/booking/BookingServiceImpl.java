package com.desha.HotelBooker.service.customer.booking;

import com.desha.HotelBooker.domain.dto.ReservationDto;
import com.desha.HotelBooker.domain.entity.Reservation;
import com.desha.HotelBooker.domain.entity.Room;
import com.desha.HotelBooker.domain.entity.User;
import com.desha.HotelBooker.repository.ReservationRepository;
import com.desha.HotelBooker.repository.RoomRepository;
import com.desha.HotelBooker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;


    @Override
    public boolean postReservation(ReservationDto reservationDto) {
        Optional<User> user = userRepository.findById(reservationDto.getUserId());
        Optional<Room> room = roomRepository.findById(reservationDto.getRoomId());
        if (user.isPresent() && room.isPresent()) {

            Reservation reservation = new Reservation();

            reservation.setRoom(room.get());
            reservation.setUser(user.get());
            reservation.setPrice(reservationDto.getPrice());
            reservation.setCheckInDate(reservationDto.getCheckInDate());
            reservation.setCheckOutDate(reservationDto.getCheckOutDate());
            reservationRepository.save(reservation);
            return true;
        }
        return false;
    }
}
