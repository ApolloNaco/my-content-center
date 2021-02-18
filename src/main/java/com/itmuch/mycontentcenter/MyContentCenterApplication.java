package com.itmuch.mycontentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

// 扫描mybatis哪些包里面的接口
@MapperScan("com.itmuch.mycontentcenter.dao")
@SpringBootApplication
public class MyContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyContentCenterApplication.class, args);
    }

    // 在Spring容器中，创建一个对象，类型RestTemple 名称restTemplate
    // <bean id="restTemplate(方法名) class = RestTemplate 返回类型的全路径">
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
