package com.grocerify.groceries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


// GroceryItem.java
@Entity
@Table(name="`Grocery_Item`")
@Getter
@Setter
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantityInStock;

    // Constructors, getters, setters
}

