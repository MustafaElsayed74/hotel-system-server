package com.desha.HotelBooker.repository;

import com.desha.HotelBooker.domain.entity.User;
import com.desha.HotelBooker.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // First => the first matching result to this email
    Optional<User> findFirstByEmail(String email);
    Optional<User> findByUserRole(UserRoleEnum userRoleEnum);
}
