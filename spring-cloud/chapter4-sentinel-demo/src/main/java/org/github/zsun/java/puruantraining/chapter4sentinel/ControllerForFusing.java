package org.github.zsun.java.puruantraining.chapter4sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForFusing {
    @RequestMapping("/testFusing")
    @SentinelResource(value = "testFusing")
    public String testFusing() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Test Fusing";
    }
}
