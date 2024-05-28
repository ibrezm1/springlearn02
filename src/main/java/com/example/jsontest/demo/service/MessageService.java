package com.example.jsontest.demo.service;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageService {

    private static final String ENDPOINT_URL = "https://testeee.requestcatcher.com";

    public void sendMessageToEndpoint(String message) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(ENDPOINT_URL);
            StringEntity entity = new StringEntity(message);
            post.setEntity(entity);
            post.setHeader("Content-Type", "application/json");
            client.execute(post);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
