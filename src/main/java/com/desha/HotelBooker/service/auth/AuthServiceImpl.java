package com.desha.HotelBooker.service.auth;

import com.desha.HotelBooker.domain.dto.SignUpRequest;
import com.desha.HotelBooker.domain.dto.UserDto;
import com.desha.HotelBooker.domain.entity.User;
import com.desha.HotelBooker.domain.enums.UserRoleEnum;
import com.desha.HotelBooker.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;


    @PostConstruct
    @Override
    public void createAdminAccount() {
        Optional<User> adminAccount = userRepository.findByUserRole(UserRoleEnum.ADMIN);
        if (adminAccount.isEmpty()) {
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("admin");
            user.setUserRole(UserRoleEnum.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
            System.out.println("Admin account created successfully");
        } else {
            System.out.println("Admin account already exists");
        }
    }

    @Override
    public UserDto createUser(SignUpRequest request) {

        if (userRepository.findFirstByEmail(request.getEmail()).isPresent()) {
            throw new EntityExistsException(
                    String.format("User with %s already exists", request.getName())
            );
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setUserRole(UserRoleEnum.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));

        User createdUser = userRepository.save(user);

        return createdUser.createUserDto();
    }


}
