package com.dc.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Study {

    public void test() {

    }

    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> safeList = new CopyOnWriteArrayList<>();

        vector.add("vector");
        list.add("ArrayList");
        safeList.add("safeList");

        System.out.println(vector);
        System.out.println(list);
        System.out.println(safeList);

        List<Object> objects = Collections.emptyList();
        List<String> strings = Arrays.asList("");

        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        rwLock.readLock().lock();
        rwLock.writeLock().lock();
        

    }

}
