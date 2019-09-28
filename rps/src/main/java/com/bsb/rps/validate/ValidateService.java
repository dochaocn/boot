package com.bsb.rps.validate;

import com.bsb.rps.entity.ReportRecord;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

@Service
@Slf4j
public class ValidateService {

    @Resource
    private ExecutorService executorService;
    @Resource
    private ThreadFactory threadFactory;
    @Resource
    private ConsumerValidate consumerValidate;
    @Resource
    private ProviderValidate providerValidate;

    public void startValidate() {
        int bufferSize = 1024;
        Disruptor<ReportRecord> disruptor = new Disruptor<>(ReportRecord::new, bufferSize, threadFactory);
        disruptor.handleEventsWithWorkerPool(consumerValidate);
        disruptor.start();

        providerValidate.setDisruptor(disruptor);
        executorService.execute(() -> providerValidate.start());

    }

}
