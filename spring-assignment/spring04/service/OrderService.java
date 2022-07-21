package com.sparta.delivery.service;

import com.sparta.delivery.domain.Menu;
import com.sparta.delivery.domain.Order;
import com.sparta.delivery.dto.MenuResponseDto;
import com.sparta.delivery.dto.OrderResponseDto;
import com.sparta.delivery.repository.MenuMapping;
import com.sparta.delivery.repository.OrderRepository;
import com.sparta.delivery.repository.RestaurantMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    //get
    public List<OrderResponseDto> getOrder() {
        List<Order> orders = orderRepository.findAll();
//        if(orders.isEmpty()) throw new IllegalArgumentException("주문이 없습니다.");

        List<OrderResponseDto> responseDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderResponseDto responseDto = getOrderResponseDto(order);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

    //post
    @Transactional
    public OrderResponseDto orderFoods(Order order) {
        for (Menu menu : order.getMenus()) {
            menu.setOrder(order);
//            order.getMenus().add(menu);
        }
        orderRepository.save(order);

        return getOrderResponseDto(order);
    }

    private OrderResponseDto getOrderResponseDto(Order order) {
        List<MenuResponseDto> menuResponseDtos = new ArrayList<>();
        int totalPrice = 0;
        int deliveryFee = 0;
        int minOrderPrice = 0;
        String restaurantName = "";
        List<MenuMapping> menus = orderRepository.findMenusById(order.getId());
        List<RestaurantMapping> restaurants = orderRepository.findRestaurantById(order.getId());
        for (RestaurantMapping restaurant : restaurants) {
            restaurantName = restaurant.getRestaurantName();
            deliveryFee = restaurant.getRestaurantDeliveryFee();
            minOrderPrice = restaurant.getRestaurantMinOrderPrice();
        }
        for (MenuMapping menu : menus) {
            String name = menu.getMenusFoodName();
            int price = menu.getMenusFoodPrice();
            int quantity = menu.getMenusQuantity();
            if (quantity < 1 || quantity > 100) throw new IllegalArgumentException("수량은 1 ~ 100개까지 가능합니다.");
            price *= quantity;
            totalPrice += price;
            if(totalPrice < minOrderPrice) throw new IllegalArgumentException("주문 금액이 최소 주문 금액보다 작습니다.");
            MenuResponseDto menuResponseDto = new MenuResponseDto(name, quantity, price);
            menuResponseDtos.add(menuResponseDto);
        }
        totalPrice += deliveryFee;
        return new OrderResponseDto(restaurantName, menuResponseDtos, deliveryFee, totalPrice);
    }
}
