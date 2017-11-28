package com.example.domail.blog;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


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
    private long id;
    /** 文章发布人 《外键》  */
    private long   user_id;
    /** 文章作者《表明出处》  */
    private String  author;
    /** 是否公开 0: 私有， 1: 公开 */
    private int isopen;
    /** 文章标题 */
    private String  title;
    @Column( columnDefinition = "TEXT" )
    private String paragraphContent;
    /** 创建时间 */
    private Date    createTime;
    /** 文章出处 (可选,文章来源其他网站的要标明出处Url) */
    private String  original;
    /** 点赞数 */
    private int likeNumber;
    /** 点踩数 */
    private int stepNumber;
    /** 数据状态 0删除, 1存在(默认)  */
    private int state;


    public Article() {
    }

    public Article(long user_id, String author, int isopen, String title, String paragraphContent,
                   Date createTime, String original, int likeNumber, int stepNumber, int state) {
        this.user_id = user_id;
        this.author = author;
        this.isopen = isopen;
        this.title = title;
        this.paragraphContent = paragraphContent;
        this.createTime = createTime;
        this.original = original;
        this.likeNumber = likeNumber;
        this.stepNumber = stepNumber;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsopen() {
        return isopen;
    }

    public void setIsopen(int isopen) {
        this.isopen = isopen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent;
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

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", author='" + author + '\'' +
                ", isopen=" + isopen +
                ", title='" + title + '\'' +
                ", paragraphContent='" + paragraphContent + '\'' +
                ", createTime=" + createTime +
                ", original='" + original + '\'' +
                ", likeNumber=" + likeNumber +
                ", stepNumber=" + stepNumber +
                ", state=" + state +
                '}';
    }
    
}
