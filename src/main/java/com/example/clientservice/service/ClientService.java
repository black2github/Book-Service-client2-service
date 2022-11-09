package com.example.clientservice.service;

import com.example.clientservice.connector.FeignConnector;
import com.example.clientservice.connector.RestTemplateConnector;
import com.example.clientservice.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private FeignConnector feignConnector;
    private RestTemplateConnector restTemplateConnector;

    public List<Book> getAllBooks() {
        return feignConnector.getAllBooksList();
    }

    public List<Book> data() {
        return restTemplateConnector.data();
    }
}
