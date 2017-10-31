package com.example.util;

import com.example.model.ResultModel;
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

    public static ResultModel success(String msg , Integer code , Object obj) {
        ResultModel result = new ResultModel();
        result.setMsg(msg);
        result.setData( obj );
        result.setCode(code);
        return result;
    }


    public static ResultModel success(ResultEnum resultEnum , Object obj) {
        ResultModel result = new ResultModel();
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(obj);
        return result;
    }

    public static ResultModel success(Object object) {
        ResultModel result = new ResultModel();

        resultEnum = ResultEnum.SUCCESSFUL;
        result.setMsg(resultEnum.getMsg());
        result.setCode(resultEnum.getCode());
        result.setData(object);
        return result;
    }


    public static ResultModel success() {
        return success(null);
    }


    public static ResultModel error(String msg , Integer code , Object object) {
        ResultModel result = new ResultModel();
        result.setMsg  ( msg );
        result.setCode ( code );
        result.setData ( object );
        return result;
    }


    public static ResultModel error(ResultEnum resultEnum , Object object) {
        ResultModel result = new ResultModel();
        result.setMsg  ( resultEnum.getMsg() );
        result.setCode ( resultEnum.getCode() );
        result.setData ( object );
        return result;
    }

    public static ResultModel error(Object object) {
        ResultModel result = new ResultModel();
        resultEnum = ResultEnum.BAD_REQUEST;
        result.setMsg  ( resultEnum.getMsg() );
        result.setCode ( resultEnum.getCode() );
        result.setData ( object );
        return result;
    }

    public static ResultModel error(){
        return error(null );
    }

}
