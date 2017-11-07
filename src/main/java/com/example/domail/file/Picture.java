package com.example.domail.file;

import com.example.domail.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe : 图片
 */
@Entity
@Component
public class Picture implements Serializable {

    /** 主键 */
    @Id
    @GeneratedValue
    private Integer id;
    /** 图片所属 */
    @JoinColumn( name = "user")
    @ManyToOne()
    private User user;
    /** 用户上传时的图片名称 */
    private String  fileName;
    /** 图片存储在系统的名称 */
    private String  pathName;
    /** 图片状态 (0 : 删除 1 : 私有 2 : 公开 ) */
    private Integer state;
    /** 备注 */
    private String  remarks;
    /** 图片大小 KB */
    private Long size;

    public Picture() {
    }

    public Picture(User user, String fileName, String pathName, Integer state, String remarks, Long size) {
        this.user = user;
        this.fileName = fileName;
        this.pathName = pathName;
        this.state = state;
        this.remarks = remarks;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", user=" + user +
                ", fileName='" + fileName + '\'' +
                ", pathName='" + pathName + '\'' +
                ", state=" + state +
                ", remarks='" + remarks + '\'' +
                ", size=" + size +
                '}';
    }
}
