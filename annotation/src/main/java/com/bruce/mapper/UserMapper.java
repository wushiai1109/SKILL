package com.bruce.mapper;

import com.bruce.model.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 7:19 下午
 */
@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where userId = #{userId} and userName = #{userName}")
    UserDO login(UserDO user);

}
