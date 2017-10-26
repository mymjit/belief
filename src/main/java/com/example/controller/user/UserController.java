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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
            throw new UserException(ResultEnum.REQUEST_DATA_IS_EMPTY);
        }
        user = userService.register(user);
        if (null != user) { //注册成功将用户信息缓存到Session
            // 查看session是否存在该用户的token(令牌)信息
            Object token = request.getSession().getAttribute(user.getTelephoneNumber());
            if (null == token) { //session中不存在该缓存
                token = UUID.randomUUID();
                //将 token存入redis中 base_user 30分钟后失效
                redisService.set(user.getTelephoneNumber(), token.toString(), 1800L);
                request.getSession().setAttribute("user",user.getTelephoneNumber());
                request.getSession().setAttribute(user.getTelephoneNumber(), token);
            }
        }
        return ResultUtil.success(user);
    }

    //登入接口
    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request, @Valid User user) {
        Result<User> userResult = new Result<User>();
        if (null != user) {
            User base_user = userService.login(user);
            userResult.setMsg("登入成功");
            userResult.setCode(10010);
            userResult.setData(base_user);
        } else {
            throw new UserException(ResultEnum.REQUEST_DATA_IS_EMPTY);
        }
        return userResult;
    }

}
