package com.hcf.learning.demo22;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream pipedInputStream = new PipedInputStream();
            PipedOutputStream pipedOutputStream = new PipedOutputStream();

            //pipedInputStream.connect(pipedOutputStream);
            pipedOutputStream.connect(pipedInputStream);
            
            ThreadRead threadRead = new ThreadRead(readData, pipedInputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, pipedOutputStream);
            threadWrite.start();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
