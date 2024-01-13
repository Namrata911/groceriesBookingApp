package com.grocerify.groceries.repository;

import com.grocerify.groceries.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
    // Additional methods if needed
}
