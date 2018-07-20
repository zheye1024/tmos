package cn.xlbweb.tmos.common;

/**
 * @author: bobi
 * @date: 2018/7/18 18:53
 * @description:
 */
public class WebConst {

    /**
     * 用户登录成功后Session信息
     */
    public static final String SESSION_USER = "session_user";

    /**
     * 登陆类型
     */
    public interface LoginType {
        /**
         * 账号登陆
         */
        int USERNAME_TYPE = 0;
        /**
         * 手机号码登陆
         */
        int PHONE_TYPE = 1;
        /**
         * 邮箱登陆
         */
        int EMAIL_TYPE = 2;
    }
}
