package com.desha.HotelBooker.repository;

import com.desha.HotelBooker.domain.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Page<Room> findByIsAvailable(boolean available, Pageable pageable);
}
