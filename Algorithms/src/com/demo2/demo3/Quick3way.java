package com.demo2.demo3;

import java.beans.beancontext.BeanContextServicesListener;

/**
 * @author Cheung
 * @date 2021/4/13 7:59
 */
public class Quick3way {
    public static void sort(Comparable[] a,int hi,int lo){
        if (hi<=lo) return;
        int lt=lo,gt=hi,i=lo+1;
        Comparable v=a[lo];
        while (i<=gt){
            int cmp=a[i].compareTo(v);
            if (cmp<0) exch(a,lt++,i++);
            else if (cmp>0) exch(a,i,gt--);
            else i++;
        }
        sort(a,lt-1,lo);
        sort(a,gt+1,hi);
    }
    public static void exch(Comparable[] a,int u,int v){
        Comparable t=a[u];a[u]=a[v];a[v]=t;
    }

}
