package com.example.domail.common;

import com.example.domail.user.User;

import java.io.Serializable;

/**
 * @Date : 2017/11/3
 * @Author : while
 * @Describe : 标签
 */
public class Label implements Serializable {
    private Long   id ;
    private User   user;      //标签所属 (用户自定义的标签)
    private String labelName; //标签名称
    private String type;      //标签类型 (图片有标签,文章也有标签(技术,心得,分享),用户也有标签)


    public Label() {

    }

    public Label(Long id, User user, String labelName, String type) {
        this.id = id;
        this.user = user;
        this.labelName = labelName;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                ", labelName='" + labelName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
