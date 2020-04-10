package com.djy.springcloud.controller;

import com.djy.springcloud.dao.BookDao;
import com.djy.springcloud.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private BookDao bookDao;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        return "nacos serverPort = "+serverPort + "\n id = "+id;
    }


    @GetMapping(value = "/payment/book/{id}")
    public String getBook(@PathVariable("id") Integer id){

        return bookDao.findBookById(id).toString();
    }
}
