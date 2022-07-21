package com.sparta.delivery.repository;

import com.sparta.delivery.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<RestaurantMapping> findRestaurantById(Long id);
    List<MenuMapping> findMenusById(Long id);
}
