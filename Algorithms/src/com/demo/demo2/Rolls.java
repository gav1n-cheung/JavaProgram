package com.demo.demo2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

/**
 * @author Cheung
 * @date 2021/2/9 11:38
 */
public class Rolls {


    public static void main(String[] args) {
        int T=Integer.parseInt("100000");
        int sides=6;
        Counter[] rolls=new Counter[sides+1];
        for (int i = 1; i <= sides; i++)
             rolls[i]=new Counter(i+"'s");
        for (int i = 0; i < T; i++) {
            int result= StdRandom.uniform(1,sides+1);
            rolls[result].increment();
        }
        for (int i = 1; i <= sides; i++)
            StdOut.println(rolls[i]);

    }


}
