package com.bsb.rps.handler.impl.step;

import com.bsb.rps.dto.MachiningRecord;
import com.bsb.rps.handler.Step;
import com.bsb.rps.handler.impl.decorator.AsyncStepDecorator;
import com.bsb.rps.handler.impl.decorator.SyncStepDecorator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 构建流水线任务步骤与任务启动
 * 将abstractStep实例(业务处理逻辑)经过装饰者Decorator装饰成可执行线程
 *
 * defineExecutionSteps 构建流水线任务步骤
 * process 任务启动
 *
 * prototype,该组件为原型,每个具体策略类里都有自己的StepLine
 *
 * @author Dc
 */
@Component
@Scope("prototype")
public class StepLine {
    private final List<Step> decoratorStepList = new ArrayList<>();

    @Resource
    private ExecutorService executorService;

    public void defineAsyncExecutionSteps(List<AbstractStep> stepList) {
        this.addDecoratorSteps(stepList, executorService);
        this.executionStep();
    }

    public void defineSyncExecutionSteps(List<AbstractStep> stepList) {
        this.addDecoratorSteps(stepList);
        this.executionStep();
    }

    public void startProcess(MachiningRecord input) {
        Step firstDecoratorStep = decoratorStepList.get(0);
        if (firstDecoratorStep != null)
            firstDecoratorStep.process(input);
    }

    private void addDecoratorSteps(List<AbstractStep> stepList, ExecutorService executorService) {
        stepList.forEach(step -> decoratorStepList.add(new AsyncStepDecorator(step, executorService)));
    }

    private void addDecoratorSteps(List<AbstractStep> stepList) {
        stepList.forEach(step -> decoratorStepList.add(new SyncStepDecorator(step)));
    }

    private void executionStep() {
        Iterator<Step> decoratorStepsIterator = decoratorStepList.iterator();
        Step currentDecoratorStep = decoratorStepsIterator.next();
        Step nextDecoratorStep;
        while (decoratorStepsIterator.hasNext()) {
            nextDecoratorStep = decoratorStepsIterator.next();
            currentDecoratorStep.setNextStep(nextDecoratorStep);
            currentDecoratorStep = nextDecoratorStep;
        }
    }

}
