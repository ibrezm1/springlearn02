package com.example.jsontest.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JsonEchoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSameJson() throws Exception {
        String jsonContent = "{\"name\":\"John\", \"age\":30}";

        mockMvc.perform(post("/echo")
                .contentType("application/json")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonContent));
    }
}
