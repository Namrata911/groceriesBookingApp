package com.grocerify.groceries.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grocerify.groceries.model.OrderItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SampleTests {
    @Test
    void sample() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem = new OrderItem();
        orderItems.add(orderItem);
        String s = objectMapper.writeValueAsString(orderItems);
        System.out.println(s);

    }
}
