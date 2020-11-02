package cn.tanyu.security.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanyu
 * @version 1.0
 * @description: TODO
 * @date 2020/10/29 10:31 上午
 */
@RestController
public class TestController {

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "admin";
    }

    @GetMapping("/user/hello")
    public String userHello() {
        return "user";
    }
}
