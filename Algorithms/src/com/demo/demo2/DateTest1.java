package com.demo.demo2;

import java.util.Date;

/**
 * @author Cheung
 * @date 2021/3/11 9:54
 */
public class DateTest1 {

    private final int day;
    private final int month;
    private final int year;

    public DateTest1(int d, int m, int y){
        day=d;
        month=m;
        year=y;
    }

    private int day(){
        return day;
    }
    private int month(){
        return month;
    }
    private int year(){
        return year;
    }

    public String toString(){
        return month()+"/"+day()+"/"+year();
    }

}
