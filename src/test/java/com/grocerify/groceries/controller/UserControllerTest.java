package com.grocerify.groceries.controller;

import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.model.Order;
import com.grocerify.groceries.model.OrderItem;
import com.grocerify.groceries.model.User;
import com.grocerify.groceries.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testViewAvailableGroceryItems() {
        // Mock data
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setName("book");
        groceryItem.setPrice(new BigDecimal(200));
        groceryItem.setId(1L);
        groceryItem.setQuantityInStock(22);
        List<GroceryItem> mockItems = Arrays.asList(
                groceryItem
        );

        // Mock the userService.viewAvailableGroceryItems() method
        when(userService.viewAvailableGroceryItems()).thenReturn(mockItems);

        // Call the controller method
        ResponseEntity<List<GroceryItem>> response = userController.viewAvailableGroceryItems();

        // Verify the results
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockItems, response.getBody());
        verify(userService, times(1)).viewAvailableGroceryItems();
    }

    @Test
    void testCreateOrder() {
        GroceryItem groceryItem = new GroceryItem();
        groceryItem.setName("book");
        groceryItem.setPrice(new BigDecimal(200));
        groceryItem.setId(1L);
        groceryItem.setQuantityInStock(22);
        OrderItem orderItem1 = new OrderItem(1l,new GroceryItem(),null,20);
        OrderItem orderItem2 = new OrderItem(2l,new GroceryItem(),null,10);
        // Mock data
        List<OrderItem> mockOrderItems = Arrays.asList(
                orderItem1,
               orderItem2
        );
        Order mockOrder = new Order(1L, new User(),mockOrderItems); // Mock total cost

        // Mock the userService.createOrder() method
        when(userService.createOrder(mockOrderItems)).thenReturn(mockOrder);

        // Call the controller method
        ResponseEntity<Order> response = userController.createOrder(mockOrderItems);

        // Verify the results
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockOrder, response.getBody());
        verify(userService, times(1)).createOrder(mockOrderItems);
    }
}
