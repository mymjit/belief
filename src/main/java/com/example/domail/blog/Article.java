package com.example.domail.blog;

import com.example.domail.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Explain : 文章类
 * @Author : while
 * @Date : Created in 2017/9/20
 */
@Entity
public class Article {

    @Id
    @GeneratedValue
    private Integer id;           //主键
    @JoinColumn( name = "user" )
    @ManyToOne (cascade = CascadeType.ALL, optional = true )
    private User    user;         //文章作者 ( 外键: 用户 )
    private String  title;        //文章标题
    private Date    createTime;   //创建时间
    private String  original;     //文章出处 (可选,文章来源其他网站的要标明出处Url)
    private Integer likeNumber;   //点赞数
    private Integer stepNumber;   //点踩数

    @OneToMany( mappedBy = "article", cascade = CascadeType.ALL)
    private List< ArticleContent > articleContents = new ArrayList< ArticleContent >(0);

    public Article() {
    }

    public Article(Integer id, String title, User user, Date createTime, String original, Integer likeNumber,
                   Integer stepNumber, List<ArticleContent> articleContents) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.createTime = createTime;
        this.original = original;
        this.likeNumber = likeNumber;
        this.stepNumber = stepNumber;
        this.articleContents = articleContents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public List<ArticleContent> getArticleContents() {
        return articleContents;
    }

    public void setArticleContents(List<ArticleContent> articleContents) {
        this.articleContents = articleContents;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", createTime=" + createTime +
                ", original='" + original + '\'' +
                ", likeNumber=" + likeNumber +
                ", stepNumber=" + stepNumber +
                ", articleContents=" + articleContents +
                '}';
    }
}
