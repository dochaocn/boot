package com.bsb.rps.validate;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.dto.ReportRecord;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.enums.ReportType;
import com.bsb.rps.util.CountNumUtil;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProviderValidate {

    private final Long size = 100L;
    private RingBuffer<ReportRecord> ringBuffer;

    @Setter
    private Disruptor<ReportRecord> disruptor;

    public void start() {
        ringBuffer = disruptor.getRingBuffer();
        CountNumUtil.init();

        Page<BhSysProd> page = new Page<>();
        page.setSize(size);

        // 取X2信息
        long current = 1L;
        List<BhSysProd> recordList;
        while (true) {
            page.setCurrent(current++);
            recordList = null; // service.get(...);
            if (recordList.size() > 0) {
                CountNumUtil.addProductCount(recordList.size());
                recordList.forEach(record -> this.pushRecord(ReportType.X2.getCode(), record));
            } else {
                disruptor.shutdown(); //TODO 取玩所有类型(D2,CL1,D3,CL2,X2)的数据后 再shutdown
                break;
            }
        }

        // 取D2,CL1信息


        // 取D3,CL2信息


    }

    private void pushRecord(String recordType, Object object) {
        long sequence = ringBuffer.next();
        ReportRecord record = ringBuffer.get(sequence);
        record.setRecordType(recordType);
        record.setData(object);
        ringBuffer.publish(sequence);
        log.info("开始投递={}", record.toString());
    }

}
