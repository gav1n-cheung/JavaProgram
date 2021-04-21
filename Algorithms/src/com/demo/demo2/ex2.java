package com.demo.demo2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/3/25 8:10
 */
public class ex2 {

    public static void main(String[] args) {
        int N=Integer.parseInt("2");
        Interval1D[] test=new Interval1D[N];
        for (int i = 0; i < N; i++) {
            test[i]=new Interval1D(StdIn.readDouble(),StdIn.readDouble());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (test[i].intersects(test[j])) System.out.println(test[i]+"与"+test[j]+"相交");
                else System.out.println("没有相交的对");
            }

        }

    }

}
