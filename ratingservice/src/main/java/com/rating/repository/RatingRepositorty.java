package com.rating.repository;

import com.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepositorty extends JpaRepository<Rating, Long> {

    List<Rating> findRatingByUserId(Long userId);

    List<Rating> findRatingByHotelId(String hotelId);
}
