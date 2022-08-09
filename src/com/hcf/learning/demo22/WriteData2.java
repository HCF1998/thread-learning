package com.hcf.learning.demo22;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData2 {
    public void writeMethod(PipedWriter writer){
        try{
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = ""+(i+1);
                writer.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadWrite2 extends Thread {
    private WriteData2 write;
    private PipedWriter writer;

    public ThreadWrite2(WriteData2 write, PipedWriter writer) {
        super();
        this.write = write;
        this.writer = writer;
    }

    @Override
    public void run() {
        write.writeMethod(writer);
    }
}
