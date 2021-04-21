package com.demo2.demo3;

import com.demo2.demo1.Insertion;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Cheung
 * @date 2021/4/10 8:37
 */
public class Quick {
    private static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi<=lo+10) {
            Insertion.sort(a);
            return;
        }
        int j=partition(a,lo,hi);
        sort(a,lo,j);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo,int hi){
        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while (true){
            while (less(a[++i],v)) if (i==hi) break;
            while (less(v,a[--j])) if (j==lo) break;
            if (i>=j) break;
            exch(a,i,j);
        }
        exch(a, lo, hi);
        return j;
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

    public static void main(String[] args) {
        String[] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
