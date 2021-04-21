package com.demo.demo2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * @author Cheung
 * @date 2021/3/11 11:31
 */
public class VisualAccumlatorTest {
    public static void main(String[] args) {
        int N=1000;//Integer.parseInt(args[0]);
        VisualAccumlator testDemo=new VisualAccumlator(N,1.0);
        for (int i = 0; i < N; i++)
            testDemo.addDataValue(StdRandom.random());
        StdOut.println(testDemo);


    }
}
