package com.rating.controller;

import com.rating.dto.RatingRequestDto;
import com.rating.dto.RatingResponseDto;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PostMapping
    public ResponseEntity<RatingResponseDto> create(@RequestBody RatingRequestDto ratingRequestDto) {
        return  ratingService.create(ratingRequestDto);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<RatingResponseDto>> getRatings() {
        return ratingService.getRatings();
    }

    //get all of user
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingResponseDto>> getRatingsByUserId(@PathVariable Long userId) {
        return ratingService.getRatingByUserId(userId);
    }

    //get all of hotels
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingResponseDto>> getRatingsByHotelId(@PathVariable Long hotelId) {
        return ratingService.getRatingByHotelId(hotelId);
    }

}
