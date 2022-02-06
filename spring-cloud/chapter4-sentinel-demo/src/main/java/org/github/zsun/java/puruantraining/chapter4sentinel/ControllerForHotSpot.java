package org.github.zsun.java.puruantraining.chapter4sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForHotSpot {
    @RequestMapping("/buyItem")
    @SentinelResource(value = "buyItem")
    public String buyItem(@RequestParam(value = "item", required = false) String item,
                          @RequestParam(value = "price", required = false) String price) {
        return "Hot Spot Demo";
    }
}
