package com.bsb.rps.handler.disruptor;

import com.bsb.rps.entity.ReportRecord;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

@Service
@Slf4j
public class MainDisruptor {

    @Resource
    private ExecutorService executorService;
    @Resource
    private ThreadFactory threadFactory;
    @Resource
    private ConsumerDisruptor consumerDisruptor;
    @Resource
    private ProviderDisruptor providerDisruptor;

    public void test() {
        int bufferSize = 1024;
        Disruptor<ReportRecord> disruptor = new Disruptor<>(ReportRecord::new, bufferSize, threadFactory);
        disruptor.handleEventsWithWorkerPool(consumerDisruptor);
        disruptor.start();

        providerDisruptor.setDisruptor(disruptor);
        executorService.execute(() -> providerDisruptor.run());

    }

    @PostConstruct
    public void init() {

    }
}
