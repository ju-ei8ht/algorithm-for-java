package com.sparta.delivery.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponseDto {
    String restaurantName;
    List<MenuResponseDto> menus;
    int deliveryFee;
    int totalPrice;

    public OrderResponseDto(String restaurantName, List<MenuResponseDto> menus, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.menus = menus;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
