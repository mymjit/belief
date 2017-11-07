package com.example.services.user;

import com.example.domail.user.User;

/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe :
 */
public interface UserService {

    User register(User user);

    User login(User user);

    boolean telephoneAvailable(String telephoneNumber);
}
