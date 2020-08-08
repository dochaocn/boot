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

    @PostConstruct
    public void buildStage() {
        super.stageList.add("stageOne");
        super.stageList.add("stageTwo");
        super.stageList.add("stageThree");
        super.stageList.add("stageFour");
        super.useAsyncOrSync();
    }
}
