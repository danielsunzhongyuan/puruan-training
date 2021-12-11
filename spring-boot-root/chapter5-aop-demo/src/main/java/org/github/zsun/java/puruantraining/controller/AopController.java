package org.github.zsun.java.puruantraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    @RequestMapping("/chapter5/aopDemo")
    public String aopDemo() {
        return "chapter5 aop demo";
    }
}
