package com.userservice.model;


import lombok.Builder;

import java.time.Instant;

@Builder
public class Rating {
    private  Long id;
    private Long userId;
    private Long hotelId;
    private int rating;
    private String feedBack;

    public Rating() {
    }

    public Rating(Long id, Long userId, Long hotelId, int rating, String feedBack, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.rating = rating;
        this.feedBack = feedBack;

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

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }



    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                ", rating=" + rating +
                ", feedBack='" + feedBack + '\'' +
                '}';
    }
}
