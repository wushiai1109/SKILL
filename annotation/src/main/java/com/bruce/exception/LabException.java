package com.bruce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LabException
 * @Description 自定义异常基类, 实验室系统异常
 * @Author Bruce
 * @Date 2020/11/21 5:26 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabException extends Exception {
    private int code = -1;
    private String message;
}
