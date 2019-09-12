package com.dc.thread.pipeline.example.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class D2SingleLoanAccountInfo extends AbstractReportStrategy {

    @Override
    public boolean isThis(Object object) {
        String str = (String) object;
        return "D2SingleLoanAccountInfo".equals(str);
    }

    @Override
    public void execute(Object object) {
        simplePipeline.process(object);
    }

    @PostConstruct
    public void buildStage() {
        super.stageList.add(super.stageTwo);
        super.stageList.add(super.stageThree);
        super.stageList.add(super.stageOne);
        super.stageList.add(super.stageFour);
        super.useAsyncOrSync();
    }
}
