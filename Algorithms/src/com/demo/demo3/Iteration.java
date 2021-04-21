package com.demo.demo3;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Cheung
 * @date 2021/3/28 8:34
 */
public class Iteration {
    public static void main(String[] args) {
        Stack<String> collection=new Stack<String>();
        for (String s:collection) {
            System.out.println(s);
        }
        //上面的foreach就是while语句的一种简写方式（类似于for语句），他和下面的while语句是等价的
        Iterator<String> i=collection.iterator();
        while (i.hasNext()){
            String s=i.next();
            System.out.println(i);
        }
        //上面这段代码展示了一些在任意可迭代的集合数据类型中我们都需要实现的东西：
        //（1）集合数据类型必须实现一个iterator()方法并且返回一个Iterator对象
        //(2)Iterator类必须包含两个方法：hasNext（）--返回一个bool值和next（）--返回集合中的一个泛型元素

    }
}
