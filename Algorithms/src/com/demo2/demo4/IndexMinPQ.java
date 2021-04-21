package com.demo2.demo4;

import java.security.Key;
import com.demo2.demo4.MaxPQ;
/**
 * @author Cheung
 * @date 2021/4/15 10:38
 */
public class IndexMinPQ <Key extends Comparable<Key>>{
    private Key[] array;
    int N;

    public IndexMinPQ(int maxN){ array=(Key[]) new Comparable[maxN+1];}
    public void sort(Comparable[] a){
        int N=a.length;
        for (int k = N/2; k >= 1; k--)
            sink(a,k,N);
        while (N>1){
            exch(1,N--);
            sink(a,1,N);
        }

    }
    public void sink(Comparable[] a,int k,int N){
        while (2*k<=N){
            int j=2*k;
            if (j<N&&less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(j,k);
            k=j;
        }
    }
    private boolean less(int i,int j){ return array[i].compareTo(array[j])<0; }
    private void exch(int i,int j){ Key num=array[i];array[i]=array[j];array[j]=num; }


}
