package com.example.jsontest.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonEchoController {

    @PostMapping("/echo")
    public Object echo(@RequestBody Object json) {
        return json;
    }
}