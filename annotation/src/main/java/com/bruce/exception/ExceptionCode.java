package com.bruce.exception;

/**
 * @ClassName ExceptionCode
 * @Description 异常类型
 * @Author Bruce
 * @Date 2020/11/21 5:30 下午
 */
public class ExceptionCode {

    //失败
    public static final int FAILED = -1;
    //成功
    public static final int SUCCESS = 0;
    //权限不足
    public static final int Permission_Denied = 1;
    //参数错误
    public static final int Parameter_Error = 2;

    //密码过于简单，重设密码
    public static final int RESET_PASSWORD = 300;

    //服务器内部错误
    public static final int Server_Internal_Error = 500;

}
