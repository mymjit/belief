package com.example.domail.associated;


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
    private long id;
    private long  label_id;
    private long  article_id;


    public ArticleLabel() {

    }

    public ArticleLabel(long label_id, long article_id) {
        this.label_id = label_id;
        this.article_id = article_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLabel_id() {
        return label_id;
    }

    public void setLabel_id(long label_id) {
        this.label_id = label_id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "ArticleLabel{" +
                "id=" + id +
                ", label_id=" + label_id +
                ", article_id=" + article_id +
                '}';
    }

}
