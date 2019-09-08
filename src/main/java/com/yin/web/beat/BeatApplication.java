package com.yin.web.beat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * web后台
 * 登录简易demo
 */


@SpringBootApplication
@MapperScan("com.yin.web.beat.mapper")
public class BeatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeatApplication.class, args);
    }

}
