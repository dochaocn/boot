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

    public void pushRecord(Object object) {

        long sequence = ringBuffer.next();
        ReportRecord record = ringBuffer.get(sequence);
        record.setReportType("X2");
        record.setData(object);
        ringBuffer.publish(sequence);
        log.info("开始投递={}", record.toString());
    }

    public void run() {
        ringBuffer = disruptor.getRingBuffer();

        Page<BhSysProd> page = new Page<>();
        long current = 1L;

        while (true) {
            page.setCurrent(current++);
            page.setSize(size);
            List<BhSysProd> list = sysProdService.selectPage(page);
            if (list.size() > 0) {
                list.forEach(this::pushRecord);
            } else {
                disruptor.shutdown();
                break;
            }
        }
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
