package com.rating.dto;

import lombok.Data;

@Data
public class RatingRequestDto {
    private Long ratingId;

    private Long userId;

    private Long hotelId;

    private  int rating;

    private  String feedback;
    public RatingRequestDto() {
    }

    public RatingRequestDto(Long ratingId, Long userId, Long hotelId, int rating, String feedback) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "RatingRequestDto{" +
                "ratingId=" + ratingId +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
