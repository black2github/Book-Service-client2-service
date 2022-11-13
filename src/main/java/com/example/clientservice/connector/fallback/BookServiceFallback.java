package com.example.clientservice.connector.fallback;

import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceFallback {

    private BookServiceUpdateConnector bookServiceUpdateConnector;

    // @HystrixCommand(fallbackMethod = "failed")
    public List<Book> getAllBooks() {
        log.info("ServiceFallback called.");
        return bookServiceUpdateConnector.getAllBooksList();
    }
}
