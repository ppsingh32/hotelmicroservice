package com.userservice.core;

import com.userservice.dto.RatingResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE", url = "http://localhost:8081/api/rating/")
public interface RatingService {

    @GetMapping("/users/{userId}")
    ResponseEntity<List<RatingResponseDto>> getRatingByUserId(@PathVariable("userId") Long userId);
}
