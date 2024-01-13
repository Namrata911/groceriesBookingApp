package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional methods if needed
}