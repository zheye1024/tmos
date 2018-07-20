package cn.xlbweb.tmos.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: bobi
 * @date: 2018/7/16 15:04
 * @description:
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像
     */
    private String avatar;
}
