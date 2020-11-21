package com.bruce.interceptor;

import com.bruce.annotation.TeacherPermission;
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
 * @ClassName TeacherPermissionInterceptor
 * @Description 验证教师权限,教师或者管理员则放行
 * @Author Bruce
 * @Date 2020/11/21 6:44 下午
 */
@Component
public class TeacherPermissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response , Object handler) throws PermissionDeniedException {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }

        Method method = ((HandlerMethod) handler).getMethod();
        //如果有TeacherPermission注释则需要验证
        if(method.isAnnotationPresent(TeacherPermission.class)){
            UserDO user = UserMapUtil.userMap.get(request.getHeader("token"));
            if("teacher".equals(user.getType())||"admin".equals(user.getType())){
                return true;
            }else{
                throw new PermissionDeniedException("权限不足！需要教师权限！");
            }
        }
        return true;
    }

}
