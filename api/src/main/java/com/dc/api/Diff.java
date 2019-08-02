package com.dc.api;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class Diff {

    public static void main(String[] args) throws InterruptedException, IOException {
        long millis = System.currentTimeMillis();

        String proPath = "C://Users/Dc/Desktop/0711/T10151920H00012019070221000.txt";
        String newPath = "C://Users/Dc/Desktop/0711/N10151920H00012019070241000.txt";
        String outPath = "C://Users/Dc/Desktop/0711/diff.txt";
        List<String> listPro = new ArrayList<>();
        List<String> listNew = new ArrayList<>();
        readFile(listPro,listNew,proPath,newPath);
        listPro.removeAll(listNew);
        writeFile(listPro,outPath);

        log.info("耗时={}",System.currentTimeMillis() - millis);
    }

    private static void writeFile(List<String> listDiff,String outPath) throws IOException {

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outPath));
        for (String line:listDiff) {
//            String status = line.substring(254, 255);
//            if ("N".equals(status) || "*".equals(status) || "C".equals(status))
                outputStream.write((line.substring(22,48)+"\n").getBytes());
        }
        outputStream.close();
    }

    private static void readFile(List<String> listPro,List<String> listNew,String proPath,String newPath) throws IOException {

        BufferedReader readerPro = new BufferedReader(new FileReader(proPath));
        BufferedReader readerNew = new BufferedReader(new FileReader(newPath));
        String line;
        while ((line = readerPro.readLine()) != null)
            listPro.add(line);
        while ((line = readerNew.readLine()) != null)
            listNew.add(line);
        readerPro.close();
        readerNew.close();
    }

    private static List<String> diff(List<String> listPro,List<String> listNew) {
        List<String> listDiff = new ArrayList<>();
        for (String linePro:listPro) {
            boolean flag = true;
            for (String lineNew:listNew) {
                if (linePro.equals(lineNew)){
                    flag = false;
                    break;
                }
            }
            if (flag)
                listDiff.add(linePro);
        }
        return listDiff;
    }


//        CountDownLatch countDownLatch = new CountDownLatch(6);
//        new ReadFile(listPro, proPath, countDownLatch).start();
//        new ReadFile(listNew, newPath, countDownLatch).start();
//        countDownLatch.await();
}