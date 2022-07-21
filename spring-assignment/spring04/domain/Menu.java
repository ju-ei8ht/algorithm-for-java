package com.sparta.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDER_ID", nullable = false)
    @JsonIgnore
    private Order order;

    @OneToOne
    @JoinColumn(name = "FOOD_ID", nullable = false)
    private Food food;

    @Column(nullable = false)
    private int quantity;

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }
}
