package com.grocerify.groceries.service;

import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.model.Order;
import com.grocerify.groceries.model.OrderItem;

import java.util.List;

public interface UserService {
    Order createOrder(List<OrderItem> orderItems);

    List<GroceryItem> viewAvailableGroceryItems();
}
