package com.hcf.learning.demo22;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData2 {
    public void readMethod(PipedReader read) {
        try {
            System.out.println("read: ");
            char[] byteArray = new char[20];
            int readLength = read.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println(newData);
                readLength = read.read(byteArray);
            }
            System.out.println();
            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadRead2 extends Thread {

    private ReadData2 read;
    private PipedReader reader;

    public ThreadRead2(ReadData2 read, PipedReader reader) {
        super();
        this.read = read;
        this.reader = reader;
    }

    @Override
    public void run() {
        read.readMethod(reader);
    }
}