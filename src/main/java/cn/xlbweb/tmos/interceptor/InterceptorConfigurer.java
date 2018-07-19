//package cn.xlbweb.tmos.interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @author: bobi
// * @date: 2018/7/18 18:55
// * @description:
// */
//@Configuration
//public class InterceptorConfigurer extends WebMvcConfigurationSupport {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/admin/**").excludePathPatterns("/admin/login", "/css/**", "/images/**", "/js/**", "/lib/**");
//        super.addInterceptors(registry);
//    }
//}
