package com.sparta.delivery.service;

import com.sparta.delivery.domain.Restaurant;
import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> list(){
        return restaurantRepository.findAll();
    }

    @Transactional
    public Restaurant create(RestaurantRequestDto requestDto){
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if(!UnitMinOrderPrice(minOrderPrice)) {
            throw new IllegalArgumentException("최소주문 가격은 100원 단위로 입력해주세요.");
        }
        if(!CkMinOrderPrice(minOrderPrice)){
            throw new IllegalArgumentException("최소주문 가격은 1,000원 ~ 100,000원까지 입력 가능합니다.");
        }

        if(!UnitDeliveryFee(deliveryFee)) {
            throw new IllegalArgumentException("기본 배달비는 500원 단위로 입력해주세요.");
        }
        if(!CkDeliveryFee(deliveryFee)) {
            throw new IllegalArgumentException("기본 배달비는 0원 ~ 10,000원까지 입력 가능합니다.");
        }

        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantRepository.save(restaurant);
    }

    public boolean UnitMinOrderPrice(int minOrderPrice){
        return minOrderPrice % 100 == 0;
    }
    public boolean CkMinOrderPrice(int minOrderPrice){
        return minOrderPrice >= 1000 && minOrderPrice <= 100000;
    }
    public boolean UnitDeliveryFee(int deliveryFee){
        return deliveryFee % 500 == 0;
    }
    public boolean CkDeliveryFee(int deliveryFee){
        return deliveryFee >= 0 && deliveryFee <= 10000;
    }
}