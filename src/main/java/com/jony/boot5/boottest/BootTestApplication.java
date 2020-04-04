package com.jony.boot5.boottest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.jony.boot5.boottest.entity")
//@MapperScan("com.jony.boot5.boottest.mapper")
public class BootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootTestApplication.class, args);
    }

}
