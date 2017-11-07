package com.example.services.user.impl;

import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.repository.user.UserRepository;
import com.example.services.user.UserService;
import com.example.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe : 用户业务逻辑处理类
 */
@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger( UserServiceImpl.class );

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional  
    public User register(User user) {
        User base_user = userRepository.findByUserTelephoneNumberOne(user.getTelephoneNumber());
        if (null != base_user) {
            //如果数据库中存在该用户登入名称抛出用户已存在异常
            throw new UserException(ResultEnum.USER_ALREADY_EXISTS);
        }
        //将密码进行加密处理
        String password = user.getPassword();
        user.setPassword(Md5Util.getSecret(password));
        return userRepository.save(user);
    }

    @Override
    public User login( User user) {
        User base_user = userRepository.findByUserTelephoneNumberOne(user.getTelephoneNumber());
        if (null == base_user) {
            //抛出用户不存在异常
            throw new UserException(ResultEnum.LOGIN_ACCOUNT_ERROR);
        } else {  //验证密码
            if ( Md5Util.checkPassword(user.getPassword(), base_user.getPassword()) ) {
                return base_user;
            } else {
                //抛出密码错误异常
                throw new UserException(ResultEnum.LOGIN_PASSWORD_ERROR);
            }
        }
    }



    
    /**
     *@param    : [telephoneNumber]
     *@method   : telephoneAvailable
     *@return   : boolean  true 可用 false 不可用
     *@describe : 验证注册电话是否可用
     */
    @Override
    public boolean telephoneAvailable(String telephoneNumber) {
        boolean flag= true;
        User user = userRepository.findByTelephoneNumber(telephoneNumber);
        if ( null != user ){
            flag = false;
        }
        return flag;
    }
}
