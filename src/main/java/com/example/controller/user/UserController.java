package com.example.controller.user;

import com.example.manage.TokenManager;
import com.example.manage.impl.RedisTokenManager;
import com.example.model.ResultModel;
import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.model.TokenModel;
import com.example.services.user.UserService;
import com.example.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe : 用户的控制器
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private ResultModel result;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTokenManager redisTokenManager;

    /**
     *@param    : [telephone]
     *@method   : telephoneAvailable
     *@return   : com.example.model.ResultModel<com.example.domail.user.User>
     *@describe : 电话验证是否可用
     */
    @GetMapping("/telephone/available")
    public ResultModel telephoneAvailable(
            @RequestParam(value = "telephone", required = true) String telephone ){
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
    /**
     *@param    : [user]
     *@ethod    : register
     *@return   : com.example.model.ResultModel<com.example.domail.user.User>
     *@describe : 注册接口
     */
    @PostMapping("/register")
    public ResultModel<TokenManager> register(@Valid User user) {
        if (null == user) {
            //注册表单数据为空
            ResultEnum resultEnum = ResultEnum.REQUEST_DATA_IS_EMPTY;
            result =  ResultUtil.error( resultEnum,null );
        }

        user.setState(1);
        user = userService.register(user);
        if (null != user) {
            ResultEnum resultEnum = ResultEnum.REGISTER_SUCCESS;
            result = ResultUtil.success(resultEnum,
                    redisTokenManager.createToken(Long.valueOf(user.getTelephoneNumber())));
        }
        return result;
    }

    /**
     *@param    : [ user]
     *@method   : login
     *@return   : com.example.model.ResultModel<com.example.model.TokenModel>
     *@describe : 登入接口
     */
    @PostMapping("/login")
    public ResultModel<TokenModel> login(User user) {
        if (null != user) {
            user = userService.login(user);
            ResultEnum resultEnum = ResultEnum.LOGIN_SUCCESS;
            result =  ResultUtil.success(resultEnum,
                    redisTokenManager.createToken(Long.valueOf(user.getTelephoneNumber())));
        } else {
            ResultEnum resultEnum = ResultEnum.REQUEST_DATA_IS_EMPTY;
            result = ResultUtil.error( resultEnum , null );
        }
        return result;
    }

}
