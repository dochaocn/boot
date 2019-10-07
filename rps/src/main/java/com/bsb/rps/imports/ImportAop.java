package com.bsb.rps.imports;

import com.bsb.rps.entity.BhLogTask;
import com.bsb.rps.manager.CountDownManager;
import com.bsb.rps.service.IBhLogTaskService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class ImportAop {

    @Resource
    private IBhLogTaskService logTaskService;

    @Around(value = "execution(public void com.bsb.rps.imports.impl..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Instant start = Instant.now();
        String taskTime = "0ms";

        String taskName = ((Import) proceedingJoinPoint.getTarget()).getImportTaskName();
        BhLogTask logTask = logTaskService.insert(taskName);

        try {
            proceedingJoinPoint.proceed();
            taskTime = Duration.between(start, Instant.now()).toMillis() + "ms";
            logTaskService.updateSuccessById(logTask.getTaskId(), taskTime);
        } catch (Throwable t) {
            log.error(taskName + "失败...", t);
            taskTime = Duration.between(start, Instant.now()).toMillis() + "ms";
            logTaskService.updateErrorById(logTask.getTaskId(), taskTime);
        } finally {
            log.info(taskName+"耗时={}", taskTime);
            CountDownManager.countDown();
        }

        return null;
    }
}
