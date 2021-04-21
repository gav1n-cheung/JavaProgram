package com.demo.demo2;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/3/11 10:26
 */
public class DateTest {

    public static void main(String[] args) {
        int day=Integer.parseInt(args[0]);
        int month=Integer.parseInt(args[1]);
        int year=Integer.parseInt(args[1]);

        DateTest1 testDemo1=new DateTest1(day,month,year);
        DateTest2 testDemo2=new DateTest2(day,month,year);

        StdOut.println(testDemo1);
        StdOut.println(testDemo2);

    }
}
