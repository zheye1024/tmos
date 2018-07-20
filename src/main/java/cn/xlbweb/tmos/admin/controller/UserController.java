package cn.xlbweb.tmos.admin.controller;

import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.WebConst;
import cn.xlbweb.tmos.common.layui.TableResponse;
import cn.xlbweb.tmos.common.server.ServerResponse;
import cn.xlbweb.tmos.common.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @GetMapping
    public String index() {
        return "admin/user";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableResponse findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        Pageable pageable = PageRequest.of(page - 1, limit);
        return iUserService.findAll(pageable);
    }

    @PostMapping("/login")
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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
