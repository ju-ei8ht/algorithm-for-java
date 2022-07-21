package com.sparta.delivery.domain;

import com.sparta.delivery.dto.FoodRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private Long restaurantId;
    @Column(nullable = false)
   private String name;
    @Column(nullable = false)
    private int price;

    public Food(FoodRequestDto requestDto, Long restaurantId){
        this.restaurantId = restaurantId;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
