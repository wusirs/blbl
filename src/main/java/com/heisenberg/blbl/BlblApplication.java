package com.heisenberg.blbl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.heisenberg.blbl.mapper")
//@ComponentScan(basePackages = {"com.heisenberg.blbl.convert"})
public class BlblApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlblApplication.class, args);
    }


    // commit 1

    // commit 2
}
