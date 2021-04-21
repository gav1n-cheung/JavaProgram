package com.demo.demo2;

import edu.princeton.cs.algs4.Point2D;



/**
 * @author Cheung
 * @date 2021/3/24 9:38
 */
public class ex1 {
    public static void main(String[] args) {
        int N=Integer.parseInt("100");
        Point2D[] points=new Point2D[N];

        for (int i = 0; i < points.length; i++) {
            points[i]= new Point2D(Math.random(),Math.random());
            points[i].draw();
        }
        if (N>1)
        {
            double min=points[0].distanceTo(points[1]);
            for (int i = 0; i < points.length; i++) {
                for (int j = 0; j < points.length; j++) {
                    if (points[i]!=points[j]){
                        min=points[i].distanceTo(points[j]);
                    }
                }
                System.out.println("当前点"+i+"与其他点的最近距离为"+min);

            }
        }

    }

}
