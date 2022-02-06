package org.github.zsun.java.puruantraining.chapter4sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForLimit {
    @RequestMapping("/sayHello")
    @SentinelResource(value = "sayHello")
    public String sayHello() {
        return "Hello Sentinel";
    }

    @RequestMapping("/useSentinel")
    @SentinelResource(value = "useSentinel")
    public String useSentinel() {
        return "Use Sentinel";
    }

    @RequestMapping("/limitForHandler")
    @SentinelResource(value = "limitForHandler", fallback = "handleException")
    public String limitForHandler() {
        return "limitForHandler";
    }

    public String handleException() {
        return "handler limit Exception";
    }
}
