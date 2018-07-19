package cn.xlbweb.tmos.admin.util;

import org.junit.Test;

/**
 * @author: bobi
 * @date: 2018/7/19 14:08
 * @description:
 */
public class StringUtilTest {

    @Test
    public void test() {
        String str = "access_token=78cd7fe841118ebbc6f567fd24225c3d21902427&scope=&token_type=bearer";
        String str2 = str.split("&")[0];
        System.out.println(str2);
    }
}
