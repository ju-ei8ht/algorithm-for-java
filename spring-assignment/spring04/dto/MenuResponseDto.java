package com.sparta.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuResponseDto {
    String name;
    int quantity;
    int price;
}
