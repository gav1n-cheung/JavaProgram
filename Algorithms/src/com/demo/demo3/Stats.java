package com.demo.demo3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;

/**
 * @author Cheung
 * @date 2021/3/26 8:17
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> test=new Bag<Double>();

        while (!StdIn.isEmpty())
            test.add(StdIn.readDouble());
        int N=test.size();

        double sum=0.0;

        for (double x:test)
            sum+=x;
        double mean=sum/N;

        sum=0.0;
        for (double x:test)
            sum+=(x-mean)*(x-mean);
        double std=Math.sqrt(sum/(N-1));

        System.out.println("平均值为"+mean);
        System.out.println("样本标准差为"+std);

    }



}
