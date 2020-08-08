package com.dc.thread;

import java.time.*;
import java.time.temporal.Temporal;
import java.util.stream.LongStream;

public class StreamCompute {

    public static void main(String[] args) {

        Temporal start1 = getNow();
        long reduce = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(reduce);
        System.out.println(Duration.between(start1, getNow()).toMillis() + "ms");

        System.out.println("===================");

        Temporal start2 = getNow();
        long sum = 0L;
        for (long i = 0L; i < 50000000000L; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
        System.out.println(Duration.between(start2, getNow()).toMillis() + "ms");
    }

    private static Temporal getNow() {
        return Instant.now();
    }
}
