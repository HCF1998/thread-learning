package com.hcf.learning.demo32;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDataFormatFix1 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String[] dateStringArray = new String[]{"2000-01-01", "2000-01-02", "2000-01-03", "2000-01-04", "2000-01-05",
                "2000-01-06", "2000-01-07", "2000-01-08", "2000-01-09", "2000-01-10"};

        MyThread1[] threadArray = new MyThread1[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new MyThread1(simpleDateFormat, dateStringArray[i]);
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}

class MyThread1 extends Thread {

    private SimpleDateFormat sdf;
    private String dateString;

    public MyThread1(SimpleDateFormat sdf, String dateString) {
        super();
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date dateRef = DateTools.parse("yyyy-MM-dd", dateString);
            String newDateString = DateTools.format("yyyy-MM-dd", dateRef).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName=" + this.getName() + " get error " + dateString + " parsed to " + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class DateTools {

    public static Date parse(String formatPattern, String dateString) throws ParseException {
        return new SimpleDateFormat(formatPattern).parse(dateString);
    }

    public static String format(String formatPattern, Date date) {
        return new SimpleDateFormat(formatPattern).format(date).toString();
    }
}
