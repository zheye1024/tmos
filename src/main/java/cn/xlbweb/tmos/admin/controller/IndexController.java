package cn.xlbweb.tmos.admin.controller;

import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.WebConst;
import cn.xlbweb.tmos.common.server.ServerResponse;
import cn.xlbweb.tmos.common.util.ValidateUtil;
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
@Controller
public class IndexController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("admin")
    public String admin() {
        return "admin/index";
    }

    @GetMapping("admin/welcome")
    public String welcome() {
        return "admin/welcome";
    }

    /**
     * 后台登录页面
     *
     * @return
     */
    @GetMapping("/admin/login")
    public String login() {
        return "admin/login";
    }

    /**
     * 后台登录逻辑
     *
     * @param account
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/admin/login")
    @ResponseBody
    public ServerResponse login(String account, String password, HttpSession session) {
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

    /**
     * 后台登出逻辑
     *
     * @param session
     * @return
     */
    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
