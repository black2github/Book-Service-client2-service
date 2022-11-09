package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class ClientServiceController {
    Logger logger = Logger.getLogger(ClientServiceController.class.getName());

    private Environment env;
    private ClientService service;

    public ClientServiceController(Environment env, ClientService service) {
        this.env = env;
        this.service = service;
    }

    @RequestMapping("/")
    public String home() {
        String home = "Client service running at port:" + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }

    @RequestMapping("/getAllBooksByFeignClient")
    public List<Book> getAllBooks() {
        logger.info("Calling through Feign Client");
        return service.getAllBooks();
    }

    @RequestMapping("/getAllBooksByRestTemplate")
    public List<Book> data() {
        logger.info("Calling through RestTemplate");
        return service.data();
    }
}
