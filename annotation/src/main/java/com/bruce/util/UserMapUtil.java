package com.bruce.util;

import com.bruce.model.DO.UserDO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserMapUtil
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 5:33 下午
 */
@Component
public class UserMapUtil {

    public static final Map<String, UserDO> userMap = new HashMap<>();

}
