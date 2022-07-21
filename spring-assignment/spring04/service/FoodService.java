package com.sparta.delivery.service;

import com.sparta.delivery.domain.Food;
import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public List<Food> list(Long restaurantId){
        restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("해당 음식점은 존재하지 않습니다.")
        );
        return foodRepository.findByRestaurantId(restaurantId);
    }

    @Transactional
    public void register(Long restaurantId, List<FoodRequestDto> requestDto){
        restaurantRepository.findById(restaurantId).orElseThrow(
                () -> new IllegalArgumentException("해당 음식점은 존재하지 않습니다.")
        );
        Food savedFood = new Food();
        for (FoodRequestDto foodRequestDto : requestDto) {
            String name = foodRequestDto.getName();
            int price = foodRequestDto.getPrice();
            if(!IsPresent(restaurantId,name)) throw new IllegalArgumentException("이미 해당 음식이 등록되어 있습니다.");
            if (!CkPrice(price)) throw new IllegalArgumentException("가격은 100원 ~ 1,000,000원까지 입력 가능합니다.");
            if (!UnitPrice(price)) throw new IllegalArgumentException("가격은 100원 단위로 입력해주세요.");
            Food food = new Food(foodRequestDto, restaurantId);
            savedFood = foodRepository.save(food);
        }
    }

    public boolean IsPresent(Long restaurantId,String name){
        List<Food> found = foodRepository.findByRestaurantIdAndName(restaurantId,name);
        return found.size() == 0;
    }
    public boolean CkPrice(int price){
        return price >= 100 && price <= 1000000;
    }
    public boolean UnitPrice(int price){
        return price % 100 == 0;
    }
}
