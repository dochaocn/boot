package com.dc.api;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class ReadFile extends Thread{

    private List<String> list;
    private String path;
    private CountDownLatch countDownLatch;

    public ReadFile(List<String> list, String path, CountDownLatch countDownLatch) {
        this.list = list;
        this.path = path;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        BufferedReader readerPro = null;
        try {
            readerPro = new BufferedReader(new FileReader(path));
            String line;
            while ((line = readerPro.readLine()) != null)
                list.add(line);
        } catch (IOException e) {
            log.error("文件异常", e);
        } finally {
            try {
                if (readerPro != null)
                    readerPro.close();
            } catch (IOException e) {
                log.error("IO流关闭异常");
            }
            countDownLatch.countDown();
        }
    }
}
