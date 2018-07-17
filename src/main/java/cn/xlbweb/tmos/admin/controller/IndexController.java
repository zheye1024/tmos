package cn.xlbweb.tmos.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: bobi
 * @date: 2018/7/17 09:45
 * @description:
 */
@Controller
public class IndexController {

    @GetMapping("admin")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("admin/welcome")
    public String welcome() {
        return "admin/welcome";
    }

    @GetMapping("admin/login")
    public String login() {
        return "admin/login";
    }
}
