package com.rating.serviceimpl;

import com.rating.dto.RatingRequestDto;
import com.rating.dto.RatingResponseDto;
import com.rating.exception.DataNotFoundException;
import com.rating.mapper.RatingMapper;
import com.rating.repository.RatingRepositorty;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingMapper ratingMapper;

    @Autowired
    RatingRepositorty repositorty;

    @Override
    public ResponseEntity<RatingResponseDto> create(RatingRequestDto ratingRequestDto) {
       return ResponseEntity.ok(ratingMapper.ratingToRatingResponseDto(repositorty.save(ratingMapper.ratingRequestDtotoRating(ratingRequestDto))));
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatings() {
        List<RatingResponseDto> allRat = repositorty.findAll().stream().map(rat -> ratingMapper.ratingToRatingResponseDto(rat)).collect(Collectors.toList());
        return ResponseEntity.ok(allRat);
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatingByUserId(Long userId) {
        List<RatingResponseDto> allRat = repositorty.findRatingByUserId(userId).stream().map(rat -> ratingMapper.ratingToRatingResponseDto(rat)).collect(Collectors.toList());
        if(allRat.isEmpty())
        {
            throw new DataNotFoundException("Ratings not found by userid");
        }else{
            return ResponseEntity.ok(allRat);
        }
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatingByHotelId(Long hotelId) {
        List<RatingResponseDto> allRat = repositorty.findRatingByHotelId(hotelId).stream().map(rat -> ratingMapper.ratingToRatingResponseDto(rat)).collect(Collectors.toList());
        if(allRat.isEmpty())
        {
            throw new DataNotFoundException("Ratings not found by hotelId");
        }else{
            return ResponseEntity.ok(allRat);
        }
    }
}
