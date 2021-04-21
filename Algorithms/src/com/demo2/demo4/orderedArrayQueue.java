package com.demo2.demo4;

import java.security.Key;
import java.sql.Array;

/**
 * @author Cheung
 * @date 2021/4/14 7:56
 */
public class orderedArrayQueue {
    Key[] array;
    int arrayIndex;

    public orderedArrayQueue(){
        array=new Key[0];
    }
    public orderedArrayQueue(int max){
        array=new Key[max];
    }
    public orderedArrayQueue(Key[] a){
        for (int i = 0; i < a.length; i++)
            array[i]=a[i];
    }
    void Insert(Key v){
        if (arrayIndex<=array.length-2) {
            if (Integer.parseInt(v.toString()) >= Integer.parseInt(array[arrayIndex].toString())) {
                array[++arrayIndex] = v;
                arrayIndex++;
            } else if (Integer.parseInt(v.toString()) <= Integer.parseInt(array[arrayIndex].toString())) {
                array[++arrayIndex] = v;
                exch(array, arrayIndex, arrayIndex - 1);
                arrayIndex++;
            }
        }else {
            if (Integer.parseInt(v.toString()) > Integer.parseInt(array[arrayIndex].toString())) {
                arrayIndex--;
                array[++arrayIndex] = v;
                arrayIndex++;
            }
        }

    }
    private void exch(Key[]a,int v,int u){
        Key num= a[v];a[v]=a[u];a[u]=num;
    }
    public Key max(){
        return array[arrayIndex];
    }
    public Key delMax(){
        Key num=array[arrayIndex];
        arrayIndex--;
        return num;
    }
    public boolean isEmpty(){
        return arrayIndex<=0;
    }
    public int size(){
        return arrayIndex;
    }
    private int comparisonOfSize(Key v){
        for (int i = 0; i < array.length-1; i++) {
            if (Integer.parseInt(v.toString()) < Integer.parseInt(array[i].toString())) return 0;
            else if(Integer.parseInt(v.toString()) <= Integer.parseInt(array[arrayIndex].toString())&&Integer.parseInt(v.toString())>Integer.parseInt(array[i+1].toString())) return i;
        }
        return -1;
    }




}
