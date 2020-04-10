package com.djy.springcloud.service;

import com.djy.springcloud.entity.Book;
import com.djy.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface BookService {

    @GetMapping("/findbook")
    public CommonResult findBookById(@RequestParam("id") int id);
}
