package com.hotel.service.service;

import com.hotel.service.dto.HotelRequestDto;
import com.hotel.service.dto.HotelResponseDto;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    ResponseEntity<HotelResponseDto> create(HotelRequestDto hotelRequestDto);

    ResponseEntity<List<HotelResponseDto>> getAll();

    ResponseEntity<HotelResponseDto> getHotelById(String id);

}
