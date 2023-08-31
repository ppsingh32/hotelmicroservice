package com.rating.core;

import com.rating.dto.HotelResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE", url = "http://localhost:8083/api/hotel")
public interface HotelService {

    @GetMapping("/{hotelId}")
    ResponseEntity<HotelResponseDto> getHotel(@PathVariable("hotelId") String hotelId);

}
