package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

// @Slf4j
@Service
// @AllArgsConstructor // commented because if zipkin and leuth
public class ClientService {
    Logger log = Logger.getLogger(ClientService.class.getName());
    private BookServiceConnector bookServiceConnector;
    // private BookServiceFallback bookServiceFallback; // вариант 1
    private BookServiceUpdateConnector bookServiceUpdateConnector; // вариант 2

    public ClientService(BookServiceConnector bookServiceConnector, BookServiceUpdateConnector bookServiceUpdateConnector) {
        this.bookServiceUpdateConnector = bookServiceUpdateConnector;
        this.bookServiceUpdateConnector = bookServiceUpdateConnector;
    }

    @HystrixCommand(fallbackMethod = "getAllBooksFromFallback")
    public List<Book> getAllBooks() {
        return bookServiceConnector.getAllBooksList();
    }

    /**
     * Hystrix fallback method
     * @return List<Book>
     */
    public List<Book> getAllBooksFromFallback() {
        log.info("Service is not available now. Try another service point...");
        // return bookServiceFallback.getAllBooks(); // вариант 1
        return bookServiceUpdateConnector.getAllBooksList(); // вариант 2
    }
}
