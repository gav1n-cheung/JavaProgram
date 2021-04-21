package com.demo.demo2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Cheung
 * @date 2021/2/9 10:28
 */
public class Flips {
    public static void main(String[] args) {

        int T=Integer.parseInt("10000");
        Counter heads=new Counter("heads");
        Counter tails=new Counter("tails");
        for (int i = 0; i < T; i++)
            if (StdRandom.bernoulli(0.5))
                 heads.increment();
            else tails.increment();
        StdOut.println(heads);
        StdOut.println(tails);
        int d=heads.tally()-heads.tally();
        StdOut.println("detal"+ Math.abs(d));
    }
}
