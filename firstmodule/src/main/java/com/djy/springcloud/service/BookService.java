package com.djy.springcloud.service;

import com.djy.springcloud.dao.BookDao;
import com.djy.springcloud.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
@Slf4j
public class BookService {
    @Resource
    private BookDao bookDao;

    public Book findBookById(int id){
        return bookDao.findBookById(id);
    }

    public void insertBook(Book book){
        int i = bookDao.insertBook(book);
        log.info("iiiiiiiiiiiiiiiiii+"+i);
    }
}