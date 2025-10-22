package com.desha.HotelBooker.repository;

import com.desha.HotelBooker.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long> {


}
