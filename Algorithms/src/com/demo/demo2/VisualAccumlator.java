package com.demo.demo2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Cheung
 * @date 2021/3/11 11:20
 */
public class VisualAccumlator {
    private double total;
    private int N;

    public VisualAccumlator(int trials,double max){
        StdDraw.setXscale(0,trials);
        StdDraw.setYscale(0,max);
        StdDraw.setPenRadius(0.005);
    }
    public void addDataValue(double var){
        N++;
        total+=var;
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.point(N,var);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.point(N,total/N);
    }
    public double mean(){
        return total/N;
    }
    public String toString(){
        return "The num of data is "+N+".The mean of the data is "+mean();
    }




}
