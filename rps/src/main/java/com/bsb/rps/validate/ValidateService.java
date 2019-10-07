package com.bsb.rps.validate;

import com.bsb.rps.dto.ReportRecord;
import com.bsb.rps.util.CountNumUtil;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.*;

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
        int bufferSize = 1024 * 5;
        Disruptor<ReportRecord> validateDisruptor = new Disruptor<>(ReportRecord::new, bufferSize, threadFactory);
        validateDisruptor.handleEventsWithWorkerPool(consumerValidate);
        validateDisruptor.start();

        providerValidate.setDisruptor(validateDisruptor);
        executorService.execute(() -> {
            providerValidate.start();

            ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor(threadFactory);
            scheduledExecutor.scheduleAtFixedRate(() -> {
                if (CountNumUtil.equals()) {
                    // 证明消费者线程已全部消费完成，且已经关闭
                    scheduledExecutor.shutdown();
                }
            }, 5, 1, TimeUnit.SECONDS);
        });

    }

}
