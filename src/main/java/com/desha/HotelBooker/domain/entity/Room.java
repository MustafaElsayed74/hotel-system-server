package com.desha.HotelBooker.domain.entity;

import com.desha.HotelBooker.domain.enums.RoomType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RoomType type;

    private Long price;

    private boolean isAvailable;

}
