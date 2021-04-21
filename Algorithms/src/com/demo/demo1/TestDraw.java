package com.demo.demo1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * @author Cheung
 * @date 2021/2/5 11:07
 */
public class TestDraw {
    //测试标准绘图库，测试成功
    public static void main(String[] args) {
//        StdDraw.line(0,0,1,1);
//        StdDraw.square(0.5,0.5,0.3);
//        StdDraw.circle(0.5,0.5,0.3);
//        double[] x={0.1,0.3,0.5,0.3};
//        double[] y={0.5,0.1,0.3,0.1};
//        StdDraw.polygon(x,y);
//        FunctionDraw();
        //RandomDraw();
        ArraysDraw();
    }
    //绘制函数图像，测试成功
    private static void FunctionDraw(){
        int n=100;
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(0,n*n);
        for (int i = 1; i <= n; i++) {
             StdDraw.point(i,i);//绘制y=x的图像
            StdDraw.point(i,i*i);//绘制y=x^2的图像
            StdDraw.point(i,i*Math.log(i));//绘制y=logx的图像

        }
    }
    //绘制随机数组，测试成功
    private static void RandomDraw(){
        int N=50;
        double[] a=new double[N];
        for (int i=0;i<N;i++)
            a[i]= StdRandom.uniform();
        for (int i = 0; i < a.length; i++) {
            double x=1.0*i/N;
            double y=a[i]/20;
            double rw=0.5/N;
            double rh=a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }
    }
    //绘制排序完毕的随机数组，测试成功
    private static void ArraysDraw(){
        int N=50;
        double[] a=new double[N];
        for (int i=0;i<N;i++)
            a[i]=StdRandom.uniform();
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            double x=1.0*i/N;
            double y=a[i]/20;
            double rw=0.5/N;
            double rh=a[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
        }

    }


}
