package com.example.services.log;

import com.example.domail.log.ExecutionLog;

/**
 * @Author : while
 * @Date : 2017/10/17
 * @Describe : 方法执行日志的接口
 */
public interface ExecutionLogService {

    ExecutionLog save(ExecutionLog executionLog);
}
