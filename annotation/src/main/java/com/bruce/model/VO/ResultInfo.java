package com.bruce.model.VO;

import com.bruce.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RestInfo
 * @Description
 * @Author Bruce
 * @Date 2020/11/21 7:09 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo {

    private boolean flag;
    private String msg;
    private Object data;

}
