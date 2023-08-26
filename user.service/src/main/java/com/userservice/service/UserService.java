package com.userservice.service;

import com.userservice.dto.UserRequestDto;
import com.userservice.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

      ResponseEntity<List<UserResponseDto>> fetchAllUser();

      ResponseEntity<UserResponseDto> saveUser( UserRequestDto userRequestDto);

      ResponseEntity<UserResponseDto> fetchUserById(Long id);

      ResponseEntity<UserResponseDto> editUser(Long id, UserRequestDto userRequestDto);

      ResponseEntity<Boolean> deleteUser(Long id);


}
