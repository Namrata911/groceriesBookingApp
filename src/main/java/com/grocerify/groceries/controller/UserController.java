package com.grocerify.groceries.controller;

import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.model.Order;
import com.grocerify.groceries.model.OrderItem;
import com.grocerify.groceries.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/view-available-grocery-items")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<GroceryItem>> viewAvailableGroceryItems() {
        List<GroceryItem> availableItems = userService.viewAvailableGroceryItems();
        return new ResponseEntity<>(availableItems, HttpStatus.OK);
    }

    @PostMapping("/create-order")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Order> createOrder(@RequestBody List<OrderItem> orderItems) {
        Order order = userService.createOrder(orderItems);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}