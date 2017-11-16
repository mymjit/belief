package com.example.domail.common;

import javax.persistence.*;
import java.io.Serializable;

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
    private long id ;
    /** 标签名称 */
    private String labelName;
    /** 标签类型 (图片有标签, 文章也有标签, 用户也有标签) */
    private String type;

    public Label() {
    }

    public Label(String labelName, String type) {
        this.labelName = labelName;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelName='" + labelName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
