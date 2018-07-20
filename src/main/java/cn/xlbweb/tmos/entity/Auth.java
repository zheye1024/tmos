package cn.xlbweb.tmos.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: bobi
 * @date: 2018/7/16 15:13
 * @description:
 */
@Data
@Entity
@Table(name = "t_auth")
public class Auth {

    /**
     * id主键
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 对应t_user表中的主键id
     */
    private String userId;
    /**
     * 登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
     */
    private String identityType;
    /**
     * 标识（手机号 邮箱 用户名或第三方应用的唯一标识）
     */
    private String identifier;
    /**
     * 密码凭证（站内的保存密码，站外的不保存或保存token）
     */
    private String credential;
}
