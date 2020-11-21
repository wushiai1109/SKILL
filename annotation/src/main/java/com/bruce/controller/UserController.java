package com.bruce.controller;

import com.bruce.annotation.PassToken;
import com.bruce.annotation.TeacherPermission;
import com.bruce.model.DO.UserDO;
import com.bruce.model.VO.ResultInfo;
import com.bruce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 6:50 下午
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user 参数封装
     * @return ResultInfo
     */
    @PassToken
    @PostMapping("login")
    public ResultInfo login(@RequestBody UserDO user, HttpServletRequest request) {
        return userService.login(user, request);
    }

    /**
     * 登录
     *
     * @param user 参数封装
     * @return ResultInfo
     */
    @TeacherPermission
    @PostMapping("login1")
    public ResultInfo login1(@RequestBody UserDO user, HttpServletRequest request) {
        return userService.login(user, request);
    }

}
