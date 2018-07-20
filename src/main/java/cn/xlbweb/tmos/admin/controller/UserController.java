package cn.xlbweb.tmos.admin.controller;

import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.layui.TableResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("用户列表页")
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
}
