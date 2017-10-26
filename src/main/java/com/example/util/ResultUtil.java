package com.example.util;

import com.example.domail.Result;
import com.example.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date     : 2017/10/17
 * @Author   : whilte
 * @Describe : 返回类型工具类
 */
@Component
public class ResultUtil {

    @Autowired
    private static ResultEnum resultEnum;

    //返回成功
    public static Result success(Object object) {
        resultEnum = ResultEnum.REGISTER_SUCCESS;
        Result result = new Result();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }


    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
