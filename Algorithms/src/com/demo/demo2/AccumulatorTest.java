package com.demo.demo2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

/**
 * @author Cheung
 * @date 2021/3/11 11:09
 */
public class AccumulatorTest {
    public static void main(String[] args) {
     int T=Integer.parseInt(args[0]);
     Accumulator testDemo1=new Accumulator();
        for (int i = 0; i < T; i++)
            testDemo1.addDataValue(StdRandom.random());
        StdOut.println(testDemo1);
    }
}
