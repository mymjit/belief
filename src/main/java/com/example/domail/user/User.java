package com.example.domail.user;

import com.example.domail.blog.Article;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @Explain : 用户类
 * @Author : while
 * @Date : Created in 2017/9/20
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Integer id;                //主键
    private String userName;           //用户名字    (真实名字)
    private String alias;              //用户别名    (匿名)
    private String sex;                //性别       (年龄根据身份证动态获取)
    private String idCard;             //身份证
    private String email;              //邮箱
    @Column( unique = true , length = 11 )
    private String telephoneNumber;    //电话       (登入的账号,唯一)
    private String password;           //密码       (登入的密码)
    private Integer integral;          //积分      (对网站的贡献)
    private Integer state;             //账号状态   (控制账户销毁) (1.正常(默认的状态)  2.异常(存在被盗的可能) 3.拉黑(被系统禁止登入) )

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL )
    private List<Article> articles = new ArrayList<Article>(0);


    public User() {
    }

    public User(Integer id, String userName, String alias, String sex, String idCard, String email, String telephoneNumber,
                String password, Integer integral, Integer state, List<Article> articles) {
        this.id = id;
        this.userName = userName;
        this.alias = alias;
        this.sex = sex;
        this.idCard = idCard;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.password = password;
        this.integral = integral;
        this.state = state;
        this.articles = articles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", alias='" + alias + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", integral=" + integral +
                ", state=" + state +
                ", articles=" + articles +
                '}';
    }
}


