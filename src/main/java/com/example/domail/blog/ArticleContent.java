package com.example.domail.blog;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@Date     : 2017/11/1
 *@Author   : whilte
 *@Describe : 文章段落
 */
@Entity
public class ArticleContent implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;                //主键
    @JoinColumn(name = "article")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Article article;           //关联的文章表
    private String  paragraphContent;  //段落内容
    private Integer paragraphSort;     //段落排序
    private Integer state;             //状态(0 : 删除 1 :正常（默认）)

    public ArticleContent() {
    }

    public ArticleContent(Article article, String paragraphContent, Integer paragraphSort, Integer state) {
        this.article = article;
        this.paragraphContent = paragraphContent;
        this.paragraphSort = paragraphSort;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent;
    }

    public Integer getParagraphSort() {
        return paragraphSort;
    }

    public void setParagraphSort(Integer paragraphSort) {
        this.paragraphSort = paragraphSort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id=" + id +
                ", article=" + article +
                ", paragraphContent='" + paragraphContent + '\'' +
                ", paragraphSort=" + paragraphSort +
                ", state=" + state +
                '}';
    }
}
