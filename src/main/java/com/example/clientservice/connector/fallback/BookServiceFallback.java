package com.example.clientservice.connector.fallback;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.example.clientservice.service.Client2Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class BookServiceFallback implements BookServiceConnector {

    private Client2Service service;

    @Override
    public List<Book> getAllBooksList() {
        log.warn("Service is not available now.");
        log.info("Calling book-service-update.");
        return service.getAllBooksFromFallback();
    }
}
