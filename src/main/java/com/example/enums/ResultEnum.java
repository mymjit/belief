package com.example.enums;


/**
 *@Date     : 2017/10/26
 *@Author   : whilte
 *@Describe : 对一些枚举常量作定义 2-5 系统产量  6-9 自定义常量  6成功 7警告 8错误 9提示
 */
public enum ResultEnum {
    //200 枚举常量定义
    SUCCESSFUL                    (200,"正确的请求成功！"),
    CREATED                       (201,"用户新建或修改数据成功！"),
    ACCEPTED                      (202,"请求已经进入后台排队(异步任务)！"),
    NON_AUTHORITATIVE_INFORMATION (203,"非授权信息！"),
    NO_CONTENT                    (204,"请求正确,但是没有需要返回的内容！"),
    RESET_CONTENT                 (205,"类似204,但是要求请求者重置视图！"),
    PARTIAL_CONTENT               (206,"请求成功,但根据请求头只返回了部分内容！！"),

    //300 枚举常量定义
    MULTIPLE_CHOICES              (300,"请求成功,但结果有多种选择！"),
    MOVED_PERMANENTLY             (301,"请求成功,但是资源被永久转移！"),
    FOUND                         (302,"请求成功,但是资源被临时转移！"),
    SEE_OTHER                     (303,"类似302,需要用get请求！"),
    NOT_MODIFIED                  (304,"请求的资源并没有被修改过！"),
    USE_PROXY                     (305,"请求的资源必须通过代理访问！"),
    UNUSED                        (306,"未使用的！"),
    TEMPORARY_REDIRECT            (307,"源被永久转移,要求使用原有的请求方式来通过新地址获取资源!"),

    //400 枚举常量定义
    BAD_REQUEST                   (400,"请求出现错误！"),
    UNAUTHORIZED                  (401,"没有提供认证信息,比如说，请求的时候没有带上Token等！"),
    PAYMENT_REQUIRED              (402,"为将来的需要所保留的状态码！"),
    FORBIDDEN                     (403,"请求的资源不允许访问！"),
    NOT_FOUND                     (404,"请求的内容不存在！"),
    METHOD_NOT_ALLPWED            (405,"请求的方法不允许使用！"),
    NOT_ACCEPTABLE                (406,"请求的资源并不符合要求！"),
    PROXY_AUTHENTICATION_REQUIRED (407,"没有提供认证信息，要求必须去同代理服务器进行认证！"),
    REQUEST_TIMEOUT               (408,"客户端请求超时!"),
    CONFLICT                      (409,"请求冲突!"),
    GONE                          (410,"请求资源曾经存在，但现在不存在了！"),

    //500 枚举常量定义
    INTERNAL_SERVER_ERROR         (500,"服务器错误！"),
    NOT_TMPLEMENTED               (501,"请求还没有被实现！"),
    BAD_GATEWAY                   (502,"网关错误！"),
    SERVICE_UNAVAILABLE           (503,"服务暂时不可用！"),

    //600 自定义常量
    REGISTER_SUCCESS              (600,"注册成功！"),

    //700 自定义常量
    REQUEST_DATA_IS_EMPTY         (700,"请输入或填写数据！"),
    DATA_DUPLICATION              (701,"数据已存在,请更改！"),
    USER_ALREADY_EXISTS           (702,"用户已存在,请重新输入！"),
    LOGIN_ACCOUNT_ERROR           (703,"用户名错误,请重新输入！"),
    LOGIN_PASSWORD_ERROR          (704,"用户密码错误,请重新输入！");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
