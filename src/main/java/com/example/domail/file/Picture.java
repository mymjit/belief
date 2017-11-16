package com.example.domail.file;

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
    private long id;
    /** 图片所属 */
    private long user_id;
    /** 用户上传时的图片名称 */
    private String  fileName;
    /** 图片存储在系统的名称 */
    private String  pathName;
    /** 图片状态 (0 : 删除 1 : 私有 2 : 公开 ) */
    private int state;
    /** 备注 */
    private String  remarks;
    /** 图片大小 KB */
    private long size;

    public Picture() {
    }

    public Picture(long user_id, String fileName,
                   String pathName, int state, String remarks, long size) {
        this.user_id = user_id;
        this.fileName = fileName;
        this.pathName = pathName;
        this.state = state;
        this.remarks = remarks;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", fileName='" + fileName + '\'' +
                ", pathName='" + pathName + '\'' +
                ", state=" + state +
                ", remarks='" + remarks + '\'' +
                ", size=" + size +
                '}';
    }


}
