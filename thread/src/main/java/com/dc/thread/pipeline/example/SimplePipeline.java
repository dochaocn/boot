package com.dc.thread.pipeline.example;

import java.util.*;
import java.util.concurrent.ExecutorService;

/**
 * 构建流水线任务步骤与任务启动
 * 将abstractPipe实例(业务处理逻辑)经过装饰者Decorator装饰成可执行线程
 *
 * defineExecutionSteps 构建流水线任务步骤
 * process 任务启动
 *
 * prototype,该组件为原型,每个具体策略类里都有自己的simplePipeline
 *
 * @author dc
 */

public class SimplePipeline<IN, OUT> {
    private final List<Pipe<IN, OUT>> decoratorPipes = new ArrayList<>();

    public void defineExecutionSteps(List<Pipe<IN, OUT>> pipeList, ExecutorService executorService) {
        this.addDecoratorPipes(pipeList, executorService);
        this.executionStep();
    }

    public void defineExecutionSteps(List<Pipe<IN, OUT>> pipeList) {
        this.addDecoratorPipes(pipeList);
        this.executionStep();
    }

    public void process(IN input) {
        Pipe<IN, OUT> firstDecoratorPipe = decoratorPipes.get(0);
        if (firstDecoratorPipe != null)
            firstDecoratorPipe.process(input);
    }

    private void addDecoratorPipes(List<Pipe<IN, OUT>> pipeList, ExecutorService executorService) {
        pipeList.forEach(pipe -> {
            AsyncPipeDecorator<IN, OUT> decoratorPipe = new AsyncPipeDecorator<>(pipe, executorService);
            decoratorPipes.add(decoratorPipe);
        });
    }

    private void addDecoratorPipes(List<Pipe<IN, OUT>> pipeList) {
        pipeList.forEach(pipe -> {
            SyncPipeDecorator<IN, OUT> decoratorPipe = new SyncPipeDecorator<>(pipe);
            decoratorPipes.add(decoratorPipe);
        });
    }

    private void executionStep() {
        Iterator<Pipe<IN, OUT>> decoratorPipesIterator = decoratorPipes.iterator();
        Pipe<IN, OUT> currentDecoratorPipe = decoratorPipesIterator.next();
        while (decoratorPipesIterator.hasNext()) {
            Pipe<IN, OUT> nextDecoratorPipe = decoratorPipesIterator.next();
            currentDecoratorPipe.setNextPipe(nextDecoratorPipe);
            currentDecoratorPipe = nextDecoratorPipe;
        }
    }

}
