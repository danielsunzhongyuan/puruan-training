package org.github.zsun.java.puruantraining.chapter5interceptordemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @RequestMapping("/chapter5/interceptor/login/{username}")
    public String login(@PathVariable String username) {
        System.out.println("login: " + username);
        return "Login done for " + username;
    }

    @RequestMapping("/chapter5/interceptor/hackerVisit")
    public String hackerVisit() {
        return "hacker visit";
    }
}
