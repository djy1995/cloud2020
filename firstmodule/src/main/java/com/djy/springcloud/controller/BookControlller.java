package com.djy.springcloud.controller;

import com.djy.springcloud.entity.Book;
import com.djy.springcloud.entity.CommonResult;
import com.djy.springcloud.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class BookControlller {

    @Resource
    private BookService bookService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/findbook")
    public CommonResult findBookById(int id){
        log.info("BookControlller findBookById....."+id);
        Book book = bookService.findBookById(id);
        log.info(book.getName());
        log.info(book.toString());

        return new CommonResult(200,"查询成功",book.toString());
    }

    @GetMapping("insertbook")
    public CommonResult insertBook(int id,String name, int price){
        Book book = new Book(id,name,price);
        log.info(book.toString());
        bookService.insertBook(book);
        return new CommonResult(200,"插入数据成功",book.toString());
    }

    @GetMapping("discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for(String element : services){
            log.info("element..........:"+element);
        }
       List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for(ServiceInstance element : serviceInstanceList){
            log.info(element.getHost()+element.getInstanceId()+element.getScheme()+element.getMetadata());
        }
        return this.discoveryClient;
    }
}