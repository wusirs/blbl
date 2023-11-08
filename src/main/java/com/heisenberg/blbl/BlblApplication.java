package com.heisenberg.blbl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.heisenberg.blbl.mapper")
public class BlblApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlblApplication.class, args);
    }
}