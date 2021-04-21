package com.demo.demo2;

import com.demo.demo1.TestDraw;

import java.util.Arrays;

/**
 * @author Cheung
 * @date 2021/3/23 8:31
 */
public class StaticsSETofInts {
//    int[] dataToOperation;
//    int los;
//    int head;
//    boolean index;
//
//    public StaticsSETofInts(int[] a){
//        Arrays.sort(a);
//        dataToOperation=a;
//        head=dataToOperation.length-1;
//        los=0;
//    }
//
//    public boolean contains(int a){
//        if(a>dataToOperation[head]||a<dataToOperation[los]) return false;
//        else return judgmentData(los,head,a);
//    }
//
//    private boolean judgmentData(int los,int head,int a) {
//        while (index== false){
//            if(a<dataToOperation[head/2]) head=head/2;
//            if (a>dataToOperation[head/2]) los=head/2;
//            if (a==dataToOperation[head/2]) index=true;
//
//            judgmentData(los,head,a);
//
//
//        }
//    }
    private int[] a;
    public StaticsSETofInts(int[] keys){
        a=new int[keys.length];
        for (int i = 0; i < keys.length; i++) {
            a[i] = keys[i];//保护性复制
            Arrays.sort(a);
        }
    }
    public boolean contains(int key){
        return rank(key) !=-1;
    }
    private int rank(int key){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(key<a[mid]) hi=mid-1;
            if (key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -1;
    }

}
