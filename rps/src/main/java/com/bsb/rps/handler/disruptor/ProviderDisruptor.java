package com.bsb.rps.handler.disruptor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bsb.rps.entity.BhSysProd;
import com.bsb.rps.entity.ReportRecord;
import com.bsb.rps.service.IBhSysProdService;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Service
@Slf4j
public class ProviderDisruptor{

    private final Long size = 1L;
    private RingBuffer<ReportRecord> ringBuffer;

    @Setter
    private Disruptor<ReportRecord> disruptor;

    @Resource
    private IBhSysProdService sysProdService;

    public void start() {
        ringBuffer = disruptor.getRingBuffer();

//        Page<BhSysProd> page = new Page<>();
//        page.setSize(size);
//        long current = 1L;
//        List<BhSysProd> recordList;
//
//        while (true) {
//            page.setCurrent(current++);
//            recordList = sysProdService.selectPage(page);
//            if (recordList.size() > 0) {
//                recordList.forEach(record -> this.pushRecord("X2", record));
//            } else {
//                disruptor.shutdown();
//                break;
//            }
//        }

        List<BhSysProd> recordList;
        for (int i = 0; i < 100; i++) {
            Instant start = Instant.now();
            recordList = sysProdService.selectAll();
            log.error("耗时={}", Duration.between(start, Instant.now()).toMillis());
            recordList.forEach(record -> this.pushRecord("X2", record));
        }

//        ringBuffer.
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



//        Page<BhSysProd> iPage = new Page<>();
//        QueryWrapper<BhSysProd> wrapper = new QueryWrapper<>();
//        wrapper.eq("LOOP_STATUS", "N");
//
//        long current = 1L;
//        List<BhSysProd> list;
//        while (true) {
//            iPage.setCurrent(current++);
//            iPage.setSize(1L);
//            list = sysProdService.page(iPage, wrapper).getRecords();
//            if (list.size() == 0)
//                break;
//
//            list.forEach(this::pushRecord);
//        }
