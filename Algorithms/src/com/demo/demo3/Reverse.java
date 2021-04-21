package com.demo.demo3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author Cheung
 * @date 2021/3/26 9:05
 */
public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> test= new Stack<Integer>();

        while (!StdIn.isEmpty())
            test.push(StdIn.readInt());

        int[] stackInts=new int[test.size()];

        for (int i :test) {
            System.out.println(i);//这里输出的应该是i---i这里并不是自增的int类型，而是test的元素标记，是test中的第i个元素
        }
    }
}
