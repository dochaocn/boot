package com.bsb.rps.handler.disruptor;

import com.bsb.rps.entity.ReportRecord;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerDisruptor implements WorkHandler<ReportRecord> {

    @Override
    public void onEvent(ReportRecord record) throws InterruptedException {
        Thread.sleep(3000L);
        log.info("开始消费={}", record.toString());
    }
}
