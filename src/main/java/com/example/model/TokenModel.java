package com.example.model;

/**
 * @Date     : 2017/10/31
 * @Author   : while
 * @Describe : 令牌数据模型 可以增加字段提高安全性，例如时间戳、url签名
 */
public class TokenModel {

    private String token;

    private Long telephoneNumber;

    public TokenModel() {
    }

    public TokenModel(Long telephoneNumber,String token) {
        this.token = token;
        this.telephoneNumber = telephoneNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
