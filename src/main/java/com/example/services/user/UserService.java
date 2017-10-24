package com.example.services.user;

import com.example.domail.user.User;
import com.example.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Explain :
 * @Author : while
 * @Date : Created in 2017/10/12
 */
public interface UserService {

    public User register(User user);

    public User login(User user);
}
