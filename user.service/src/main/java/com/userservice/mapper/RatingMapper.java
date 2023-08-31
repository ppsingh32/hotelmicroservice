package com.userservice.mapper;

import com.userservice.dto.RatingResponseDto;
import com.userservice.model.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingResponseDto ratingToRatingResponseDto(Rating entity);
    Rating ratingResponseDtoToRating(RatingResponseDto ratingResponseDto);
}
