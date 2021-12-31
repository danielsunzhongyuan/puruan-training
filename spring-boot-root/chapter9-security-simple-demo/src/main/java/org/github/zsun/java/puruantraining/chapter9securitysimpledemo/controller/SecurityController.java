package org.github.zsun.java.puruantraining.chapter9securitysimpledemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chapter9")
public class SecurityController {
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/getCompanyNum")
    public String getCompanyNum() {
        return "getCompanyNum";
    }

    @RequestMapping("/updateCompanyNum")
    public String updateCompanyNum() {
        return "updateCompanyNum";
    }

    @RequestMapping("/getUserNum")
    public String getUserNum() {
        return "getUserNum";
    }

    @RequestMapping("/updateUserNum")
    public String updateUserNum() {
        return "updateUserNum";
    }
}
