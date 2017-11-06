package com.example.domail.user;

import java.io.Serializable;

/**
 *@Date     : 2017/11/1
 *@Author   : whilte
 *@Describe : 图片信息
 */
public class Picture implements Serializable {

    private Integer id;
    private User    user;         //图片所属
    private String  userFileName; //用户上传时的图片名称
    private String  pathName;     //图片存储在系统山的名称
    private Integer state;        //图片状态 (0 : 删除 1 : 私有 2 : 公开 )
    private String  describe;     //图片描述
    private Integer size;         //图片大小 KB

    public Picture() {
    }

    public Picture(Integer id, User user, String userFileName,
                   String pathName, Integer state, String describe, Integer size) {
        this.id = id;
        this.user = user;
        this.userFileName = userFileName;
        this.pathName = pathName;
        this.state = state;
        this.describe = describe;
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

    public String getUserFileName() {
        return userFileName;
    }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", user=" + user +
                ", userFileName='" + userFileName + '\'' +
                ", pathName='" + pathName + '\'' +
                ", state=" + state +
                ", describe='" + describe + '\'' +
                ", size=" + size +
                '}';
    }
}
