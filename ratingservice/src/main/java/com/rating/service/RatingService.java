package com.rating.service;

import com.rating.dto.RatingRequestDto;
import com.rating.dto.RatingResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    //create
    ResponseEntity<RatingResponseDto> create(RatingRequestDto ratingRequestDto);


    //get all ratings
    ResponseEntity<List<RatingResponseDto>> getRatings();

    //get all by UserId
    ResponseEntity<List<RatingResponseDto>> getRatingByUserId(Long userId);

    //get all by hotel
    ResponseEntity<List<RatingResponseDto>> getRatingByHotelId(Long hotelId);


}
