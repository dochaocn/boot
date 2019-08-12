package com.dc.thread.procon;

import java.time.LocalDateTime;
import java.util.Random;

/**
 *  线程安全的单例
 *  静态内部类实现懒初始化，且不会重复创建
 */
public class IdSingle {

    private Random random;

    private IdSingle(Random random){
        this.random = random;
    }

    public static Integer getIntegerId() {
        return getInstance().random.nextInt(99999) + LocalDateTime.now().getSecond();
    }

    public static IdSingle getInstance() {
        return Single.getInstance();
    }

    private static class Single {
        private static IdSingle idSingle = null;
        private static IdSingle getInstance() {
           return idSingle == null ? new IdSingle(new Random()):idSingle;
        }
    }

}
