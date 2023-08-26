package com.hotel.service.serviceimpl;

import com.hotel.service.dto.HotelRequestDto;
import com.hotel.service.dto.HotelResponseDto;
import com.hotel.service.exceptions.DataNotFoundException;
import com.hotel.service.mapper.HotelMapper;
import com.hotel.service.model.Hotel;
import com.hotel.service.repository.HotelRepositorty;
import com.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepositorty repositorty;

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public ResponseEntity<HotelResponseDto> create(HotelRequestDto hotelRequestDto) {
        Hotel saveHotel = repositorty.save(hotelMapper.hotelRequestDtoToHotel(hotelRequestDto));
        return ResponseEntity.ok(hotelMapper.hotelToHotelResponseDto(saveHotel));

    }

    @Override
    public ResponseEntity<List<HotelResponseDto>> getAll() {
        List<HotelResponseDto> hotels = repositorty.findAll().stream().map(rat -> hotelMapper.hotelToHotelResponseDto(rat)).collect(Collectors.toList());
        return ResponseEntity.ok(hotels);
    }

    @Override
    public ResponseEntity<HotelResponseDto> getHotelById(Long id) {
        Optional<Hotel> byId = repositorty.findById(id);
        if(byId.isPresent())
        {
            return ResponseEntity.ok(hotelMapper.hotelToHotelResponseDto(byId.get()));

        }else{
            throw new DataNotFoundException("Hotel not found by id");
        }
    }


}
