package cn.xlbweb.tmos.admin.controller;

import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.WebConst;
import cn.xlbweb.tmos.common.server.ServerResponse;
import cn.xlbweb.tmos.common.util.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author: bobi
 * @date: 2018/7/17 09:45
 * @description:
 */
@Api(description = "后台管理系统入口服务")
@Controller
public class IndexController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation("后台管理首页")
    @GetMapping({"/admin", "/"})
    public String admin() {
        return "admin/index";
    }

    @ApiOperation("欢迎页")
    @GetMapping("/admin/welcome")
    public String welcome() {
        return "admin/welcome";
    }

    @ApiOperation("后台登录页面")
    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    @ApiOperation("后台登录逻辑")
    @PostMapping("/admin/login")
    @ResponseBody
    public ServerResponse login(@ApiParam(name = "account", value = "账号|手机号|邮箱", required = true) String account,
                                @ApiParam(name = "password", value = "密码", required = true) String password,
                                HttpSession session) {
        int type = WebConst.LoginType.USERNAME_TYPE;
        if (ValidateUtil.checkPhone(account)) {
            type = WebConst.LoginType.PHONE_TYPE;
        } else if (ValidateUtil.checkEmail(account)) {
            type = WebConst.LoginType.EMAIL_TYPE;
        }
        ServerResponse serverResponse = iUserService.login(account, password, type);
        if (serverResponse.isSuccess()) {
            session.setAttribute(WebConst.SESSION_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    @ApiOperation("后台登出逻辑")
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
