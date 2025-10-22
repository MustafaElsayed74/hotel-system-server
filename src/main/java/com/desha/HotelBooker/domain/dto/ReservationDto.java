package com.desha.HotelBooker.domain.dto;
import com.desha.HotelBooker.domain.enums.ReservationStatus;
import com.desha.HotelBooker.domain.enums.RoomType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservationDto {

    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private Long price;

    private ReservationStatus reservationStatus;

    private Long roomId;

    private RoomType roomType;

    private Long userId;

    private String userName;
}
