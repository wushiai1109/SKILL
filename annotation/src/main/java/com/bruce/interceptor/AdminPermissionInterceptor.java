package com.bruce.interceptor;

import com.bruce.annotation.AdminPermission;
import com.bruce.exception.PermissionDeniedException;
import com.bruce.model.DO.UserDO;
import com.bruce.util.UserMapUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName AdminPermissionInterceptor
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 6:46 下午
 */
@Component
public class AdminPermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws PermissionDeniedException {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();

        //如果有AdminPermission注释则需要验证
        if (method.isAnnotationPresent(AdminPermission.class)) {
            UserDO user = UserMapUtil.userMap.get(request.getHeader("token"));
            if ("admin".equals(user.getType())) {
                return true;
            } else {
                throw new PermissionDeniedException("权限不足！需要管理员权限！");
            }
        }
        return true;
    }
}
