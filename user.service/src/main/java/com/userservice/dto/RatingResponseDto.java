package com.userservice.dto;

import com.userservice.model.Hotel;
import lombok.Data;

@Data
public class RatingResponseDto {
    private Long id;
    private Long userId;
    private String hotelId;
    private  Long rating;
    private  String feedback;
    private Hotel hotel;

    public RatingResponseDto() {
    }

    public RatingResponseDto(Long id, Long userId, String hotelId, Long rating, String feedback, Hotel hotel) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "RatingResponseDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", hotelId='" + hotelId + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
