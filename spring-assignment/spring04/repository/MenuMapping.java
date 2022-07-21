package com.sparta.delivery.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface MenuMapping {
    @JsonProperty("name")
    String getMenusFoodName();
    @JsonProperty("quantity")
    int getMenusQuantity();
    @JsonProperty("price")
    int getMenusFoodPrice();
}
