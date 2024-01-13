package com.grocerify.groceries.service;

import com.grocerify.groceries.model.GroceryItem;

import java.util.List;

public interface AdminService {
    GroceryItem addGroceryItem(GroceryItem groceryItem);

    void removeGroceryItem(Long itemId);

    GroceryItem updateGroceryItem(Long itemId, GroceryItem updatedItem);

    void manageInventory(Long itemId, int quantity);

    List<GroceryItem> viewGroceryItems();
}
