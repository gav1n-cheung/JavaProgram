package com.demo.demo3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author Cheung
 * @date 2021/3/25 10:20
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<String>();
        stack.push("Test");
        String next=stack.pop();//将从栈内压出的String赋值给了next，此时栈内为空
        System.out.println(next);
    }

    private void automaticBoxing(){
        Stack<Integer> test=new Stack<Integer>();
        test.push(17);//自动装箱--将原始数据类型int装箱成封装类型Integer
        int i= test.pop();//自动拆箱--将Integer拆箱成为int原始数据类型
    }



}
