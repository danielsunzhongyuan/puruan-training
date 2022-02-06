package org.github.zsun.java.puruantraining.chapter4sentinel.client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

class RequestThread extends Thread {
    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/testFusing", String.class);
        System.out.println(entity.getBody());
    }
}

public class TestFusing {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new RequestThread().start();
        }
    }
}
