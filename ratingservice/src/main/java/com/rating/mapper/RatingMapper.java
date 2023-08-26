package com.rating.mapper;

import com.rating.dto.RatingRequestDto;
import com.rating.dto.RatingResponseDto;
import com.rating.model.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    Rating ratingRequestDtotoRating(RatingRequestDto ratingRequestDto);

    RatingResponseDto ratingToRatingResponseDto(Rating rating);
}
