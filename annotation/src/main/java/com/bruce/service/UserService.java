package com.bruce.service;

import com.bruce.mapper.UserMapper;
import com.bruce.model.DO.UserDO;
import com.bruce.model.VO.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserService
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 7:20 下午
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public ResultInfo login(UserDO user, HttpServletRequest request) {
        ResultInfo info = new ResultInfo();

        UserDO u = userMapper.login(user);
        if (u != null) {
            request.getSession().setAttribute("user", u);
            info.setFlag(true);
            logger.info("login —— user:"+user.toString());
            info.setMsg("登陆成功");
            info.setData(u);
        } else {
            info.setFlag(false);
            info.setMsg("用户名或密码错误");
        }
        return info;
    }
}
