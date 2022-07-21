package com.sparta.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Menu> menus;
}
