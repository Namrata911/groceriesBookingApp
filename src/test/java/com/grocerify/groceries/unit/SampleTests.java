package com.grocerify.groceries.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grocerify.groceries.model.OrderItem;
import com.grocerify.groceries.payload.request.SignupRequest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SampleTests {
    @Test
    void sample() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SignupRequest signupRequest = new SignupRequest() ;
        String s = objectMapper.writeValueAsString(signupRequest);
        System.out.println(s);

    }
}
