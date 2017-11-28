package com.example.services.log.impl;

import com.example.domail.log.ExecutionLog;
import com.example.repository.log.ExecutionLogRepository;
import com.example.services.log.ExecutionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *@date     : 2017/11/6
 *@author   : whilte
 *@describe :
 */
@Service
public class ExecutionLogServiceImpl implements ExecutionLogService {

    @Autowired
    private ExecutionLogRepository executionLogRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ExecutionLog executionLog) {
        executionLogRepository.save(executionLog);
    }


}
