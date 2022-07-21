package com.sparta.delivery.controller;

import com.sparta.delivery.domain.Menu;
import com.sparta.delivery.domain.Order;
import com.sparta.delivery.dto.OrderResponseDto;
import com.sparta.delivery.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrder(){
        return orderService.getOrder();
    }

    @PostMapping("/order/request")
    public OrderResponseDto orderFoods(@RequestBody Order order){
        return orderService.orderFoods(order);
    }

}