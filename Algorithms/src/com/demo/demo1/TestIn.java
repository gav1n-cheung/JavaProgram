package com.demo.demo1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/2/5 10:52
 */
public class TestIn {
    //测试标准输入（测试成功）
    public static void main(String[] args) {
        double sum=0.0;
        int cut=0;
        while (!StdIn.isEmpty()){
            sum+=StdIn.readDouble();
            cut++;
        }
        double avg=sum/cut;
        StdOut.printf("平均值为%.2f",avg);
    }
}
