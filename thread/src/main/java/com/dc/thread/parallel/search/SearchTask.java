package com.dc.thread.parallel.search;

import java.util.concurrent.Callable;

public class SearchTask implements Callable<Integer>{

    private int begin,end,searchValue;
    private ParallelSearch parallelSearch;

    public SearchTask(int searchValue, int begin, int end, ParallelSearch parallelSearch) {
        this.searchValue = searchValue;
        this.begin = begin;
        this.end = end;
        this.parallelSearch = parallelSearch;
    }

    @Override
    public Integer call() {
        return parallelSearch.search(searchValue,begin,end);
    }
}
