package com.bruce.model.DO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserPOJO
 * @Description 实验室系统用户类，对应user表
 * @Author Bruce
 * @Date 2020/11/21 5:46 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDO {

    private int id;
    private String userId;
    private String userName;
    private String academy;
    private String grade;
    private String discipline;
    private String cls;
    private String sex;
    private String phone;
    private String type;
    private String password;
    private String securityQuestion;
    private String answer;
    private String registerDate;

}
