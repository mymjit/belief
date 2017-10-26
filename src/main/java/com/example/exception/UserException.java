package com.example.exception;


import com.example.enums.ResultEnum;

/**
 * 定义自己的异常
 * 必需继承RuntimeException 不是RuntimeException Spring事物不会回滚
 */

/**
 * @Author : whilte
 * @Date : 2017/10/17
 * @Describe :定义自己的异常 必需继承RuntimeException 不是RuntimeException Spring事物不会回滚
 */
public class UserException extends RuntimeException {


    private Integer code;

    public UserException() {
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserException{" +
                "code=" + code +
                '}';
    }
}
