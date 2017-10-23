package com.example.controller.user;

import com.example.domail.Result;
import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.services.user.UserService;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Enumerated;
import javax.validation.Valid;

/**
 * @Date : Created in 2017/10/12
 * @Author : while
 * @Explain : 用户的控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired()
    private UserService userService;

    //用户注册接口
    @PostMapping("/register")
    public Result<User> register(@Valid User user){
        Result<User> result = new Result<User>();
        if ( null == user ){ //数据为空
            throw new UserException(ResultEnum.LOGIN_NULL);
        }
        return ResultUtil.success(userService.register(user));
    }


    //登入接口
    @PostMapping("/login")
    public Result< User > login(@Valid User user){
        if ( null != user ){

        }
        return null;
    }



}
