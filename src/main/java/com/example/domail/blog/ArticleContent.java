package com.example.domail.blog;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@date     : 2017/11/1
 *@author   : whilte
 *@describe : 文章段落
 */
@Entity
public class ArticleContent implements Serializable {

    /** 主键 */
    @Id
    @GeneratedValue
    private long id;
    /** 关联的文章表 <外键> */
    private long article_id;
    /** 段落内容 */
    private String  paragraphContent;
    /** 段落排序 */
    private int  paragraphSort;
    /** 状态(0 : 删除 1 :正常（默认）) */
    private int state;

    public ArticleContent() {

    }

    public ArticleContent(long article_id, String paragraphContent, int state) {
        this.article_id = article_id;
        this.paragraphContent = paragraphContent;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent;
    }

    public int getParagraphSort() {
        return paragraphSort;
    }

    public void setParagraphSort(int paragraphSort) {
        this.paragraphSort = paragraphSort;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", paragraphContent='" + paragraphContent + '\'' +
                ", paragraphSort=" + paragraphSort +
                ", state=" + state +
                '}';
    }
}
