package com.dc.thread.pipeline.example.controller;

import com.dc.thread.pipeline.example.RequestBody;
import com.dc.thread.pipeline.example.report.ReportType;
import com.dc.thread.pipeline.example.service.BaseInfoService;
import com.dc.thread.pipeline.example.strategy.D2SingleLoanAccountInfo;
import com.dc.thread.pipeline.example.strategy.ReportStrategy;
import com.dc.thread.pipeline.example.strategy.X2LoopLoanAccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;

@Slf4j
@Controller
public class RequestController implements ApplicationContextAware {

    private final List<ReportStrategy> strategyList = new ArrayList<>();
    private final List<ReportType> reportTypeList = new ArrayList<>();

    @Value("${task.num}")
    private int taskNum;

    @Resource
    private ExecutorService executorService;
    @Resource
    private BaseInfoService baseInfoService;

    @RequestMapping("/batch")
    @ResponseBody
    public String batch() {

        new Thread(() -> {

            for (int i = 0; i < taskNum; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    strategyList.forEach(strategy -> {
                        if (strategy.isThis("X2LoopLoanAccountInfo")) {
                            strategy.execute("Task-X2-" + finalI); // 只负责调起第一步
                        }
                        if (strategy.isThis("D2SingleLoanAccountInfo")) {
                            strategy.execute("Task-D2-" + finalI); // 只负责调起第一步
                        }
                    });
                });
            }

        }, "提交任务").start();

        return "提交任务成功,执行中...";
    }

    @RequestMapping("/batch1")
    @ResponseBody
    public String batch1() {

        new Thread(() -> {

            for (int i = 0; i < taskNum; i++) {
                int finalI = i;
                strategyList.forEach(strategy -> {
                    if (strategy.isThis("X2LoopLoanAccountInfo")) {
                        strategy.execute("Task-X2-" + finalI); // 只负责调起第一步
                    }
                    if (strategy.isThis("D2SingleLoanAccountInfo")) {
                        strategy.execute("Task-D2-" + finalI); // 只负责调起第一步
                    }
                });
            }

        }, "提交任务").start();

        return "提交任务成功,执行中...";
    }

    @RequestMapping("/report")
    @ResponseBody
    public String report() {
        String reportType = "http";
        RequestBody requestBody = baseInfoService.selectBaseInfo("");
        List<Object> list = requestBody.getObj();
        String url = requestBody.getUrl();
        list.forEach(body -> {
            reportTypeList.forEach(type -> {
                if (type.isType(reportType)) {
                    executorService.execute(() -> {
                        Object result = type.execute(body, url);
                        // TODO 投递到队列里, 另一个线程把返回信息存入数据库
                    });
                }
            });
        });

        return "任务成功";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        strategyList.addAll(applicationContext.getBeansOfType(X2LoopLoanAccountInfo.class).values());
        strategyList.addAll(applicationContext.getBeansOfType(D2SingleLoanAccountInfo.class).values());

        reportTypeList.addAll(applicationContext.getBeansOfType(ReportType.class).values());
    }
}
