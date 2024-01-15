package com.grocerify.groceries.controller;



import com.grocerify.groceries.model.GroceryItem;
import com.grocerify.groceries.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddGroceryItem() {
        GroceryItem groceryItem = new GroceryItem();
        when(adminService.addGroceryItem(any())).thenReturn(groceryItem);

        ResponseEntity<GroceryItem> response = adminController.addGroceryItem(groceryItem);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(groceryItem, response.getBody());
        verify(adminService, times(1)).addGroceryItem(any());
    }

    @Test
    void testViewGroceryItems() {
        List<GroceryItem> groceryItems = Arrays.asList(new GroceryItem(), new GroceryItem());
        when(adminService.viewGroceryItems()).thenReturn(groceryItems);

        ResponseEntity<List<GroceryItem>> response = adminController.viewGroceryItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(groceryItems, response.getBody());
        verify(adminService, times(1)).viewGroceryItems();
    }

    @Test
    void testRemoveGroceryItem() {
        Long itemId = 1L;

        ResponseEntity<Void> response = adminController.removeGroceryItem(itemId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(adminService, times(1)).removeGroceryItem(eq(itemId));
    }

    @Test
    void testUpdateGroceryItem() {
        Long itemId = 1L;
        GroceryItem updatedItem = new GroceryItem();
        when(adminService.updateGroceryItem(eq(itemId), any())).thenReturn(updatedItem);

        ResponseEntity<GroceryItem> response = adminController.updateGroceryItem(itemId, updatedItem);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedItem, response.getBody());
        verify(adminService, times(1)).updateGroceryItem(eq(itemId), any());
    }

    @Test
    void testManageInventory() {
        Long itemId = 1L;
        int quantity = 10;

        ResponseEntity<Void> response = adminController.manageInventory(itemId, quantity);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(adminService, times(1)).manageInventory(eq(itemId), eq(quantity));
    }
}
