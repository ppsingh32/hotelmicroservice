package com.rating.mapper;

import com.rating.dto.HotelResponseDto;
import com.rating.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    Hotel hotelResponseDtoToHotel(HotelResponseDto hotelResponseDto);
}
