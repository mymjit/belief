package com.example.manage;

import com.example.model.TokenModel;

/**
 * @Date : 2017/10/31
 * @Author : while
 * @Describe : 令牌管理
 */
public interface TokenManager {

    void deleteToken(Long telephoneNumber);

    boolean checkToken(TokenModel tokenModel);

    TokenModel getToken(String authentication);

    TokenModel createToken(Long telephoneNumber);

}
