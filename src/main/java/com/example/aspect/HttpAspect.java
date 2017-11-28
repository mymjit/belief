package com.example.aspect;

import com.example.domail.log.ExecutionLog;
import com.example.services.log.ExecutionLogService;
import com.google.gson.Gson;
import org.apache.catalina.session.StandardSessionFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author   : whilte
 * @date     : 2017/10/16
 * @describe : 面向切面
 */
@Aspect
@Component
public class HttpAspect {

    @Autowired
    private Gson gson;

    @Autowired
    private ExecutionLog executionLog;

    @Autowired
    private ExecutionLogService executionLogService;

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    /**
     * @Method   : log
     * @Param    : []
     * @Return   : void * com.example.controller.*.*.*(..)
     * @Describe : 针对莫个切点进行切入,类似方法拷贝,对所有 controller内的方法进行切入
     */
    //针对所有http请求进行切割
    @Pointcut("execution(public * com.example.controller..*.*(..))")
    public void log() {
    }


    /**
     * @Method   : doBetore
     * @Param    : [joinPoint]
     * @Describe : 方法执行前的函方法
     */
    @Before("log()")
    public void doBetore(JoinPoint joinPoint) {

        executionLog = new ExecutionLog();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //ip
        executionLog.setIp(request.getRemoteAddr());
        //url请求的URL
        executionLog.setUrl(request.getRequestURI());
        Object [] objects = joinPoint.getArgs();
        //请求的参数
        executionLog.setArgs(getArgs(objects));
        //请求的类+方法名
        executionLog.setClassName(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //请求的方式 GET POST
        executionLog.setRequestMode(request.getMethod());
        //方法执行开始时间 距离1970-01-01 多少秒
        executionLog.setStartTime(System.currentTimeMillis());
    }


    /**
     * @Method   : doAfter
     * @Return   : void
     * @Describe : 方法执行后的方法
     */
    @After("log()")
    public void doAfter() {
        //方法执行结束时间 距离1970-01-01 多少秒
        executionLog.setEndTime(System.currentTimeMillis());
        //方法运行时间
        executionLog.setMethodRunningTime(runTime());
    }

    /**
     *@Describe : 方法执行完毕返回前要执行的方法，获取返回的内容
     *@Method   : doAfterReturning
     *@Param    : [object]
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        // 返回数据
        executionLog.setResponse(gson.toJson(object));
        executionLogService.save(executionLog);
    }

    private String runTime() {
        Long runtime = executionLog.getEndTime() - executionLog.getStartTime();
        return runtime.toString();
    }

    private String getArgs(Object [] objects){
        StringBuffer stringBuffer = new StringBuffer();
        if (objects.length > 0) {
            //针对没有参数项处理
            for (Object object : objects) {
                if (object instanceof HttpServletRequest) {
                    //无论方法有没有参数joinPoint.getArgs会返回一个request对象
                    //用Gson.toJson去解析会导致循环无法退出最终内存溢出
                } else if ( object instanceof StandardSessionFacade){
                    //不需要记录缓存中的数据
                }else {
                    //参数
                    stringBuffer.append(gson.toJson(object));
                }
            }
        }
        return stringBuffer.toString();
    }


}
