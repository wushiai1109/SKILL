package com.bruce.model.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @ClassName UserVO
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 7:07 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private int id;
    private String userId;
    private String userName;
    private String password;
    private String academy;
    private String grade;
    private String discipline;
    private String cls;
    private String sex;
    private String phone;
    private String type;
    private String token;
    private String registerDate;

}
