package com.demo.demo2;

import edu.princeton.cs.algs4.In;

import java.awt.*;

/**
 * @author Cheung
 * @date 2021/3/23 9:13
 */
public class StaticsSETofIntsTest {
    public static void main(String[] args) {
        int[] w= In.readInts(args[0]);//{10,8,8,7,7,7,1);
        StaticsSETofInts array=new StaticsSETofInts(w);
        System.out.println(array.contains(10));
    }
}
