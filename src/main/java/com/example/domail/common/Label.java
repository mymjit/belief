package com.example.domail.common;

import com.example.domail.associated.ArticleLabel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @date : 2017/11/3
 * @author : whiled
 * @escribe : 标签
 */
@Entity
public class Label implements Serializable {
    /** 主键 */
    @Id
    @GeneratedValue
    private Integer id ;
    /** 标签名称 */
    private String labelName;
    /** 标签类型 (图片有标签, 文章也有标签, 用户也有标签) */
    private String type;

    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
    private List<ArticleLabel> articleLabels =new ArrayList<>(0);

    public Label() {
    }

    public Label(String labelName, String type, List<ArticleLabel> articleLabels) {
        this.labelName = labelName;
        this.type = type;
        this.articleLabels = articleLabels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ArticleLabel> getArticleLabels() {
        return articleLabels;
    }

    public void setArticleLabels(List<ArticleLabel> articleLabels) {
        this.articleLabels = articleLabels;
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                ", type='" + type + '\'' +
                ", articleLabels=" + articleLabels +
                '}';
    }
}
