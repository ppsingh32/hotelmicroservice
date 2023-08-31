package com.hotel.service.repository;

import com.hotel.service.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepositorty extends MongoRepository<Hotel, String> {

}
