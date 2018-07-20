package cn.xlbweb.tmos.wechat.controller;

import cn.xlbweb.tmos.common.server.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: bobi
 * @date: 2018/7/16 14:47
 * @description:
 */
@Controller("WeChatUserController")
@RequestMapping("/wechat/user")
public class UserController {

    @GetMapping("/list")
    @ResponseBody
    public ServerResponse list() {
        return ServerResponse.success("ok");
    }
}
