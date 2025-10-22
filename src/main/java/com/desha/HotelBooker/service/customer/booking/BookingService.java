package com.desha.HotelBooker.service.customer.booking;

import com.desha.HotelBooker.domain.dto.ReservationDto;

public interface BookingService {

    boolean postReservation(ReservationDto reservationDto);

}
