package com.example.services.user;

import com.example.domail.user.User;

/**
 * @Date    : Created in 2017/10/12
 * @Author  : while
 * @Explain : 用户操作的接口
 */
public interface UserService {

    User register(User user);

    User login(User user);

    boolean telephoneAvailable(String telephoneNumber);
}
