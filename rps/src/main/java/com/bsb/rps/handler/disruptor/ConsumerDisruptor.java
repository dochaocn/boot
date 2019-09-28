package com.bsb.rps.handler.disruptor;

import com.bsb.rps.entity.ReportRecord;
import com.bsb.rps.handler.validate.Validate;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@Service
@Slf4j
public class ConsumerDisruptor implements WorkHandler<ReportRecord> {

    @Resource
    private Validate x2Validate;
    @Resource
    private Validate d2AndCL1Validate;
    @Resource
    private Validate d3AndCL2Validate;
    @Resource
    private ExecutorService executorService;

    @Override
    public void onEvent(ReportRecord record) {
        String recordType = record.getRecordType();

        executorService.execute(() -> {
            if (d3AndCL2Validate.match(recordType)) {
                d3AndCL2Validate.validate(record);
            } else if (d2AndCL1Validate.match(recordType)) {
                d2AndCL1Validate.validate(record);
            } else if (x2Validate.match(recordType)) {
                x2Validate.validate(record);
            } else {
                log.error("无效的recordType={}, data={}", recordType, record.getData());
            }
        });

    }

}
