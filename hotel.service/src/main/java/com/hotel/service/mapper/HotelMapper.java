package com.hotel.service.mapper;

import com.hotel.service.dto.HotelRequestDto;
import com.hotel.service.dto.HotelResponseDto;
import com.hotel.service.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    Hotel hotelRequestDtoToHotel(HotelRequestDto hotelRequestDto);

    HotelResponseDto hotelToHotelResponseDto(Hotel hotel);
}
