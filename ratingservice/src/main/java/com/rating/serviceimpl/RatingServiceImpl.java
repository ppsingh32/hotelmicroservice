package com.rating.serviceimpl;

import com.rating.core.HotelService;
import com.rating.dto.HotelResponseDto;
import com.rating.dto.RatingRequestDto;
import com.rating.dto.RatingResponseDto;
import com.rating.exception.DataNotFoundException;
import com.rating.mapper.HotelMapper;
import com.rating.mapper.RatingMapper;
import com.rating.model.Hotel;
import com.rating.model.Rating;
import com.rating.repository.RatingRepositorty;
import com.rating.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    public static final Logger logger= LoggerFactory.getLogger(RatingServiceImpl.class);
    @Autowired
    RatingMapper ratingMapper;

    @Autowired
    RatingRepositorty repositorty;

    @Autowired
    HotelService hotelService;

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public ResponseEntity<RatingResponseDto> create(RatingRequestDto ratingRequestDto) {
        logger.info("ratingRequestDto: {} ",ratingRequestDto);
        Rating savedRating = repositorty.save(ratingMapper.ratingRequestDtotoRating(ratingRequestDto));
        logger.info("savedRating: {} ",savedRating);
        return ResponseEntity.ok(ratingMapper.ratingToRatingResponseDto(savedRating));
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatings() {
        List<RatingResponseDto> allRat = repositorty.findAll().stream().map(rat -> ratingMapper.ratingToRatingResponseDto(rat)).collect(Collectors.toList());

        return ResponseEntity.ok(allRat);
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatingByUserId(Long userId) {
//        logger.info("userId: {} ",userId);
        List<Rating> ratingByUserId = repositorty.findRatingByUserId(userId);
//        logger.info("ratingByUserId: {} ",ratingByUserId);
        List<RatingResponseDto> allRat = ratingByUserId.stream().map(rat -> {
            String hotelId = rat.getHotelId();
            // ********* get the hotel from hotel service
            ResponseEntity<HotelResponseDto> hotelWithResponse = hotelService.getHotel(hotelId);
            if(hotelWithResponse.getStatusCode()== HttpStatus.OK)
            {
                HotelResponseDto hotel = hotelWithResponse.getBody();
                Hotel finalHotel = hotelMapper.hotelResponseDtoToHotel(hotel);
//                logger.info("finalHotel :{}",finalHotel);
                if(finalHotel!=null)
                     rat.setHotel(finalHotel);
            }
//            logger.info("this is rat :{}",rat);
            RatingResponseDto ratingResponseDto = ratingMapper.ratingToRatingResponseDto(rat);
//            logger.info("ratingResponseDto :{}",ratingResponseDto);
            return ratingResponseDto;
        }).collect(Collectors.toList());
        
        
//        logger.info("thsis is list dd: {} ",allRat);
        if(allRat.isEmpty())
        {
            throw new DataNotFoundException("Ratings not found by userid");
        }else{
//            logger.info("thsis is list: {} ",allRat);
            return ResponseEntity.ok(allRat);
        }
    }

    @Override
    public ResponseEntity<List<RatingResponseDto>> getRatingByHotelId(String hotelId) {
        List<RatingResponseDto> allRat = repositorty.findRatingByHotelId(hotelId).stream().map(rat -> ratingMapper.ratingToRatingResponseDto(rat)).collect(Collectors.toList());
        if(allRat.isEmpty())
        {
            throw new DataNotFoundException("Ratings not found by hotelId");
        }else{
            return ResponseEntity.ok(allRat);
        }
    }
}
