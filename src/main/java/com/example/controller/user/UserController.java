package com.example.controller.user;

import com.example.domail.Result;
import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.services.RedisService;
import com.example.services.user.UserService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

/**
 * @Date : Created in 2017/10/12
 * @Author : while
 * @Explain : 用户的控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    //用户注册接口
    @PostMapping("/register")
    public Result<User> register(HttpServletRequest request, @Valid User user) {
        if (null == user) { //数据为空
            throw new UserException(ResultEnum.LOGIN_NULL);
        }
        user = userService.register(user);
        if (null != user) { //注册成功将用户信息缓存到Session
            // 查看session是否存在该用户的token(令牌)信息
            String token = String.valueOf( request.getSession().getAttribute( user.getTelephoneNumber()) );
            if ( null == token ){ //session中不存在该缓存
                token = UUID.randomUUID().toString();
                //将 token存入redis中 base_user
                redisService.set(user.getTelephoneNumber(),token);
                request.getSession().setAttribute(user.getTelephoneNumber(),token);
            }
        }
        return ResultUtil.success(user);
    }

    //登入接口
    @PostMapping("/login")
    public Result<User> login(@Valid User user) {
        Result<User> userResult = new Result<User>();
        if (null != user) {
            User base_user = userService.login(user);
        } else {
            throw new UserException(ResultEnum.LOGIN_NULL);
        }
        return null;
    }


}
