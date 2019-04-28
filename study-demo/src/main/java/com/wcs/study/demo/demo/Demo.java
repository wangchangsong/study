package com.wcs.study.demo.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Demo {

    public static String dateAddMonth(String str) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date date = null;
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        Date targetDate = calendar.getTime();
        return simpleDateFormat.format(targetDate);
    }

    public static Integer getMonthFromNow() {
        LocalDate oldDate = LocalDate.of(2019, 3, 1);
        LocalDate now = LocalDate.now();
        Period period = Period.between(oldDate, now);

        return period.getMonths();
    }

    public static String test() {
        LocalDate localDate = LocalDate.of(2018, 07, 01);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMM");
        return formatter2.format(localDate.plusMonths(1));

    }


    public static void main(String[] args) throws Exception {
        System.out.println(new BigDecimal("87347.983"));

    }
}
