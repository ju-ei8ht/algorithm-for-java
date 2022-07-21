package com.sparta.delivery.controller;

import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.repository.RestaurantRepository;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantService.list();
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.create(requestDto);
    }
}
