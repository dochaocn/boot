package com.dc.thread.parallel.search;

import java.util.concurrent.ExecutionException;

public class SearchMain {

    public static void main(String[] args) {
        try {
            int[] array = {1,6,4,7,9,0,8};
            ParallelSearch pSearch = new ParallelSearch(array,2);
            int i = pSearch.pSearch(1);
            System.out.println(i);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
