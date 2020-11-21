package com.bruce.config;

import com.bruce.interceptor.AdminPermissionInterceptor;
import com.bruce.interceptor.AuthenticationInterceptor;
import com.bruce.interceptor.TeacherPermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName WebMvcConfig
 * @Description MVC配置类
 * @Author Bruce
 * @Date 2020/11/21 5:11 下午
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final AuthenticationInterceptor authenticationInterceptor;
    private final AdminPermissionInterceptor adminPermissionInterceptor;
    private final TeacherPermissionInterceptor teacherPermissionInterceptor;

    @Autowired
    public WebMvcConfig(AuthenticationInterceptor authenticationInterceptor,
                        AdminPermissionInterceptor adminPermissionInterceptor,
                        TeacherPermissionInterceptor teacherPermissionInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
        this.adminPermissionInterceptor = adminPermissionInterceptor;
        this.teacherPermissionInterceptor = teacherPermissionInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        //1.加入的顺序就是拦截器执行的顺序，也可以使用order（）方法
        //2.按顺序执行所有拦截器的preHandle
        //3.所有的preHandle 执行完再执行全部postHandle 最后是postHandle
        registry.addInterceptor(authenticationInterceptor)
                //添加拦截规则
                .addPathPatterns("/**").order(1);
        //.excludePathPatterns("/");//排除拦截，表示该路径不用拦截
        registry.addInterceptor(teacherPermissionInterceptor).order(2);
        registry.addInterceptor(adminPermissionInterceptor).order(3);
        super.addInterceptors(registry);
    }

}
