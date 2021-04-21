package com.demo.demo1;

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.PrimMST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.rmi.StubNotFoundException;

/**
 * @author Cheung
 * @date 2021/2/8 16:55
 */
public class Exercise1_1 {
    private static void qus1(){
        //1.1.1
        System.out.println((0+15)/2);//7
        System.out.println(2.0e-6*100000000.1);//2.0e-6=2*10^-6=0.000002; res=200.0000002
        System.out.println(true&&false||true&&true);//true
    }
    private static void qus2(){
        //1.1.2
        System.out.println((1+2.236)/2);//double 1.618
        System.out.println(1+2+3+4.0);//double 10.0
        System.out.println(4.1>=4.0);//boolen true
        System.out.println(1+2+"3");//33 string拼接，非加法
    }
    private static void qus3(){
        //1.1.3 改进不限制输入数据的个数
        System.out.println("Please input  int-number:");
        int[] a=StdIn.readAllInts();
        boolean res=false;
        for (int i = 0; i < a.length; i++) {
            if (a[0]== a[i]) res=true;
            else  {
                res=false;
                break;
            }
        }
        if (res==true) System.out.println("Equal");
        else System.out.println("NotEqual");
    }
    private static void qus4(){
        //1.1.4
        int a=1;
        int b=2;
        int c=3;
        //if (a>b) then c=0;//err
//        if a>b {
//            c=0;
//        } //err
        if(a>b) c=0; else b=0;//可以将一个简单的条件语句写成一句，但是中间要有分号；
    }
    private static void qus5(){
        //1.1.5 已改进，不再限制输入数量
        boolean res=false;
        double[] a=StdIn.readAllDoubles();
        boolean[] just=new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i]<1&&a[i]>0)
                just[i]=true;
        }
        for (int i = 0; i < just.length-1; i++)
            res=just[i]&&just[i+1];

        System.out.println(res);
    }
    private static void qus6(){
        //1.1.6
        int f=0;
        int g=1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f=f+g;
            g=f-g;
        }
    }
    private static void qus7(){
        //1.1.7
        double t=9.0;
        while (Math.abs(t-9.0/t)>.001)
            t=(9.0/t+t)/2.0;
        StdOut.printf("%.5f\n",t);//保留五位小数，类型为double，不限制宽度

        int sum=0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        int sum1=0;
        for (int i = 0; i < 1000; i*=2) {
            for (int j = 0; j < 1000; j++) {
                 sum1++;
            }
        }
        StdOut.println(sum1);
    }
    private static void qus8(){
        //1.1.8
        System.out.println('b');//输出为b
        System.out.println('b'+'c');//输出为197
        System.out.println((char) ('a'+4));//输出为e：abcde就是a的地址加4为e的地址，再经过强转为e

    }
    // TODO: 2021/2/8 将这个简便算法研究一下
    private static void qus9(){
        //1.1.9 十进制转二进制的简洁算法
        int a=StdIn.readInt();
        String res="";
        for (int i=a;i>0;i/=2){
            res=(i%2)+res;
        }
        StdOut.println(res);

    }
    private static void qus11(){
        //1.1.11
        boolean[][] a=new boolean[5][5];
        String[][] b=new String[5][5];
        for (int i = 0; i < a.length; i++) {
            StdOut.println();
            for (int j = 0; j < a[i].length; j++) {
                StdOut.printf("%4s",j);
            }
            StdOut.println();
            StdOut.print(i);
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]==false) b[i][j]="&";
                else b[i][j]="*";
                StdOut.printf("%4s",b[i][j]);
            }
        }
    }
    private static void qus12(){
        //1.1.12
        int[] a=new int[10];
        for (int i=0;i<10;i++)
            a[i]=9-i;
        for (int i = 0; i < 10; i++)
            a[i]=a[a[i]];
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
    // TODO: 2021/2/8  研究一下这个算法的bug
    private static void qus13(){
        //1.1.13
        int[][] a = new int[4][3];
        int[][] b=new int[3][4];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i;
            StdOut.printf("%3d",a[i][j]);
            }
            StdOut.println();
        }
        for (int i = 0; i < a[i].length; i++) {
            for (int j = 0; j < a.length-1; j++) {
                int num=a[i][j];
                b[j][i]=num;
                StdOut.printf("%3d",b[j][i]);
            }
            StdOut.println();

        }


    }
    private static int[] qus15(int[] a,int key) {
        //1.1.15
        int[] b=new int[key];//创建跟传入的M的一样大的数组
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++)
                if (a[j]==i) b[i]++;
        }//赋值要返回的数组值，用i填充
        return b;
    }
    private static void qus21(){
        //1.1.21
        StdOut.println("Please input the sum members of your table");
        int length=StdIn.readInt();
        int[] a=new int[length];//我们创建以输入人数为长度的数组来记录他们的信息
        int[] score1=new int[length];
        int[] score2=new int[length];
        double[] average=new double[length];
        String[] name=new String[length];
        for (int i = 0; i <length; i++) {
            a[i]=i;
            StdOut.println("Please input the name of the ID "+i);//输入第i个人的名字
            name[i]=StdIn.readString();//将输入的名字存储在字符串数组对应的位置上
            StdOut.println("Please input the first score of ID"+i);//输入第i个人的第一项成绩
            score1[i]=StdIn.readInt();//将其存储在成绩1的数组对应位置
            StdOut.println("Please input the second score of ID"+i);//输入第i个人的第二项成绩
            score2[i]=StdIn.readInt();//将其存储在成绩2的数组对应位置
            average[i]=score1[i]/score2[i];//将成绩1/成绩2的结果存在这个平均值数组的对应位置上
        }
        for (int i = 0; i < length; i++) {
            StdOut.printf("%5s",name[i]);//输出名字
            StdOut.printf("%5d",score1[i]);//输出成绩1
            StdOut.printf("%5d",score2[i]);//输出成绩2
            StdOut.printf("%7.3f\n",average[i]);//输出平均值后换行，再次记录下一个人的成绩
        }




    }

    public static void main(String[] args) {
//        qus1();
//        qus2();
//        qus3();
//        qus5();
//        qus6();
//        qus7();
//        qus8();
//        qus9();
//        qus12();
//        qus13();
//        int[] a={1,2,3,4,5,5,4,3,2,1,0};
//        int b=4;
//        int[] res=qus15(a,b);
//        for (int i = 0; i < res.length; i++)
//            StdOut.print(res[i]);
        qus21();
    }
}
