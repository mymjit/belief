package com.example.services.log.impl;

import com.example.domail.log.ExecutionLog;
import com.example.repository.log.ExecutionLogRepository;
import com.example.services.log.ExecutionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Author : while
 * @Date : 2017/10/17
 * @Describe :
 */
@Service
public class ExecutionLogServiceImpl implements ExecutionLogService {

    @Autowired
    private ExecutionLogRepository executionLogRepository;

    @Transactional
    public ExecutionLog save(ExecutionLog executionLog) {
        return executionLogRepository.save(executionLog);
    }
}
