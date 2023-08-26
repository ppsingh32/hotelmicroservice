package com.hotel.service.controller;

import com.hotel.service.dto.HotelRequestDto;
import com.hotel.service.dto.HotelResponseDto;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //create

    @PostMapping
    public ResponseEntity<HotelResponseDto> createHotel(@RequestBody HotelRequestDto hotel) {
        return  hotelService.create(hotel);
    }


    //get single
    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelResponseDto> createHotel(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId);
    }


    @GetMapping
    public ResponseEntity<List<HotelResponseDto>> getAll(){
        return hotelService.getAll();
    }

}
