package com.dc.thread.pipeline.example;

import com.dc.thread.pipeline.example.decorator.AsyncPipeDecorator;
import com.dc.thread.pipeline.example.decorator.SyncPipeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
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

@Slf4j
@Component
@Scope("prototype")
public class SimplePipeline<IN, OUT> {
    private final List<Pipe<IN, OUT>> decoratorPipes = new ArrayList<>();

    @Resource
    private ExecutorService executorService;
    @Resource
    private ApplicationContext applicationContext;

    public void definePipeLineAsyncSteps(List<String> pipeList) {
        this.addAsyncDecoratorPipes(pipeList);
        this.executionStep();
    }

    public void defineSimpleAsyncSteps(List<String> pipeList) {
        this.addSyncDecoratorPipes(pipeList);
        this.executionStep();
    }

    public void process(IN input, String processType) {
        Pipe<IN, OUT> firstDecoratorPipe = decoratorPipes.get(0);
        if (firstDecoratorPipe != null) {
            if ("SimpleAsync".equals(processType))
                executorService.execute(() -> firstDecoratorPipe.process(input));
            else
                firstDecoratorPipe.process(input);
        }
    }

    private void addAsyncDecoratorPipes(List<String> pipeNameList) {
        pipeNameList.forEach(pipeName -> {
            Pipe<IN, OUT> abstractPipe = (Pipe<IN, OUT>) applicationContext.getBean(pipeName);
            decoratorPipes.add(new AsyncPipeDecorator<>(abstractPipe, executorService));
        });
    }

    private void addSyncDecoratorPipes(List<String> pipeNameList) {
        pipeNameList.forEach(pipeName -> {
            Pipe<IN, OUT> pipe = (Pipe<IN, OUT>) applicationContext.getBean(pipeName);
            decoratorPipes.add(new SyncPipeDecorator<>(pipe));
        });
    }

    private void executionStep() {
        Iterator<Pipe<IN, OUT>> decoratorPipesIterator = decoratorPipes.iterator();
        Pipe<IN, OUT> currentDecoratorPipe = decoratorPipesIterator.next();
        Pipe<IN, OUT> nextDecoratorPipe;
        while (decoratorPipesIterator.hasNext()) {
            nextDecoratorPipe = decoratorPipesIterator.next();
            currentDecoratorPipe.setNextPipe(nextDecoratorPipe);
            currentDecoratorPipe = nextDecoratorPipe;
        }
        System.out.println("aaa");
    }

}
