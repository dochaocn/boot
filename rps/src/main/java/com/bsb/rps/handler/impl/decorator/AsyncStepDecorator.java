package com.bsb.rps.handler.impl.decorator;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.handler.Step;
import com.bsb.rps.handler.impl.step.AbstractStep;

import java.util.concurrent.ExecutorService;

public class AsyncStepDecorator implements Step{
    private final AbstractStep abstractStep;
    private final ExecutorService executorService;

    public AsyncStepDecorator(AbstractStep abstractStep, ExecutorService executorService) {
        this.abstractStep = abstractStep;
        this.executorService = executorService;
    }

    public void setNextStep(Step nextDecoratorStep) {
        abstractStep.setNextStep(nextDecoratorStep);
    }

    public void process(MachiningRecord input) {
        executorService.execute(() -> abstractStep.process(input));
    }

}
