package com.rating.dto;

import lombok.Data;

@Data
public class RatingRequestDto {
    private Long id;
    private Long userId;
    private String hotelId;
    private  Long rating;
    private  String feedback;

    public RatingRequestDto() {
    }

    public RatingRequestDto(Long id, Long userId, String hotelId, Long rating, String feedback) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedback = feedback;
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

    @Override
    public String toString() {
        return "RatingRequestDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", hotelId='" + hotelId + '\'' +
                ", rating=" + rating +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
