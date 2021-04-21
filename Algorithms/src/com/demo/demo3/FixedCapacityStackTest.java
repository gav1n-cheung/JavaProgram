package com.demo.demo3;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author Cheung
 * @date 2021/3/27 9:40
 */
public class FixedCapacityStackTest {

    public static void main(String[] args) {
        FixedCapacityStack test=new FixedCapacityStack(100);
        while (!StdIn.isEmpty()){
            String s=StdIn.readString();
            if (!s.equals("-"))
                test.push(s);
            else if (!s.isEmpty())
                System.out.println(test.pop()+" ");
        }
        //添加了迭代后可以使用foreach来历数数据类型
        for (Object i:test){

        }
        System.out.println("("+test.size()+"left on stack");
    }

}
