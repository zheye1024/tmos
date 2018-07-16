package cn.xlbweb.tmos.admin.service;

import cn.xlbweb.tmos.common.server.ServerResponse;

/**
 * @author: bobi
 * @date: 2018/7/16 14:04
 * @description:
 */
public interface IUserService {

    /**
     * 根据昵称查询个人信息(Test)
     *
     * @param nickname
     * @return
     */
    ServerResponse findByNickname(String nickname);
}
