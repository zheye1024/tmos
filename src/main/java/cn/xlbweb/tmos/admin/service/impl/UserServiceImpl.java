package cn.xlbweb.tmos.admin.service.impl;

import cn.xlbweb.tmos.admin.repository.UserRepository;
import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.WebConst;
import cn.xlbweb.tmos.common.layui.TableResponse;
import cn.xlbweb.tmos.common.server.ServerResponse;
import cn.xlbweb.tmos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: bobi
 * @date: 2018/7/16 14:45
 * @description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public TableResponse findAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return new TableResponse(userPage.getTotalElements(), userPage.getContent());
    }

    @Override
    public ServerResponse login(String account, String password, int type) {
        User user = null;
        if (type == WebConst.LoginType.USERNAME_TYPE) {
            user = userRepository.findByUsernameAndPassword(account, password);
        } else if (type == WebConst.LoginType.PHONE_TYPE) {
            user = userRepository.findByPhoneAndPassword(account, password);
        } else if (type == WebConst.LoginType.EMAIL_TYPE) {
            user = userRepository.findByEmailAndPassword(account, password);
        }
        if (user != null) {
            user.setPassword("");
            return ServerResponse.success("登陆成功", user);
        }
        return ServerResponse.error("登录失败");
    }
}
