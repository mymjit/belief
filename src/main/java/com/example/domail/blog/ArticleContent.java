package com.example.domail.blog;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Explain : 文章内容
 * @Author : while
 * @Date : Created in 2017/9/20
 */
@Entity
public class ArticleContent implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;               //主键
    @JoinColumn(name = "article")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Article article;          //关联的文章表
    private String paragraphContent; //段落内容
    private Integer paragraphSort;    //段落排序

    public ArticleContent() {
    }

    public ArticleContent(Integer id, Article article, String paragraphContent, Integer paragraphSort) {
        this.id = id;
        this.article = article;
        this.paragraphContent = paragraphContent;
        this.paragraphSort = paragraphSort;
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

    @Override
    public String toString() {
        return "ArticleContent{" +
                "id=" + id +
                ", article=" + article +
                ", paragraphContent='" + paragraphContent + '\'' +
                ", paragraphSort=" + paragraphSort +
                '}';
    }
}
