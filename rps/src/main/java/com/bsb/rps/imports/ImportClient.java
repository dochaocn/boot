package com.bsb.rps.imports;

import com.bsb.rps.manager.ProcessDateManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Slf4j
@Component
public class ImportClient implements ApplicationContextAware {

    private final Collection<Import> importList = new ArrayList<>(5);

    @Resource
    private ExecutorService executorService;

    public void startImport() {
        Map<String, String> param = this.getParamMap();

//        importList.forEach(importTask -> importTask.process(param));

        importList.forEach(importTask -> executorService.execute(() -> importTask.process(param)));

        // TODO 单元测试 多线程execute提交失效, submit提交并get结果不失效
//        importList.forEach(importTask -> {
//            Future<?> future = executorService.submit(() -> importTask.process(param));
//            try {
//                future.get();
//            } catch (Throwable e) {
//                log.error("", e);
//            }
//        });

    }

    private Map<String, String> getParamMap() {
        String processDate = ProcessDateManager.getProcessDate();
        Map<String, String> param = new HashMap<>();
        param.put("tableName", processDate.replaceAll("-", ""));
        param.put("inputDate", "'" + processDate + "'");
        return param;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.importList.addAll(applicationContext.getBeansOfType(Import.class).values());
    }

}
