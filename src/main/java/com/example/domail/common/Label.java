package com.example.domail.common;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @date : 2017/11/3
 * @author : whiled
 * @escribe : 标签
 * 按体裁分四大类：小说、散文、诗歌、戏剧。这是最常见的。
 * 按文体分: 记叙文、说明文、议论文。
 * 按语体分: 文言文、白话文。
 */
@Entity
public class Label implements Serializable {
    /** 主键 */
    @Id
    @GeneratedValue
    private long id ;
    /** 上级分类，用来区分标签的种类,好供用户选择*/
    private String superiorLabelName;
    /** 标签名称 */
    private String labelName;
    /** 标签类型 (图片有标签, 文章也有标签, 用户也有标签) */
    private String type;

    public Label() {
    }

    public Label(String superiorLabelName, String labelName, String type) {
        this.superiorLabelName = superiorLabelName;
        this.labelName = labelName;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSuperiorLabelName() {
        return superiorLabelName;
    }

    public void setSuperiorLabelName(String superiorLabelName) {
        this.superiorLabelName = superiorLabelName;
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

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", superiorLabelName='" + superiorLabelName + '\'' +
                ", labelName='" + labelName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
