package com.example.handle;


import com.example.domail.Result;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@Author   : whilte
 *@Date     : 2017/10/16
 *@Describe :
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    //拦截所有异常,针对自己的异常进行处理
    @ExceptionHandler( value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof InvalidDataAccessResourceUsageException )
        {   //重复插入限制唯一的字段列会抛该异常(如注册用户名重复)
            ResultEnum resultEnum = ResultEnum.LOGIN_REGISTERED;
            return ResultUtil.error(resultEnum.getCode(),resultEnum.getMsg());
        } else if ( e instanceof UserException ){ //针对自己定义的异常做处理
            UserException userException = (UserException)e;
            return ResultUtil.error(userException.getCode(),userException.getMessage());
        } else {
            logger.error("[系统异常]{}",e);
            ResultEnum resultEnum = ResultEnum.INVALID_REQUEST;
            return ResultUtil.error(resultEnum.getCode(),resultEnum.getMsg());
        }
    }
}
