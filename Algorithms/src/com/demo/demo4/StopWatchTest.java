package com.demo.demo4;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * @author Cheung
 * @date 2021/4/1 8:10
 */
public class StopWatchTest {
    public static void main(String[] args) {
        int N=2000;
        int[] a=new int[N];
        for (int i = 0; i < N; i++)
            a[i]= StdRandom.uniform(-1000000,1000000);
        StopWatch test=new StopWatch();
        int cnt= ThreeSum.count(a);
        double time=test.elapsestart();
        System.out.println(cnt+" triples "+time+" seconds");


    }

}
