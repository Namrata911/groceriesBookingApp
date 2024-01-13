package com.grocerify.groceries.service;

import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.model.Order;
import com.grocerify.groceries.model.OrderItem;
import com.grocerify.groceries.repository.GroceryItemRepository;
import com.grocerify.groceries.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<GroceryItem> viewAvailableGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Order createOrder(List<OrderItem> orderItems) {
        Order order = new Order();
        order.setOrderItems(orderItems);
        // Set the order reference in each order item
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }
        return orderRepository.save(order);
    }
}
