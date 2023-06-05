package com.example.jpa.repository;

import com.example.jpa.domain.Order;
import com.example.jpa.domain.OrderItem;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }

    public Order findOne(Long id) {
        return entityManager.find(Order.class, id);
    }

    // public List<Order> findAll(OrderSearch orderSearch){}
}
