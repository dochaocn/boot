package com.dc.thread.pipeline.example.controller;

import com.dc.thread.pipeline.example.strategy.D2SingleLoanAccountInfo;
import com.dc.thread.pipeline.example.strategy.ReportStrategy;
import com.dc.thread.pipeline.example.strategy.X2LoopLoanAccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
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

    @Resource
    private ExecutorService executorService;

    @RequestMapping("/batch")
    @ResponseBody
    public String batch() {
        executorService.execute(() -> {
            for (int i = 0; i < 50000; i++) {
                int finalI = i;
                strategyList.forEach(strategy -> {
                    if (strategy.isThis("X2LoopLoanAccountInfo")) {
                        strategy.execute("Task-X2-" + finalI); // 只负责调起第一步
                    }
                });
            }
        });

        return "提交任务成功,执行中...";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        strategyList.addAll(applicationContext.getBeansOfType(X2LoopLoanAccountInfo.class).values());
        strategyList.addAll(applicationContext.getBeansOfType(D2SingleLoanAccountInfo.class).values());
    }
}
