package com.dc.thread.pipeline;

/**
 * 对复合Pipe的抽象。一个Pipeline实例可包含多个Pipe实例
 * @author huzhiqiang
 *
 * @param <IN>
 * @param <OUT>
 */
public interface PipeLine<IN, OUT> extends Pipe<IN, OUT> {
    void addPipe(Pipe<?,?> pipe);
}