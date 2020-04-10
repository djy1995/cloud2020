package com.djy.springcloud.controller;

import com.djy.springcloud.entity.Book;
import com.djy.springcloud.entity.CommonResult;
import com.djy.springcloud.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/feign/findbook")
    public CommonResult<Book> findbook(int id){
        log.info("/feign/findbook"+id);
        return bookService.findBookById(id);
    }
}
