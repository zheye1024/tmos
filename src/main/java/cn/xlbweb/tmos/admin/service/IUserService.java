package cn.xlbweb.tmos.admin.service;


import cn.xlbweb.tmos.common.layui.TableResponse;
import cn.xlbweb.tmos.common.server.ServerResponse;
import org.springframework.data.domain.Pageable;

/**
 * @author: bobi
 * @date: 2018/7/16 14:04
 * @description:
 */
public interface IUserService {

    /**
     * layui table查询所有用户信息
     *
     * @param pageable
     * @return
     */
    TableResponse findAll(Pageable pageable);

    /**
     * 账号|手机号码|邮箱登陆
     *
     * @param account
     * @param password
     * @param type
     * @return
     */
    ServerResponse login(String account, String password, int type);
}
