package com.dc.thread.pipeline.example.report;

import com.dc.thread.pipeline.example.log.HttpLogDao;
import com.dc.thread.pipeline.example.log.ResponseLog;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Slf4j
@Aspect
@Component
public class HttpReportAop {

    @Value("${response.queue.capacity}")
    private int capacity;

//    @Resource
//    private HttpLogDao httpLogDao;

    @Getter
    private volatile BlockingQueue<Object> messageQueue = new ArrayBlockingQueue<>(capacity);

    @Around(value = "execution(public Object com.dc.thread.pipeline.example.report.http..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        Instant start = Instant.now();
        String requestId = "";
        Object[] args = proceedingJoinPoint.getArgs();
        Object message = null;
        try {
            message = proceedingJoinPoint.proceed();
            messageQueue.put(message);
        } catch (Throwable t) {
            log.error("http请求错误", t);
        } finally {
            log.info("请求流水号={},请求参数={},请求耗时={},请求结果={}", requestId, Arrays.toString(args),
                    Duration.between(start, Instant.now()).toMillis(), message);
        }

//        httpLogDao.insert(new ResponseLog());

        return message;
    }

}
