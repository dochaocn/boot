package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.handler.Step;

public abstract class AbstractStep implements Step {

    private Step nextDecoratorStep;

    @Override
    public void setNextStep(Step nextDecoratorStep) {
        this.nextDecoratorStep = nextDecoratorStep;
    }

    @Override
    public void process(MachiningRecord input) {
        MachiningRecord out = doProcess(input);
        if (nextDecoratorStep != null && out != null)
            nextDecoratorStep.process(out);
    }

    /**
     * 留给子类实现，用于子类实现其任务处理逻辑
     */
    public abstract MachiningRecord doProcess(MachiningRecord input);

}
