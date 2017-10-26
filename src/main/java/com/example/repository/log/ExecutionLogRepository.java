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


    @SQLInsert(sql = "insert into execution_log( args, class_name, end_time_ns, ip," +
            " method_access_times, method_running_time, request_mode, response," +
            " start_time_ns, url ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")
    public ExecutionLog save(ExecutionLog executionLog);


}
