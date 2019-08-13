package com.dc.thread.parallel.search;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelSearch {

    private int[] arr;
    private ExecutorService pool;
    private int Thread_Num;
    private AtomicInteger result;

    public ParallelSearch(int[] arr, int thread_Num) {
        this.arr = arr;
        this.Thread_Num = thread_Num;
        this.pool = Executors.newCachedThreadPool();
        this.result = new AtomicInteger(-1);
    }

    public int pSearch(int searchValue) throws ExecutionException, InterruptedException {
        int subArrSize = arr.length / Thread_Num + 1;
        List<Future<Integer>> futureList = new ArrayList<>();
        int end;
        for (int i = 0; i < arr.length; i +=  subArrSize) {
            end = (i+subArrSize) > arr.length?arr.length:(i+subArrSize);
            int finalEnd = end;
            int finalI = i;
            Future<Integer> submit = pool.submit(
                    () -> this.search(searchValue, finalI, finalEnd));

            futureList.add(submit);
        }

        for (Future<Integer> fu : futureList) {
            if (fu.get() >= 0)
                return fu.get();
        }

        return -1;
    }

    public int search(int searchValue, int begin, int end) {

        for (int i = begin; i < end; i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            if (arr[i] == searchValue) {
                if (!result.compareAndSet(-1, i))
                    return result.get();
                return i;
            }
        }
        return -1;
    }
}
