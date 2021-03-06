package com.example.domail.log;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe : 日志类
 */
@Entity
@Component
public class ExecutionLog implements Serializable {

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /** 请求ip地址 */
    private String ip;
    /** 请求的URL */
    private String url;
    /** 请求的参数项json字符 */
    @Column( columnDefinition = "TEXT" )
    private String args;
    /** 方法返回值 */
    @Column( columnDefinition = "TEXT" )
    private String response;
    /** 请求的类名+方法名 */
    private String className;
    /** 请求的方式 */
    private String requestMode;
    /** 方法执行后时间 */
    private long endTime;
    /** 方法执行前时间 */
    private long startTime;
    /** 方法执行时长 秒*/
    private String methodRunningTime;


    public ExecutionLog() {
    }

    public ExecutionLog(String ip, String url, String args, String response, String className, String requestMode,
                        long endTime, long startTime, String methodRunningTime) {
        this.ip = ip;
        this.url = url;
        this.args = args;
        this.response = response;
        this.className = className;
        this.requestMode = requestMode;
        this.endTime = endTime;
        this.startTime = startTime;
        this.methodRunningTime = methodRunningTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRequestMode() {
        return requestMode;
    }

    public void setRequestMode(String requestMode) {
        this.requestMode = requestMode;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getMethodRunningTime() {
        return methodRunningTime;
    }

    public void setMethodRunningTime(String methodRunningTime) {
        this.methodRunningTime = methodRunningTime;
    }

    @Override
    public String toString() {
        return "ExecutionLog{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", args='" + args + '\'' +
                ", response='" + response + '\'' +
                ", className='" + className + '\'' +
                ", requestMode='" + requestMode + '\'' +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                ", methodRunningTime='" + methodRunningTime + '\'' +
                '}';
    }
}
