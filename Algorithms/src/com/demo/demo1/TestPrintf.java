package com.demo.demo1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Cheung
 * @date 2021/2/5 9:55
 */
public class TestPrintf {
    //下面使用Stu标准库来测试其内部的格式化输出API(测试成功)
    public static void test(String[] args) {
        int N=Integer.parseInt(args[0]);
        double ol=Double.parseDouble(args[1]);
        double hi=Double.parseDouble(args[2]);
        for (int i=0;i<N;i++){
            double x= StdRandom.uniform(ol,hi);
            StdOut.printf("%.2f\n",x);
        }
    }
    public static void main(String[] args) {
        String[] testStr={"5","100.0","200.0"};
        test(testStr);
    }


}
