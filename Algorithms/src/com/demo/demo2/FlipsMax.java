package com.demo.demo2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Cheung
 * @date 2021/2/9 11:25
 */
public class FlipsMax {

    private static Counter max(Counter x,Counter y){
        if (x.tally()>y.tally()) return x;
        else return y;
    }

    public static void main(String[] args) {
        int T=Integer.parseInt("10000");
        Counter heads=new Counter("heads");
        Counter tails=new Counter("tails");
        for (int i = 0; i < T; i++)
            if (StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();

        if(heads.tally()==tails.tally())
            StdOut.println("Tie");
        else StdOut.println(max(heads,tails)+" wins");
    }

}
