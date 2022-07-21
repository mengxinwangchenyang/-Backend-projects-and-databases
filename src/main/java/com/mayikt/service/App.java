package com.mayikt.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName App
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@MapperScan("com.mayikt.service")
@SpringBootApplication
public class App {
    /**
     * @param args
     * @SpringBootApplication 组合
     * @EnableAutoConfiguration
     * @ComponentScan
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
    /**
     *  @ComponentScan 扫包范围 com.mayikt.service
     *  当前启动类同级包或者子包下面
     */
}
