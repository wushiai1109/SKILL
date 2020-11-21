package com.bruce.exception;

import com.bruce.exception.LabException;

/**
 * @ClassName NoTokenException
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 5:28 下午
 */
public class NoTokenException extends LabException {

    public NoTokenException() {
        super(ExceptionCode.FAILED, "token不存在");
    }

    public NoTokenException(String message) {
        super(ExceptionCode.FAILED, message);
    }

    public NoTokenException(int code, String message) {
        super(code, message);
    }

}
