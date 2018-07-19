//package cn.xlbweb.tmos.common.util;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author: bobi
// * @date: 2018/7/18 15:22
// * @description:
// */
//public class AuthUtil {
//
//    /**
//     * Gitee网页授权
//     */
//    private static final String client_id = "6a8497db50cfa1c5d87a0dc198198336f8acc8fcfad17c3daffbfc3a0efd4c50";
//
//    public static void getCode(HttpServletResponse response) {
//        try {
//            String redirect_uri = "http://tmos.s1.natapp.cc/oauth/giteeInfo";
//            String link = "https://gitee.com/oauth/authorize?client_id=" + client_id + "&redirect_uri={redirect_uri}&response_type=code";
//            response.sendRedirect(link);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
