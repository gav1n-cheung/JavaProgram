package com.demo2.demo1;

import com.demo.demo4.StopWatch;
import edu.princeton.cs.algs4.In;

/**
 * @author Cheung
 * @date 2021/4/6 8:29
 */
public class Insertion {

    public static void sort(Comparable[] a){
        int N= a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0&&less(a[j],a[j-1]); j--) {
 //               exchange(a,j);
                exch(a,j,j-1);
            }

        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];a[i]=a[j];a[j]=t;
    }
    private static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i]);
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++)
            if (less(a[i],a[i+1])) return false;
        return true;
    }
//    private static void exchange(Comparable[] a,int i){
//        Comparable t=a[i];a[i]=a[i+1];a[i+1]=t;
//    }

    public static void main(String[] args) {
        String[] a= In.readStrings();
        StopWatch test=new StopWatch();
        sort(a);
        double time = test.elapsestart();
        System.out.println("运行时间："+time);
        assert isSorted(a);
        show(a);
    }

}
