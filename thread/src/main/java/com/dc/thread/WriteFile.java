package com.dc.thread;

import java.io.*;

public class WriteFile {

    public static void main(String[] args) throws IOException {
        long l = System.currentTimeMillis();
        OutputStream outputStream = new FileOutputStream(new File("D:\\人行小组/sql0.txt"));
        StringBuilder buffer;
        for (int i = 0; i < 1000000; i++) {
            buffer = new StringBuilder();
            for (int j = 0; j < 500; j++) {
                buffer.append("a");
            }
            outputStream.write(buffer.append("\n").toString().getBytes());
        }
        outputStream.close();
        System.out.println(System.currentTimeMillis() - l);
    }

}
