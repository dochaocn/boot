package com.dc.thread.pipeline.example.controller;

import com.dc.thread.pipeline.example.strategy.ReportStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

@Slf4j
@Controller
public class RequestController implements ApplicationContextAware {

    private Collection<ReportStrategy> collection;

    @Resource
    private ExecutorService executorService;

    @RequestMapping("/batch")
    @ResponseBody
    public String batch() {

        executorService.execute(() -> {
            for (int i = 0; i < 500000; i++) {
                int finalI = i;
                collection.forEach(strategy -> {
                    if (strategy.isThis("X2LoopLoanAccountInfo")) {
                        try {
                            strategy.execute("Task-X2-" + finalI);
                        } catch (InterruptedException e) {
                            log.error("", e);
                        }
                    }
                });
            }

//            for (int i = 0; i < 1000; i++) {
//                int finalI = i;
//                collection.forEach(strategy -> {
//                    if (strategy.isThis("D2SingleLoanAccountInfo")) {
//                        try {
//                            strategy.execute("Task-D2-" + finalI);
//                        } catch (InterruptedException e) {
//                            log.error("", e);
//                        }
//                    }
//                });
//            }
        });

        return "提交任务成功,执行中...";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        collection = applicationContext.getBeansOfType(ReportStrategy.class).values();
    }
}
