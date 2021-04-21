package com.demo.demo2;

import edu.princeton.cs.algs4.*;

/**
 * @author Cheung
 * @date 2021/3/5 10:11
 */
public class Interval2DTest {

    public static void main(String[] args) {
        //定义x和y的取值范围
        double xlo=Double.parseDouble(".2");
        double xhi=Double.parseDouble(".5");
        double ylo=Double.parseDouble(".5");
        double yhi=Double.parseDouble(".6");
        //点的总量
        int T=Integer.parseInt("10000");

        //绘制一个间隔（长方形坐标为（0.2,0.5）（0.2，0.6）（0.5，0.5）（0.5，0.6））横向直线为0.3长，高为0.1长
        Interval1D xinterval=new Interval1D(xlo,xhi);
        Interval1D yinterval=new Interval1D(ylo,yhi);
        Interval2D box=new Interval2D(xinterval,yinterval);
        box.draw();

        //计数器
        Counter c=new Counter("hits");
        //随机产生点
        for (int i = 0; i < T; i++) {
            double x=Math.random();
            double y=Math.random();

            Point2D p=new Point2D(x,y);
            //若p在长方形内，则计数器加一，否则绘制出该点
            if(box.contains(p)) c.increment();
            else p.draw();
        }
        //输出计数器的值
        StdOut.println(c);
        //输出长方形的面积
        StdOut.println(box.area());

    }
    //该方法将面积问题转换为了点的计数，比如我们上面的main函数使用了10000个点，而在图形内的为277个点，而绘图区域默认为单位正方形，则我们可以估计图形面积为277/10000=0.0277和使用库函数计算的面积有一定误差，
    // 但可以大体的反应出图形的面积

}
