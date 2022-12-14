package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.connector.fallback.BookServiceFallback;
import com.example.clientservice.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ClientService {

    private BookServiceConnector bookServiceConnector;
    // private BookServiceFallback bookServiceFallback; // вариант 1
    private BookServiceUpdateConnector bookServiceUpdateConnector; // вариант 2

    @HystrixCommand(fallbackMethod = "getAllBooksFromFallback")
    public List<Book> getAllBooks() {
        return bookServiceConnector.getAllBooksList();
    }

    /**
     * Hystrix fallback method
     * @return List<Book>
     */
    public List<Book> getAllBooksFromFallback() {
        log.warn("Service is not available now. Try another service point...");
        // return bookServiceFallback.getAllBooks(); // вариант 1
        return bookServiceUpdateConnector.getAllBooksList(); // вариант 2
    }
}
