package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    // Additional methods if needed
}
