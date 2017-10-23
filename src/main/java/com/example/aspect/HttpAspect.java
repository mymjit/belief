package com.example.aspect;

import com.example.domail.log.ExecutionLog;
import com.example.services.log.ExecutionLogService;
import com.google.gson.Gson;
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
 *@Author   : whilte
 *@Date     : 2017/10/16
 *@Describe : 面向切面
 */
@Aspect
@Component  //不加这个注解的话, 使用@Autowired 就不能注入进去了
public class HttpAspect {

    private Integer uniqueVisitor = 0; //接口访问次数

    @Autowired
    private Gson gson;

    @Autowired
    private ExecutionLog executionLog; //添加实体类需要在实体类上 @Component 注解，不然报错

    @Autowired
    private ExecutionLogService executionLogService;

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    private Long   endTime_ns;    //方法执行结束时间 - 纳秒
    private Long   startTime_ns;  //方法执行开始时间 - 纳秒



    /**
     *@Describe : 针对莫个切点进行切入,类似方法拷贝
     *@Method   : log
     *@Param    : []
     *@Return   : void * com.example.controller.*.*.*(..)
     */
    //针对所有http请求进行切割
    @Pointcut("execution(public * com.example.controller..*(..))")
    public void log(){
        increaseUniqueVisitor();
    }


    /**
     *@Describe : 在方法执行前做一些事情
     *@Method   : doBetore
     *@Param    : [joinPoint]
     *@Return   : void
     */
    @Before("log()")
    public void doBetore(JoinPoint joinPoint){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =attributes.getRequest();
        //ip
        logger.info("ip                : {}",request.getRemoteAddr());
        //url   请求的URL
        logger.info("url               : {}",request.getRequestURI());
        //参数
        logger.info("args              : {}",joinPoint.getArgs());
        //method  请求的方式
        logger.info("requestMode       : {}",request.getMethod());
        //请求的类+方法名
        logger.info("className         : {}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        executionLog =new ExecutionLog();
        executionLog.setIp( request.getRemoteAddr());
        executionLog.setUrl( request.getRequestURI() );
        if ( joinPoint.getArgs().length > 0 ){ //针对没有参数项处理
            executionLog.setArgs( gson.toJson(joinPoint.getArgs()) );
        }
        executionLog.setClassName( joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        executionLog.setRequestMode( request.getMethod() );
        executionLog.setStartTime_ns( System.nanoTime() );
    }


    /**
     *@Describe : 在方法执行后做一切事情
     *@Method   : doAfter
     *@Param    : []
     *@Return   : void
     */
    @After("log()")
    public void doAfter(){
        executionLog.setMethodAccessTimes( String.valueOf(increaseUniqueVisitor()) );
        endTime_ns = System.nanoTime();
        //打印一下程序执行时间
        executionLog.setEndTime_ns( System.nanoTime() );
        logger.info("methodRunningTime :  {}",executionLog.getEndTime_ns() - executionLog.getStartTime_ns()+"ns 纳秒");
        executionLog.setMethodRunningTime( String.valueOf( executionLog.getEndTime_ns() - executionLog.getStartTime_ns() ) );
    }

    //打印 处理后的返回内容
    @AfterReturning( returning = "object" ,pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response          : {}",object.toString());
        executionLog.setResponse( gson.toJson(object) );
        executionLogService.save(executionLog);//保存日志
    }

    private Integer increaseUniqueVisitor(){
        return this.uniqueVisitor++;
    }

}
