package com.grocerify.groceries.service;

import com.grocerify.groceries.exception.ItemNotFoundException;
import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{
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
        // Implement update logic based on your requirements
        // Fetch the existing grocery item from the repository
        Optional<GroceryItem> existingItemOptional = groceryItemRepository.findById(itemId);

        if (existingItemOptional.isPresent()) {
            // If the item exists, update its fields
            GroceryItem existingItem = existingItemOptional.get();

            // Update the fields with new values from the updatedItem
            existingItem.setName(updatedItem.getName());
            existingItem.setPrice(updatedItem.getPrice());
            // Update other fields as needed

            // Save the updated item back to the repository
           return groceryItemRepository.save(existingItem);
        } else {
            // Handle the case where the item with the given ID is not found
            throw new ItemNotFoundException("Grocery item not found with ID: " + itemId);
        }

    }

    public void manageInventory(Long itemId, int quantity) {
        // Implement inventory management logic based on your requirements
    }
}