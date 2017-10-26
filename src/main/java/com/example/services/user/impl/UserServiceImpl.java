package com.example.services.user.impl;

import com.example.domail.user.User;
import com.example.enums.ResultEnum;
import com.example.exception.UserException;
import com.example.repository.user.UserRepository;
import com.example.services.user.UserService;
import com.example.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author : while
 * @Date : 2017/10/17
 * @Describe :
 * @CachePut 相当于update()操作
 * @Cacheable 相当于insert()操作
 * @CacheEvict 相当于delete()操作
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private Md5Util md5Util;

    @Autowired
    private UserRepository userRepository;

    @Transactional   //事物管理  查询不需要
    public User register(User user) {
        User user_base = userRepository.findByUserNameOne(user.getTelephoneNumber());
        if (null != user_base) { //如果数据库中存在该用户登入名称抛出用户已存在异常
            throw new UserException(ResultEnum.LOGIN_REGISTERED);
        }
        //将密码进行加密处理
        String password = user.getTelephoneNumber();
        user.setPassword(md5Util.getSecret(password));
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User user_base = userRepository.findByUserNameOne(user.getTelephoneNumber());
        if (null != user_base) { //如果用户不存在
            //抛出用户不存在异常
            throw new UserException(ResultEnum.LOGIN_ACCOUNT_ERROR);
        } else {  //验证密码
            if (md5Util.checkPassword(user.getTelephoneNumber(), user_base.getTelephoneNumber())) {
                //顺利通过返回登入成功 写入cookie
                return user_base;
            } else {
                //抛出密码错误异常
                throw new UserException(ResultEnum.LOGIN_PASSWORD_ERROR);
            }
        }

    }

}
