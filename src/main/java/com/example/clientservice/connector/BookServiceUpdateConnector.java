package com.example.clientservice.connector;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "book-service-update",
        url = "${book-service-update.url}",
        configuration = FeignConfig.class
)
@Component
public interface BookServiceUpdateConnector {
    @GetMapping("${book-service-update.feign}")
    List<Book> getAllBooksList();
}
