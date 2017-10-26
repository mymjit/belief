package com.example.util;

import com.example.domail.Result;
import com.example.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *@Date     : 2017/10/26 
 *@Author   : whilte
 *@Describe : 返回类型根据类
 */
@Component
public class ResultUtil {


    @Autowired
    private static ResultEnum resultEnum;

    public static Result success(String msg , Integer code , Object obj) {
        Result result = new Result();
        result.setMsg(msg);
        result.setData( obj );
        result.setCode(code);
        return result;
    }


    public static Result success(ResultEnum resultEnum , Object obj) {
        Result result = new Result();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(obj);
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();

        resultEnum = ResultEnum.SUCCESSFUL;
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(object);
        return result;
    }


    public static Result success() {
        return success(null);
    }


    public static Result error(String msg , Integer code ,Object object) {
        Result result = new Result();
        result.setMsg  ( msg );
        result.setCode ( code );
        result.setData ( object );
        return result;
    }


    public static Result error(ResultEnum resultEnum ,Object object) {
        Result result = new Result();
        result.setMsg  ( resultEnum.getMsg() );
        result.setCode ( resultEnum.getCode() );
        result.setData ( object );
        return result;
    }

    public static Result error(Object object) {
        Result result = new Result();
        resultEnum = ResultEnum.BAD_REQUEST;
        result.setMsg  ( resultEnum.getMsg() );
        result.setCode ( resultEnum.getCode() );
        result.setData ( object );
        return result;
    }

    public static Result error(){
        return error(null );
    }

}
