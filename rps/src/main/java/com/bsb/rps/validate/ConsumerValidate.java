package com.bsb.rps.validate;

import com.bsb.rps.dto.ReportRecord;
import com.bsb.rps.util.CountNumUtil;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ConsumerValidate implements WorkHandler<ReportRecord> {

    @Resource
    private Validate x2Validate;
    @Resource
    private Validate d2AndCL1Validate;
    @Resource
    private Validate d3AndCL2Validate;

    @Override
    public void onEvent(ReportRecord record) {
        String recordType = record.getRecordType();

        try {
            if (d3AndCL2Validate.judge(recordType)) {
                d3AndCL2Validate.validate(record);
            } else if (d2AndCL1Validate.judge(recordType)) {
                d2AndCL1Validate.validate(record);
            } else if (x2Validate.judge(recordType)) {
                x2Validate.validate(record);
            } else {
                log.error("无效的recordType={}, data={}", recordType, record.getData());
            }
        } catch (Exception e) {
            log.error("校验失败!", e);
        } finally {
            CountNumUtil.incrementConsumeCount();
        }

    }

}
