package com.djy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8002.class,args);
    }
}
