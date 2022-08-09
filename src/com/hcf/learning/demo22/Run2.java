package com.hcf.learning.demo22;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Run2 {
    public static void main(String[] args) {
        try{
            WriteData2 writeData2 = new WriteData2();
            ReadData2 readData2 = new ReadData2();

            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();
            pipedWriter.connect(pipedReader);

            ThreadWrite2 threadWrite2 = new ThreadWrite2(writeData2, pipedWriter);
            ThreadRead2 threadRead2 = new ThreadRead2(readData2, pipedReader);

            threadRead2.start();
            Thread.sleep(1000);
            threadWrite2.start();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
