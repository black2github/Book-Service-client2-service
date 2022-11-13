package com.example.clientservice.service;

import com.example.clientservice.connector.FeignConnector;
import com.example.clientservice.connector.RestTemplateConnector;
import com.example.clientservice.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ClientService {

    private FeignConnector feignConnector;
    private RestTemplateConnector restTemplateConnector;

    @HystrixCommand(fallbackMethod = "failed")
    public List<Book> getAllBooks() {
        return feignConnector.getAllBooksList();
    }

    public List<Book> data() {
        return restTemplateConnector.data();
    }

    /**
     * Hystrix fallback method
     * @return
     */
    public List<Book>  failed() {
        String error = "Service is not available now. Please try again later";
        log.info(error);
        List<Book> books = new ArrayList<>();
        return books;
    }
}
