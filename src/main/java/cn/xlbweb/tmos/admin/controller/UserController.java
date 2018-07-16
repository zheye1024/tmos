package cn.xlbweb.tmos.admin.controller;

import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.server.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: bobi
 * @date: 2018/7/16 14:44
 * @description:
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("findByNickname")
    @ResponseBody
    public ServerResponse findOne(String nickname) {
        return iUserService.findByNickname(nickname);
    }
}
