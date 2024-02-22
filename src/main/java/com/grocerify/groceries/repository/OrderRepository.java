package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional methods if needed
}