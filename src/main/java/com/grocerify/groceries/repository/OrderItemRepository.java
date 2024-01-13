package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Additional methods if needed
}