package com.hcf.learning.demo22;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream input){
        try{
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while(readLength != -1){
                String newData = new String(byteArray, 0, readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
