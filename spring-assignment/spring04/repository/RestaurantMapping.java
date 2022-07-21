package com.sparta.delivery.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface RestaurantMapping {
    String getRestaurantName();

    @JsonIgnore
    int getRestaurantMinOrderPrice();

    @JsonProperty("deliveryFee")
    int getRestaurantDeliveryFee();
}
