package com.bsb.rps.handler.impl.decorator;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.handler.Step;
import com.bsb.rps.handler.impl.step.AbstractStep;

public class SyncStepDecorator implements Step {

    private final AbstractStep abstractStep;

    public SyncStepDecorator(AbstractStep abstractStep) {
        this.abstractStep = abstractStep;
    }

    public void setNextStep(Step nextDecoratorStep) {
        abstractStep.setNextStep(nextDecoratorStep);
    }

    public void process(MachiningRecord input) {
        abstractStep.process(input);
    }

}