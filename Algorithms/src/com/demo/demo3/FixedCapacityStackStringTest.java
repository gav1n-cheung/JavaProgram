package com.demo.demo3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Cheung
 * @date 2021/3/27 8:26
 */
public class FixedCapacityStackStringTest {
    public static void main(String[] args) {
        FixedCapacityStackString test=new FixedCapacityStackString(100);
        while (!StdIn.isEmpty()){
            String item= StdIn.readString();
            if (!item.equals("-")) test.push(item);
            else if (!test.isEmpty()) System.out.println(test.pop()+" ");
        }

        System.out.println("("+test.size()+"left on stack()");
    }
}
