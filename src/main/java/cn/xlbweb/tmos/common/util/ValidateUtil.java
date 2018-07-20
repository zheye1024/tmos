package cn.xlbweb.tmos.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: bobi
 * @date: 2018/7/20 10:24
 * @description:
 */
@Slf4j
public class ValidateUtil {

    /**
     * 校验手机格式
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        boolean flag = false;
        try {
            String checkRule = "^1[3-9][0-9]\\d{8}$";
            Pattern regex = Pattern.compile(checkRule);
            Matcher matcher = regex.matcher(phone);
            flag = matcher.matches();
        } catch (Exception e) {
            log.error("校验手机格式出错", e);
        }
        return flag;
    }

    /**
     * 校验邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String checkRule = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(checkRule);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            log.error("校验邮箱格式出错", e);
        }
        return flag;
    }
}
