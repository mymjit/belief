package com.example.domail.associated;

import com.example.domail.blog.Article;
import com.example.domail.common.Label;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Date : 2017/11/6
 * @Author : while
 * @Describe : 文章类 和 标签类的关联表
 */
@Entity
public class ArticleLabel implements Serializable {

    /** *主键 */
    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(name = "article")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Article article;

    @JoinColumn(name = "label")
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Label  label;


    public ArticleLabel() {
    }

    public ArticleLabel(Long id, Article article, Label label) {
        this.id = id;
        this.article = article;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "ArticleLabel{" +
                "id=" + id +
                ", article=" + article +
                ", label=" + label +
                '}';
    }
}
