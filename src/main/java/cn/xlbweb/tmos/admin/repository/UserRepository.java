package cn.xlbweb.tmos.admin.repository;

import cn.xlbweb.tmos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: bobi
 * @date: 2018/7/16 14:44
 * @description:
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
