package com.example.repository.user;

import com.example.domail.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Explain : 用户
 * @Author : while
 * @Date : Created in 2017/10/12
 */
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query( value = "SELECT  telephone_number FROM user AS u WHERE u.telephone_number=?", nativeQuery = true)
    User findByTelephoneNumber(String telephone_number);

    @Query( value = "SELECT * FROM user WHERE telephone_number =?", nativeQuery = true )
    User findByUserTelephoneNumberOne( String telephoneNumber );
}
