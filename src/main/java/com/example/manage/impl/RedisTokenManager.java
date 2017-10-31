package com.example.manage.impl;

import com.example.manage.TokenManager;
import com.example.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Date     : 2017/10/31
 * @Author   : while
 * @Describe : 令牌管理
 */
@Component
public class RedisTokenManager implements TokenManager {
    // token有效期（小时）
    public static final int TOKEN_EXPIRES_HOUR = 72;

    private RedisTemplate <Long, String> redisTemplate;

    @Autowired
    public void setRedis(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        //泛型设置成Long后必须更改对应的序列化方案
        redisTemplate.setKeySerializer( new JdkSerializationRedisSerializer() );
    }

    /**
     *@Param    : [telephoneNumber]
     *@Method   : createToken
     *@Return   : com.example.model.TokenModel
     *@Describe : 
     */
    @Override
    public TokenModel createToken(Long telephoneNumber) {
        String token =UUID.randomUUID().toString().replace("-","");
        TokenModel tokenModel = new TokenModel(telephoneNumber,token);
        redisTemplate.boundValueOps( telephoneNumber ).set(token,TOKEN_EXPIRES_HOUR , TimeUnit.HOURS);
        return tokenModel;
    }


    /**
     *@Param    : [tokenModel]
     *@Method   : checkToken
     *@Return   : boolean
     *@Describe : 
     */
    @Override
    public boolean checkToken(TokenModel tokenModel) {
        if (tokenModel == null) {
            return false;
        }
        String token = redisTemplate.boundValueOps(tokenModel.getTelephoneNumber()).get();
        if (token == null || !token.equals(tokenModel.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(tokenModel.getTelephoneNumber()).expire(TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    /**
     *@Param    : [authentication]
     *@Method   : getToken
     *@Return   : com.example.model.TokenModel
     *@Describe :
     */
    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    /**
     *@Param    : [telephoneNumber]
     *@Method   : deleteToken
     *@Return   : void
     *@Describe :
     */
    @Override
    public void deleteToken(Long telephoneNumber) {
        redisTemplate.delete(telephoneNumber);
    }

}
