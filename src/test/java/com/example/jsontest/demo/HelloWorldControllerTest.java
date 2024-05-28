package com.example.jsontest.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.example.jsontest.demo.controller.HelloWorldController; // Import the HelloWorldController class

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_ShouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/hello-world"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello World"));
    }
}