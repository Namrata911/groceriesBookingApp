package com.grocerify.groceries.service;

import com.grocerify.groceries.exception.ItemNotFoundException;
import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> viewGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public void removeGroceryItem(Long itemId) {
        groceryItemRepository.deleteById(itemId);
    }

    public GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem) {
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(itemId);
        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            return groceryItemRepository.save(existingItem);
        } else {
            throw new ItemNotFoundException("Grocery item not found with ID: " + itemId);
        }
    }

    public void manageInventory(Long itemId, int quantity) {
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(itemId);
        if (existingItemOptional.isPresent()) {
            GroceryItem existingItem = existingItemOptional.get();
            existingItem.setQuantityInStock(quantity);
            groceryItemRepository.save(existingItem);
        } else {
            throw new ItemNotFoundException("Grocery item not found with ID: " + itemId);
        }

    }
}