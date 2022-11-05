package com.hcf.learning.demo32;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatFix2 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05",
                "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};

        MyThread2[] threadArray = new MyThread2[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new MyThread2(simpleDateFormat, dateStringArray[i]);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}

class MyThread2 extends Thread {
    private SimpleDateFormat sdf;
    private String dateString;

    public MyThread2(SimpleDateFormat sdf, String dateString) {
        super();
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date dateRef = DateTools2.getSimpleDateFormat("yyyy-MM-dd").parse(dateString);
            String newDateString = DateTools2.getSimpleDateFormat("yyyy-MM-dd").format(dateRef).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName = " + this.getName() + "get error :" + dateString + "parsed to " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class DateTools2 {
    private static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<>();

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        SimpleDateFormat sdf = null;
        sdf = t1.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(datePattern);
            t1.set(sdf);
        }
        return sdf;
    }
}
