package com.example.controller.user;

import com.example.domail.Result;
import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.services.RedisService;
import com.example.services.user.UserService;
import com.example.util.ResultUtil;
import org.hibernate.validator.valuehandling.UnwrapValidatedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    private Result result;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    /**
     *@Param    : [telephone]
     *@Method   : telephoneAvailable
     *@Return   : com.example.domail.Result<com.example.domail.user.User>
     *@Describe :
     */
    @GetMapping("/telephone/available")
    public Result telephoneAvailable(@RequestParam(value = "telephone", required = true) String telephone ){
        result = new Result();
        ResultEnum resultEnum;
        boolean flag = userService.telephoneAvailable(telephone);
        if ( flag ){
            // 账号可用
            resultEnum = ResultEnum.ACCOUNT_AVAILABLE;
            result = ResultUtil.success(resultEnum,null);
        } else {
            //账号不可用
            resultEnum = ResultEnum.ACCOUNT_UNAVAILABLE;
            result = ResultUtil.error(resultEnum,null);
        }
        return result;
    }

    //用户注册接口
    @PostMapping("/register")
    public Result<User> register(HttpServletRequest request,User user) {
        Result result = ResultUtil.success();
        if (null == user) {
            //注册表单数据为空
            ResultEnum resultEnum = ResultEnum.REQUEST_DATA_IS_EMPTY;
            result =  ResultUtil.error( resultEnum,null );
        }
        user = userService.register(user);
        if (null != user) {
            //注册成功
            put_session(request , user);
            ResultEnum resultEnum = ResultEnum.REGISTER_SUCCESS;
            user.setPassword(null);
            result = ResultUtil.success(resultEnum,user);
        }
        return result;
    }

    //登入接口
    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request , @UnwrapValidatedValue User user, BindingResult bindingResult) {
        if ( bindingResult.hasErrors() ){
            return null;
        }

        Result<User> result;
        if (null != user) { //登入成功
            user = userService.login(user);
            this.put_session(request,user);
            ResultEnum resultEnum = ResultEnum.LOGIN_SUCCESS;
            user.setPassword(null);
            result =  ResultUtil.success(resultEnum,user);
        } else {
            ResultEnum resultEnum = ResultEnum.REQUEST_DATA_IS_EMPTY;
            result = ResultUtil.error( resultEnum , null );
        }
        return result;
    }

    //控制令牌的发放
    private void put_session(HttpServletRequest request,User user){
        Object token = request.getSession().getAttribute(user.getTelephoneNumber());
        if (null == token) { //session中不存在该缓存
            token = UUID.randomUUID();
            //将 token存入redis中 base_user 30分钟后失效
            request.getSession().setAttribute("user",token);
            redisService.set(token.toString(), user,1800L);
        }
    }

}
