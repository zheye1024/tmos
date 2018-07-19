package cn.xlbweb.tmos.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author: bobi
 * @date: 2018/7/18 16:49
 * @description:
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("giteeLogin")
    public String giteeLogin() {
        String client_id = "6a8497db50cfa1c5d87a0dc198198336f8acc8fcfad17c3daffbfc3a0efd4c50";
        // 打开授权页面(get请求)
        String redirect_uri = "http://tmos.s1.natapp.cc/auth/giteeInfo";
        String link = "https://gitee.com/oauth/authorize?client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&response_type=code";
        return "redirect:" + link;
    }

    @GetMapping("giteeInfo")
    public String giteeInfo(String code) {
        String client_id = "6a8497db50cfa1c5d87a0dc198198336f8acc8fcfad17c3daffbfc3a0efd4c50";
        String client_secret = "43c4d07784ad9529f9ecc35f4b924204182bf45b4a831605185e7e397c3d5aaf";
        String redirect_uri = "http://tmos.s1.natapp.cc/auth/giteeInfo";
        // 获取access_token(post请求)
        String link = "https://gitee.com/oauth/token";
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("grant_type", "authorization_code");
        requestEntity.add("code", code);
        requestEntity.add("client_id", client_id);
        requestEntity.add("redirect_uri", redirect_uri);
        requestEntity.add("client_secret", client_secret);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(link, requestEntity, String.class);
        JSONObject jsonObject = JSON.parseObject(response);
        String accessToken = jsonObject.getString("access_token");
        // 获取用户基本信息(get请求)
        String link2 = "https://gitee.com/api/v5/user?access_token=" + accessToken;
        String response2 = restTemplate.getForObject(link2, String.class);
        System.out.println("用户基本信息-->" + response2);
        return "redirect:/admin";
    }

    @GetMapping("githubLogin")
    public String githubLogin() {
        String client_id = "786ea4632dc99a1c2c2a";
        // 打开授权页面(get请求)
        String redirect_uri = "http://tmos.s1.natapp.cc/auth/githubInfo";
        String link = "https://github.com/login/oauth/authorize?client_id=" + client_id + "&state=xxx&redirect_uri=" + redirect_uri;
        return "redirect:" + link;
    }

    @GetMapping("githubInfo")
    public String githubInfo(String code) {
        String client_id = "786ea4632dc99a1c2c2a";
        String client_secret = "64c6a6287e22d1ec819a5d7e613198c20ab9d1e1";
        String redirect_uri = "http://tmos.s1.natapp.cc/auth/githubInfo";
        // 获取access_token(post请求)
        String link = "https://github.com/login/oauth/access_token";
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("client_id", client_id);
        requestEntity.add("client_secret", client_secret);
        requestEntity.add("code", code);
        requestEntity.add("redirect_uri", redirect_uri);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(link, requestEntity, String.class);
        // 获取用户基本信息(get请求)
        String link2 = "https://api.github.com/user?" + response.split("&")[0];
        String response2 = restTemplate.getForObject(link2, String.class);
        System.out.println("用户基本信息-->" + response2);
        return "redirect:/admin";
    }
}
