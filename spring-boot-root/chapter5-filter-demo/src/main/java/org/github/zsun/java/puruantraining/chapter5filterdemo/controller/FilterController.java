package org.github.zsun.java.puruantraining.chapter5filterdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter5")
public class FilterController {
    @RequestMapping("/testFilter")
    public String testFilter() {
        System.out.println("testFilter");
        return "testFilter";
    }
}
