package com.demo2.demo2;

import edu.princeton.cs.algs4.Merge;

/**
 * @author Cheung
 * @date 2021/4/8 10:28
 */
public class MergeBU {
    private static Comparable[] aux;
    public static void sort(Comparable[] a){
        int N=a.length;
        aux=new Comparable[N];
        for (int sz = 1; sz < N; sz+=sz)
            for (int lo = 0; lo < N-sz; lo+=sz+sz)
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }
    public static void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;
        for (int k = lo; k <= hi; k++)
            aux[k]=a[k];
        for (int k = lo; k <=hi ; k++) {
            if (i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i] )) a[k]=aux[i++];
            else a[k]=aux[i++];
        }
    }
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }


}
