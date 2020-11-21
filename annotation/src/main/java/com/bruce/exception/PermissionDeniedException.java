package com.bruce.exception;

/**
 * @ClassName PermissionDeniedException
 * @Description 权限不足
 * @Author Bruce
 * @Date 2020/11/21 5:31 下午
 */
public class PermissionDeniedException extends LabException {

    public PermissionDeniedException() {
        super(ExceptionCode.Permission_Denied, "权限不足");
    }

    public PermissionDeniedException(String message) {
        super(ExceptionCode.Permission_Denied, message);
    }

    public PermissionDeniedException(int code, String message) {
        super(code, message);
    }

}
