package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

import javax.swing.*;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/22 10:34
 * Description:
 **/
@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
