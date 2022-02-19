package org.github.zsun.java.puruantraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Chapter5GatewaySentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(Chapter5GatewaySentinelApplication.class, args);
    }
}
