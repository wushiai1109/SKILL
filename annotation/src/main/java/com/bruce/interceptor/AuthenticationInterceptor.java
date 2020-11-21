package com.bruce.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bruce.annotation.PassToken;
import com.bruce.annotation.UserLoginToken;
import com.bruce.exception.NoTokenException;
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
 * @ClassName AuthenticationInterceptor
 * @Description 权限认证拦截器
 * @Author Bruce
 * @Date 2020/11/21 5:17 下午
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NoTokenException, PermissionDeniedException {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //获取方法
        Method method = ((HandlerMethod) handler).getMethod();
        //如果有passToken注释，直接通过
        if (method.isAnnotationPresent(PassToken.class)) {
            return true;
        }

        //如果有userLoginToken注释则需要验证
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            //获取token
            String token = request.getHeader("token");
            if (token == null || "".equals(token)) {
                throw new NoTokenException();
            }

            UserDO user = UserMapUtil.userMap.get(token);
            if (user == null) {
                throw new PermissionDeniedException();
            }

            try {
                DecodedJWT jwt = JWT.require(Algorithm.HMAC256(user.getPassword())).build().verify(token);
            } catch (TokenExpiredException e) {
                UserMapUtil.userMap.remove(token);
                throw new TokenExpiredException("资源访问受限!请重新登录！");
            } catch (JWTVerificationException e) {
                throw new JWTVerificationException("401");
            }
            return true;
        }
        return true;
    }
}
