package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Client2Service {

    private BookServiceConnector connector;
    private BookServiceUpdateConnector fallbackConnector;

    public List<Book> getAllBooks() {
        return connector.getAllBooksList();
    }

    public List<Book> getAllBooksFromFallback() {
        return fallbackConnector.getAllBooksList();
    }
}
