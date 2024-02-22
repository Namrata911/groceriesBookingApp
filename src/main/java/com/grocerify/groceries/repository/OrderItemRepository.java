package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Additional methods if needed
}