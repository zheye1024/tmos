package cn.xlbweb.tmos.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: bobi
 * @date: 2018/7/18 18:55
 * @description:
 */
@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // todo "/druid/**"
        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login", "/admin/lib/**", "/admin/css/**", "/admin/images/**");
    }
}
