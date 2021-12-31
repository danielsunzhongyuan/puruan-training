package org.github.zsun.java.puruantraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Chapter9SecurityDbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter9SecurityDbDemoApplication.class, args);
    }

}
