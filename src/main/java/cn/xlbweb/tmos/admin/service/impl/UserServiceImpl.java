package cn.xlbweb.tmos.admin.service.impl;

import cn.xlbweb.tmos.admin.repository.UserRepository;
import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.server.ServerResponse;
import cn.xlbweb.tmos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public ServerResponse findByNickname(String nickname) {
        User user = userRepository.findByNickname(nickname + "");
        if (user != null) {
            return ServerResponse.success("查询成功", user);
        }
        return ServerResponse.error("无数据");
    }
}
