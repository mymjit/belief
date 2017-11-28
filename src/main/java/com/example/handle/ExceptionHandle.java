package com.example.handle;


import com.example.model.ResultModel;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@date     : 2017/11/17
 *@author   : whilte
 *@describe :
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    private ResultEnum resultEnum;

    //拦截所有异常,针对自己的异常进行处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultModel handle(Exception e) {
        if (e instanceof InvalidDataAccessResourceUsageException) {
            //重复插入限制唯一的字段列会抛该异常(如注册用户名重复)
            resultEnum = ResultEnum.DATA_DUPLICATION;
            return ResultUtil.error(resultEnum,null);
        } else if (e instanceof UserException) {
            //针对自己定义的异常做处理
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getMessage(),userException.getCode(),null);
        } else {
            logger.error("[系统异常]{}", e);
            resultEnum = ResultEnum.BAD_REQUEST;
            return ResultUtil.error(resultEnum);
        }
    }
}
