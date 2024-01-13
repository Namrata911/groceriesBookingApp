package com.grocerify.groceries;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grocerify.groceries.model.GroceryItem;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroceriesApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		GroceryItem groceryItem = new GroceryItem();
		System.out.println(objectMapper.writeValueAsString(groceryItem));
	}

}
