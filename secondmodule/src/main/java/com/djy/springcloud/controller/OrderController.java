package com.djy.springcloud.controller;

import com.djy.springcloud.entity.Book;
import com.djy.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    //cloud-payment-service
//    public static  String PAYMENT_URL = "http://localhost:8001";
    public static  String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/findbook")
    public CommonResult<Book> findbook( int id){
        log.info("/consumer/findbook"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/findbook?id="+id,CommonResult.class);
    }

    @GetMapping("/consumer/insertbook")
    public CommonResult<Book> insertBook(int id,String name, int price){
        log.info("/consumer/insertbook"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/insertbook?id="+id+"&name="+name+"&price="+price,CommonResult.class);
    }
}
