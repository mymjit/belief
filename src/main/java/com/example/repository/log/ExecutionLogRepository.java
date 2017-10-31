package com.example.repository.log;

import com.example.domail.log.ExecutionLog;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : while
 * @Date : 2017/10/17
 * @Describe : 执行日志的Dao
 */
public interface ExecutionLogRepository extends JpaRepository<ExecutionLog, Integer> {


}
