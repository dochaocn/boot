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
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class ImportAop {

    @Resource
    private IBhLogTaskService logTaskService;

    @Around(value = "execution(public void com.bsb.rps.imports.impl..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Instant start = Instant.now();
        String taskTime;

        String taskName = ((Import) proceedingJoinPoint.getTarget()).getImportTaskName();
        BhLogTask logTask = logTaskService.insert(taskName);

        try {
            log.info("更新全量表开始={}, 参数={}", taskName, Arrays.toString(proceedingJoinPoint.getArgs()));
            proceedingJoinPoint.proceed();
            taskTime = Duration.between(start, Instant.now()).toMillis() + "ms";
            log.info("更新全量表完成={}, 耗时={}", taskName, taskTime);

            logTaskService.updateSuccessById(logTask.getTaskId(), taskTime);
        } catch (Throwable t) {
            log.error(taskName + "失败...", t);

            taskTime = Duration.between(start, Instant.now()).toMillis() + "ms";
            logTaskService.updateErrorById(logTask.getTaskId(), taskTime);
        } finally {
            CountDownManager.countDown();
        }

        return null;
    }
}
