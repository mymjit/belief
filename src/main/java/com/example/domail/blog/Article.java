package com.example.domail.blog;

import com.example.domail.associated.ArticleLabel;
import com.example.domail.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *@date     : 2017/11/1
 *@author   : whilte
 *@describe : 文章类
 */
@Entity
public class Article implements Serializable {

    /** 主键  */
    @Id
    @GeneratedValue
    private Integer id;
    /** 文章发布人 《外键》  */
    @JoinColumn(name = "user")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private User    user;
    /** 文章作者《表明出处》  */
    private String  author;
    /** 是否公开 0: 私有， 1: 公开 */
    private Integer isopen;
    /** 文章标题 */
    private String  title;
    /** 创建时间 */
    private Date    createTime;
    /** 文章出处 (可选,文章来源其他网站的要标明出处Url) */
    private String  original;
    /** 点赞数 */
    private Integer likeNumber;
    /** 点踩数 */
    private Integer stepNumber;
    /** 数据状态 0删除, 1存在(默认)  */
    private Integer state;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleContent> articleContents = new ArrayList<ArticleContent>(0);

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List< ArticleLabel > articleLabels = new ArrayList<>(0);

    public Article() {
    }

    public Article(User user, String author, Integer isopen, String title, Date createTime, String original, Integer likeNumber, Integer stepNumber, Integer state,
                   List<ArticleContent> articleContents, List<ArticleLabel> articleLabels) {
        this.user = user;
        this.author = author;
        this.isopen = isopen;
        this.title = title;
        this.createTime = createTime;
        this.original = original;
        this.likeNumber = likeNumber;
        this.stepNumber = stepNumber;
        this.state = state;
        this.articleContents = articleContents;
        this.articleLabels = articleLabels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getIsopen() {
        return isopen;
    }

    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<ArticleContent> getArticleContents() {
        return articleContents;
    }

    public void setArticleContents(List<ArticleContent> articleContents) {
        this.articleContents = articleContents;
    }

    public List<ArticleLabel> getArticleLabels() {
        return articleLabels;
    }

    public void setArticleLabels(List<ArticleLabel> articleLabels) {
        this.articleLabels = articleLabels;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", user=" + user +
                ", author='" + author + '\'' +
                ", isopen=" + isopen +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", original='" + original + '\'' +
                ", likeNumber=" + likeNumber +
                ", stepNumber=" + stepNumber +
                ", state=" + state +
                ", articleContents=" + articleContents +
                ", articleLabels=" + articleLabels +
                '}';
    }
}
