package com.itmuch.mycontentcenter;

import org.springframework.web.client.RestTemplate;

public class SentinelTest {
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++) {
            // sentinel 1.8版本/actuator/sentinel无法起到关联限流的作用 用自己的节点例如/test-a就可以生效
//            String object = restTemplate.getForObject("http://localhost:8010/actuator/sentinel", String.class);
            String object = restTemplate.getForObject("http://localhost:8010/test-a", String.class);
            Thread.sleep(50);
        }
    }

    public static void main1 (String[] args){
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++) {
            String object = restTemplate.getForObject("http://localhost:8010/test-a", String.class);
            System.out.println("-----" + object + "-----");
        }
    }
}
