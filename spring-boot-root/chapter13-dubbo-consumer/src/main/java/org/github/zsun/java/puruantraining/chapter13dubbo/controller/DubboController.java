package org.github.zsun.java.puruantraining.chapter13dubbo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.github.zsun.java.puruantraining.chapter13dubbo.service.DubboService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter13")
public class DubboController {
    @Reference
    DubboService dubboService;

    @RequestMapping("/callDubboProvider/{msg}")
    public String callDubboProvider(@PathVariable String msg) {
        return dubboService.printByDubbo(msg);
    }
}
