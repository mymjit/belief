package com.example.enums;


/**
 * 自定义枚举
 */
public enum ResultEnum {
    OK(200, "响应成功返回用户请求的数据"),
    UNKONW_ERROR(110, "未知错误"),
    CREATED(201, "用户新建或修改数据成功！"),
    ACCEPTED(202, "请求已经进入后台排队(异步任务)"),
    NO_CONTENT(204, "删除数据成功"),
    INVALID_REQUEST(400, "发出的请求有错误，服务器没有进行新建或修改数据的操作"),
    UNAUTHORIZED(401, "用户没有权限(令牌、用户名、密码错误)"),
    FORBIDDEN(403, "得到授权(与401错误相对)，但是访问是被禁止的"),
    NOT_FOUND(404, "发出的请求针对的是不存在的记录，服务器没有进行操作!"),
    NOT_Acceptable(406, "格式不可得(比如用户请求JSON格式，但是只有XML格式)"),
    GONE(410, "请求的资源被永久删除，且不会再得到的"),
    UNPROCESBLE_ENTITY(422, "当创建一个对象时，发生一个验证错误。"),
    INTERNAL_SERVER_ERROR(500, "服务器发生错误,用户将无法判断发出的请求是否成功"),
    LOGIN_SUCCESS(10000, "登入成功！！！"),
    LOGIN_NULL(10001, "请输入账号密码！"),
    LOGIN_REGISTERED(10002, "账号已存在！！！"),
    REGISTER_SUCCESS(10003, "注册成功！!!"),
    LOGIN_ACCOUNT_ERROR(10004, "账号错误！"),
    LOGIN_PASSWORD_ERROR(10005, "密码错误！");

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
