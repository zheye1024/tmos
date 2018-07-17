package cn.xlbweb.tmos.admin.service.impl;

import cn.xlbweb.tmos.admin.repository.UserRepository;
import cn.xlbweb.tmos.admin.service.IUserService;
import cn.xlbweb.tmos.common.layui.TableResponse;
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
}
