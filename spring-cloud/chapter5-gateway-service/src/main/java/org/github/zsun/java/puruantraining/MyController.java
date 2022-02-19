package org.github.zsun.java.puruantraining;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/getAccount/{id}")
    public String getAccount(@PathVariable String id){
        return "Account Info, id is:"+id;
    }
}
