package com.sparta.delivery.controller;

import com.sparta.delivery.domain.Food;
import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId){
        return foodService.list(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto){
        foodService.register(restaurantId,requestDto);
    }
}