package com.example.clientservice.connector;

import com.example.clientservice.model.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestTemplateConnector {
    private RestTemplate restTemplate;

    @Value("${book-service.url}/${book-service.rest}")
    private String url;

    public RestTemplateConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Book> data() {
        return List.of(restTemplate.getForObject(url, Book[].class));
    }
}
