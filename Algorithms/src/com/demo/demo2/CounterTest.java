package com.demo.demo2;

import edu.princeton.cs.algs4.StdOut;

import javax.naming.Name;

/**
 * @author Cheung
 * @date 2021/3/9 9:05
 */
public class CounterTest {

    //实例变量
    private final String name;//利用构造函数CounterTest来初始化name，
    private int theDataFromUser;//count将会被初始化为默认值0

    //构造函数：public（可见性修饰符） （无指定返回值） Counter（构造函数名称==类名） （String id）（参数变量 签名）
    public CounterTest(String id){
        name=id;
    }

    //实例方法
    public void increment(){
        theDataFromUser++;
    }
    public int tally(){
        return theDataFromUser;
    }
    public String toString(){
        return theDataFromUser+""+name;
    }

    //测试用例
    public static void main(String[] args) {
        //创建并初始化对象，触发构造函数
        CounterTest heads=new CounterTest("heads");
        CounterTest tails=new CounterTest("tails");


        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads+""+tails);//仅使用heads就可以自动调用toString函数
        StdOut.println(heads.tally()+""+tails.tally());


    }


}
