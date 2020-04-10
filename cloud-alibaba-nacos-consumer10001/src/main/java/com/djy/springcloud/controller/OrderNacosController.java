package com.djy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RefreshScope //支持nacos动态刷新
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${config.info}")
    private String configInfo;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }

    @GetMapping("config/info")
    public String getConfigInfo(){
        return configInfo;
    }


    @GetMapping("hello")
    public String sayHello(){
        return "Hello World!!!!!!!!";
    }

    @GetMapping("testA")
    @SentinelResource(value = "testA",blockHandler = "deal_testA")
    public String testA(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){}
        return "testA!!!!!!!!";
    }

    public String deal_testA(String p1, String p2, BlockException e){
        return "deal_testA................";
    }
}

