package cn.xlbweb.tmos.admin.service;


import cn.xlbweb.tmos.common.layui.TableResponse;
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
}
