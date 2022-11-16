package com.example.clientservice.connector.fallback;

import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

// @Slf4j
@Service
// @AllArgsConstructor
public class BookServiceFallback {
    Logger log = Logger.getLogger(BookServiceFallback.class.getName());

    private BookServiceUpdateConnector bookServiceUpdateConnector;

    public BookServiceFallback(BookServiceUpdateConnector bookServiceUpdateConnector) {
        this.bookServiceUpdateConnector = bookServiceUpdateConnector;
    }

    // @HystrixCommand(fallbackMethod = "failed")
    public List<Book> getAllBooks() {
        log.info("ServiceFallback called.");
        return bookServiceUpdateConnector.getAllBooksList();
    }
}
